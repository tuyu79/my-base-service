package com.turan.service;

import com.turan.bo.Vehicle;
import com.turan.common.BizException;
import com.turan.common.RespCode;
import com.turan.dao.VehicleInfoDAO;
import com.turan.po.VehicleInfo;
import com.turan.po.VehicleInfoExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService
{
    @Autowired
    private VehicleInfoDAO vehicleInfoDAO;
    @Autowired
    private GlobalSequenceService globalSequenceService;

    public void add(Vehicle vehicle)
    {

        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setVehicleNo(globalSequenceService.nextId());
        vehicleInfo.setCarLicense(vehicle.getCarLicense());
        vehicleInfo.setPlateColor(vehicle.getPlateColor());
        vehicleInfo.setVehicleVin(vehicle.getVehicleVin());
        vehicleInfo.setDriverNo(vehicle.getDriverNo());
        vehicleInfo.setTransportNo(vehicle.getTransportNo());
        vehicleInfo.setVehicleType(vehicle.getVehicleType());
        vehicleInfo.setGroupNo(vehicle.getGroupNo());
        vehicleInfo.setAreaCode(vehicle.getAreaCode());
        vehicleInfo.setCreateAt(new Date());
        vehicleInfo.setUpdateAt(new Date());

        vehicleInfoDAO.insert(vehicleInfo);
    }

    public Optional<Vehicle> get(Long vehicleNo)
    {
        VehicleInfoExample example = new VehicleInfoExample();
        example.createCriteria().andVehicleNoEqualTo(vehicleNo);

        List<VehicleInfo> VehicleInfos = vehicleInfoDAO.selectByExample(example);

        if(CollectionUtils.isEmpty(VehicleInfos))
        {
            return Optional.empty();
        }

        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(VehicleInfos.get(0),vehicle);
        return Optional.of(vehicle);
    }

    public void delete(Long vehicleNo)
    {
        VehicleInfoExample example = new VehicleInfoExample();
        example.createCriteria().andVehicleNoEqualTo(vehicleNo);

        vehicleInfoDAO.deleteByExample(example);
    }

    public Vehicle update(Vehicle vehicle)
    {
        if (vehicle.getVehicleNo() == null)
        {
            throw new BizException(RespCode.INVALID_PARAMS,"vehicleNo can't be null");
        }

        VehicleInfoExample example = new VehicleInfoExample();
        example.createCriteria().andVehicleNoEqualTo(vehicle.getVehicleNo());

        VehicleInfo vehicleInfo = new VehicleInfo();
        BeanUtils.copyProperties(vehicle,vehicleInfo);

        vehicleInfoDAO.updateByExampleSelective(vehicleInfo,example);

        return vehicle;
    }
}
