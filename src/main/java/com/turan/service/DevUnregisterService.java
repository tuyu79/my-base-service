package com.turan.service;

import com.turan.dao.DevInfoDAO;
import com.turan.dao.VehicleDeviceBindingsDAO;
import com.turan.po.DevInfo;
import com.turan.po.DevInfoExample;
import com.turan.po.VehicleDeviceBindingsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DevUnregisterService
{
    @Autowired
    private DevInfoDAO devInfoDAO;
    @Autowired
    private VehicleDeviceBindingsDAO vehicleDeviceBindingsDAO;

    public void onUnRegister(String mobile, Long vehicleNo)
    {
        DevInfoExample devInfoExample = new DevInfoExample();
        devInfoExample.createCriteria().andSimCardNoEqualTo(mobile);

        List<DevInfo> devInfos = devInfoDAO.selectByExample(devInfoExample);
        if(CollectionUtils.isEmpty(devInfos)){
            return;
        }

        VehicleDeviceBindingsExample example = new VehicleDeviceBindingsExample();
        example.createCriteria().andDevNoEqualTo(devInfos.get(0).getDevNo())
                .andVehicleNoEqualTo(vehicleNo);

        vehicleDeviceBindingsDAO.deleteByExample(example);
    }
}
