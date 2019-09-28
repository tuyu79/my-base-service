package com.turan.service;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.turan.dao.DevInfoDAO;
import com.turan.dao.VehicleDeviceBindingsDAO;
import com.turan.enums.CommonResultEnum;
import com.turan.mq.bo.VehicleOnlineMsg;
import com.turan.po.DevInfo;
import com.turan.po.DevInfoExample;
import com.turan.po.VehicleDeviceBindings;
import com.turan.po.VehicleDeviceBindingsExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DevAuthService
{

    @Autowired
    private DevInfoDAO devInfoDAO;
    @Autowired
    private VehicleDeviceBindingsDAO vehicleDeviceBindingsDAO;
    @Resource
    private MessageChannel output3;
    @Resource
    private MessageChannel output4;

    private Object mutex = new Object();
    private BiMap<Integer/* channel id*/, Long/*vehicle no*/> onlineTable = Maps.synchronizedBiMap(HashBiMap.create());
    private BiMap<Long/*vehicle no*/, String /* mobile no*/> mobileTable = Maps.synchronizedBiMap(HashBiMap.create());

    public CommonResultEnum onAuth(Integer channelId, String mobile, String authCode)
    {

        DevInfoExample example = new DevInfoExample();
        example.createCriteria().andSimCardNoEqualTo(mobile);

        List<DevInfo> devInfos = devInfoDAO.selectByExample(example);

        if (CollectionUtils.isEmpty(devInfos))
        {
            log.error("dev info not exist! mobile : [{}]", mobile);
            return CommonResultEnum.FAIL;
        }

        DevInfo devInfo = devInfos.get(0);

        if (StringUtils.isNoneBlank(authCode, devInfo.getAuthCode()) && authCode.equals(devInfo.getAuthCode()))
        {
            VehicleDeviceBindingsExample bindingsExample = new VehicleDeviceBindingsExample();
            bindingsExample.createCriteria().andDevNoEqualTo(devInfo.getDevNo());

            List<VehicleDeviceBindings> bindings = vehicleDeviceBindingsDAO.selectByExample(bindingsExample);

            if (CollectionUtils.isEmpty(bindings))
            {
                log.error("vehicle info not exist! devNo : [{}]", devInfo.getDevNo());
                return CommonResultEnum.FAIL;
            }

            // todo turan 分布式缓存
            synchronized (mutex)
            {
                onlineTable.forcePut(channelId, bindings.get(0).getVehicleNo());
                mobileTable.forcePut(bindings.get(0).getVehicleNo(), devInfo.getSimCardNo());
            }

            sendOnlineMsg(bindings.get(0).getVehicleNo());
            return CommonResultEnum.SUCCESS;
        }
        return CommonResultEnum.FAIL;
    }

    public void offline(Integer channelId)
    {
        synchronized (mutex)
        {
            Long vehicleNo = onlineTable.remove(channelId);
            mobileTable.remove(vehicleNo);
        }
    }

    private void sendOnlineMsg(Long vehicleNo)
    {
        VehicleOnlineMsg vehicleOnlineMsg = new VehicleOnlineMsg();
        vehicleOnlineMsg.setVehicleNo(vehicleNo);

        Message message = MessageBuilder.createMessage(vehicleOnlineMsg, new MessageHeaders(ImmutableMap.of()));
        output3.send(message);
    }

    public Boolean isOnline(Integer channelId)
    {
        return onlineTable.get(channelId) != null;
    }

    public Optional<Integer> getOnlineChannelIdByVehicleNo(Long vehicleNo)
    {
        return Optional.ofNullable(onlineTable.inverse().get(vehicleNo));
    }

    public Long getVehicleNoByChannelId(int channelId)
    {
        return onlineTable.get(channelId);
    }

    public void disConnected(Integer channelId)
    {
        Long vehicleNo = onlineTable.remove(channelId);
        sendOfflineMsg(vehicleNo);
    }

    private void sendOfflineMsg(Long vehicleNo)
    {
        VehicleOnlineMsg vehicleOnlineMsg = new VehicleOnlineMsg();
        vehicleOnlineMsg.setVehicleNo(vehicleNo);

        Message message = MessageBuilder.createMessage(vehicleOnlineMsg, new MessageHeaders(ImmutableMap.of()));
        output4.send(message);
    }

    public String getMobileByVehicleNo(Long vehicleNo)
    {
        return mobileTable.get(vehicleNo);
    }
}
