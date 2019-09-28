package com.turan.service;

import com.turan.bo.Device;
import com.turan.bo.Vehicle;
import com.turan.dao.DevInfoDAO;
import com.turan.po.DevInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DeviceService
{
    @Autowired
    private DevInfoDAO devInfoDAO;
    @Autowired
    private GlobalSequenceService globalSequenceService;

    public void add(Device device)
    {
        DevInfo devInfo = new DevInfo();
        devInfo.setDevNo(globalSequenceService.nextId());
        devInfo.setSimCardNo(device.getSimCardNo());
        devInfo.setDevType(device.getDevType());
        devInfo.setDevId(device.getDevId());
        devInfo.setChannelCount(device.getChannelCount());
        devInfo.setChannelEnabled(device.getChannelEnabled());
        devInfo.setProtocolType(device.getProtocolType());
        devInfo.setCreateAt(new Date());
        devInfo.setUpdateAt(new Date());

        devInfoDAO.insert(devInfo);
    }

    public Optional<Vehicle> get(Long vehicleNo)
    {
        return Optional.empty();
    }

    public void delete(Long vehicleNo)
    {
    }

    public Vehicle update(Vehicle vehicle)
    {
        return null;
    }
}
