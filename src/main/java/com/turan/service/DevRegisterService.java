package com.turan.service;

import com.turan.dao.DevInfoDAO;
import com.turan.dao.VehicleDeviceBindingsDAO;
import com.turan.dao.VehicleInfoDAO;
import com.turan.enums.PlateColorEnum;
import com.turan.enums.RegisterResult;
import com.turan.po.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DevRegisterService
{
    @Autowired
    private VehicleInfoDAO vehicleInfoDAO;
    @Autowired
    private DevInfoDAO devInfoDAO;
    @Autowired
    private VehicleDeviceBindingsDAO vehicleDeviceBindingsDAO;
    @Autowired
    private GlobalSequenceService sequenceService;

    public Pair<RegisterResult, String> onRegister(int plateColor, String vehicleMark, String devId)
    {
        Optional<VehicleInfo> vehicleInfo = queryVehicle(plateColor, vehicleMark);
        if (!vehicleInfo.isPresent())
        {
            return Pair.of(RegisterResult.VEHICLE_NOT_EXIST, null);
        }

        Optional<DevInfo> devInfo = queryDev(devId);
        if (!devInfo.isPresent())
        {
            return Pair.of(RegisterResult.DEV_NOT_EXIST, null);
        }

        Optional<VehicleDeviceBindings> vehicleBinding = queryBindings(vehicleInfo.get().getVehicleNo(), null);

        if (vehicleBinding.isPresent() && !vehicleBinding.get().getDevNo().equals(devInfo.get().getDevNo()))
        {
            return Pair.of(RegisterResult.VEHICLE_HAS_BEEN_REGISTERED, null);
        }

        Optional<VehicleDeviceBindings> deviceBindings = queryBindings(null, devInfo.get().getDevNo());

        if (deviceBindings.isPresent() && !deviceBindings.get().getVehicleNo().equals(vehicleInfo.get().getVehicleNo()))
        {
            return Pair.of(RegisterResult.DEV_HAS_BEEN_REGISTERED, null);
        }

        if (!vehicleBinding.isPresent() && !deviceBindings.isPresent())
        {
            VehicleDeviceBindings newBinding = new VehicleDeviceBindings();
            newBinding.setBindingNo(sequenceService.nextId());
            newBinding.setVehicleNo(vehicleInfo.get().getVehicleNo());
            newBinding.setDevNo(devInfo.get().getDevNo());
            newBinding.setCreateAt(new Date());

            vehicleDeviceBindingsDAO.insert(newBinding);
        }

        DevInfo devInfo1 = devInfo.get();
        devInfo1.setAuthCode(getAuthCode());
        devInfoDAO.updateByPrimaryKeySelective(devInfo1);

        return Pair.of(RegisterResult.SUCCESS, devInfo1.getAuthCode());
    }

    private Optional<VehicleDeviceBindings> queryBindings(Long vehicleNo, Long deviceNo)
    {
        VehicleDeviceBindingsExample example = new VehicleDeviceBindingsExample();
        VehicleDeviceBindingsExample.Criteria criteria = example.createCriteria();
        if (vehicleNo != null)
        {
            criteria.andVehicleNoEqualTo(vehicleNo);
        } else
        {
            criteria.andDevNoEqualTo(deviceNo);
        }

        List<VehicleDeviceBindings> vehicleDeviceBindings = vehicleDeviceBindingsDAO.selectByExample(example);
        if (!CollectionUtils.isEmpty(vehicleDeviceBindings))
        {
            return Optional.of(vehicleDeviceBindings.get(0));
        }

        return Optional.empty();
    }

    private String getAuthCode()
    {
        return RandomStringUtils.random(15,"abcdefgABCDEFG123456789");
    }

    private Optional<DevInfo> queryDev(String devId)
    {
        DevInfoExample DevInfoExample = new DevInfoExample();
        DevInfoExample.createCriteria().andDevIdEqualTo(devId);
        List<DevInfo> DevInfos = devInfoDAO.selectByExample(DevInfoExample);
        if (CollectionUtils.isEmpty(DevInfos))
        {
            return Optional.empty();
        } else
        {
            return Optional.of(DevInfos.get(0));
        }
    }

    private Optional<VehicleInfo> queryVehicle(int plateColor, String vehicleMark)
    {
        VehicleInfoExample example = new VehicleInfoExample();
        VehicleInfoExample.Criteria criteria = example.createCriteria();

        if (plateColor == PlateColorEnum.NONE.getCode())
        {
            criteria.andVehicleVinEqualTo(vehicleMark);
        } else
        {
            criteria.andCarLicenseEqualTo(vehicleMark);
        }

        List<VehicleInfo> vehicleInfos = vehicleInfoDAO.selectByExample(example);

        if (CollectionUtils.isEmpty(vehicleInfos))
        {
            return Optional.empty();
        }
        return Optional.of(vehicleInfos.get(0));
    }
}
