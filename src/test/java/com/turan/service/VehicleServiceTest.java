package com.turan.service;

import com.turan.bo.Vehicle;
import com.turan.dao.VehicleInfoDAO;
import com.turan.po.VehicleInfo;
import com.turan.po.VehicleInfoExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest
{

    @InjectMocks
    private VehicleService  vehicleService;
    @Mock
    private VehicleInfoDAO vehicleInfoDAO;
    @Mock
    private GlobalSequenceService globalSequenceService;


    @Test
    public void whenAddVehicleThenSuccess()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setCarLicense("测A0001");
        vehicle.setPlateColor(2);
        vehicle.setVehicleVin("ABCDEFGHIJK");
        vehicle.setDriverNo(123457L);
        vehicle.setTransportNo("123458");
        vehicle.setGroupNo(123459L);
        vehicle.setAreaCode(123460);
        vehicle.setVehicleType(1);

        vehicleService.add(vehicle);

        verify(globalSequenceService,times(1)).nextId();
        verify(vehicleInfoDAO,times(1)).insert(any(VehicleInfo.class));
    }

    @Test
    public void whenGetByVehicleNoThenSuccess()
    {
        vehicleService.get(123456L) ;
        verify(vehicleInfoDAO,times(1)).selectByExample(any(VehicleInfoExample.class));
    }

    @Test
    public void whenDeleteByVehicleNoThenSuccess()
    {
        vehicleService.delete(123456L);
        verify(vehicleInfoDAO,times(1)).deleteByExample(any(VehicleInfoExample.class));
    }

    @Test
    public void whenUpdateThenSuccess()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNo(123L);
        vehicle.setCarLicense("测A0001");
        vehicle.setPlateColor(2);
        vehicle.setVehicleVin("ABCDEFGHIJK");
        vehicle.setDriverNo(123457L);
        vehicle.setTransportNo("123458");
        vehicle.setGroupNo(123459L);
        vehicle.setAreaCode(123460);
        vehicle.setVehicleType(1);

        vehicleService.update(vehicle);

        verify(vehicleInfoDAO,times(1))
                .updateByExampleSelective(any(VehicleInfo.class),any(VehicleInfoExample.class));
    }
}