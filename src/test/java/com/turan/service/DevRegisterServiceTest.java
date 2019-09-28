package com.turan.service;

import com.turan.dao.DevInfoDAO;
import com.turan.dao.VehicleDeviceBindingsDAO;
import com.turan.dao.VehicleInfoDAO;
import com.turan.enums.RegisterResult;
import com.turan.po.*;
import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DevRegisterServiceTest
{
    @InjectMocks
    private DevRegisterService registerService;

    @Mock
    private VehicleInfoDAO vehicleInfoDAO;
    @Mock
    private DevInfoDAO devInfoDAO;
    @Mock
    private VehicleDeviceBindingsDAO vehicleDeviceBindingsDAO;
    @Mock
    private GlobalSequenceService sequenceService;


    @Test
    public void whenVehicleNotExistThenReturn2()
    {
        doReturn(null).when(vehicleInfoDAO).selectByExample(any(VehicleInfoExample.class));

        Pair<RegisterResult, String> registerResult = registerService.onRegister(1, "123", "123");

        assertThat(registerResult, is(Pair.of(RegisterResult.VEHICLE_NOT_EXIST,null)));
    }

    @Test
    public void whenVehicleHasBeenRegisteredThenReturn1()
    {
        List<VehicleInfo> vehicleInfos = Lists.newArrayList();
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setVehicleNo(1L);
        vehicleInfos.add(vehicleInfo);

        List<DevInfo> devInfos = Lists.newArrayList();
        DevInfo devInfo = new DevInfo();
        devInfo.setDevNo(2L);
        devInfos.add(devInfo);

        List<VehicleDeviceBindings> bindings = Lists.newArrayList();
        VehicleDeviceBindings vehicleDeviceBindings = new VehicleDeviceBindings();
        vehicleDeviceBindings.setVehicleNo(1L);
        vehicleDeviceBindings.setDevNo(3L);
        bindings.add(vehicleDeviceBindings);

        doReturn(vehicleInfos).when(vehicleInfoDAO).selectByExample(any(VehicleInfoExample.class));
        doReturn(devInfos).when(devInfoDAO).selectByExample(any(DevInfoExample.class));
        when(vehicleDeviceBindingsDAO.selectByExample(any(VehicleDeviceBindingsExample.class)))
                .thenReturn(bindings);

        Pair<RegisterResult, String> registerResult = registerService.onRegister(1, "123", "123");

        assertThat(registerResult, is(Pair.of(RegisterResult.VEHICLE_HAS_BEEN_REGISTERED,null)));
    }

    @Test
    public void whenDevNotExistThenReturn4()
    {
        List<VehicleInfo> vehicleInfos = Lists.newArrayList();
        VehicleInfo VehicleInfo = new VehicleInfo();
        vehicleInfos.add(VehicleInfo);

        doReturn(vehicleInfos).when(vehicleInfoDAO).selectByExample(any(VehicleInfoExample.class));
        doReturn(null).when(devInfoDAO).selectByExample(any(DevInfoExample.class));

        Pair<RegisterResult, String> registerResult = registerService.onRegister(1, "123", "123");

        assertThat(registerResult, is(Pair.of(RegisterResult.DEV_NOT_EXIST,null)));
    }

    @Test
    public void whenDevHasBeenRegisteredThenReturn3()
    {
        List<VehicleInfo> vehicleInfos = Lists.newArrayList();
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setVehicleNo(1L);
        vehicleInfos.add(vehicleInfo);

        List<DevInfo> devInfos = Lists.newArrayList();
        DevInfo devInfo = new DevInfo();
        devInfo.setDevNo(2L);
        devInfos.add(devInfo);

        List<VehicleDeviceBindings> bindings = Lists.newArrayList();
        VehicleDeviceBindings vehicleDeviceBindings = new VehicleDeviceBindings();
        vehicleDeviceBindings.setVehicleNo(3L);
        vehicleDeviceBindings.setDevNo(2L);
        bindings.add(vehicleDeviceBindings);

        doReturn(vehicleInfos).when(vehicleInfoDAO).selectByExample(any(VehicleInfoExample.class));
        doReturn(devInfos).when(devInfoDAO).selectByExample(any(DevInfoExample.class));
        when(vehicleDeviceBindingsDAO.selectByExample(any(VehicleDeviceBindingsExample.class)))
                .thenReturn(Lists.newArrayList())
                .thenReturn(bindings);

        Pair<RegisterResult, String> registerResult = registerService.onRegister(1, "123", "123");

        assertThat(registerResult, is(Pair.of(RegisterResult.DEV_HAS_BEEN_REGISTERED,null)));
    }

    @Test
    public void whenNormalThenReturn0()
    {
        List<VehicleInfo> vehicleInfos = Lists.newArrayList();
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setVehicleNo(1L);
        vehicleInfos.add(vehicleInfo);

        List<DevInfo> devInfos = Lists.newArrayList();
        DevInfo devInfo = new DevInfo();
        devInfo.setDevNo(2L);
        devInfos.add(devInfo);

        doReturn(1L).when(sequenceService).nextId();
        doReturn(vehicleInfos).when(vehicleInfoDAO).selectByExample(any(VehicleInfoExample.class));
        doReturn(devInfos).when(devInfoDAO).selectByExample(any(DevInfoExample.class));
        doReturn(Lists.newArrayList()).when(vehicleDeviceBindingsDAO).selectByExample(any(VehicleDeviceBindingsExample.class));

        Pair<RegisterResult, String> registerResult = registerService.onRegister(1, "123", "123");

        assertThat(registerResult.getLeft(), is(RegisterResult.SUCCESS));
        assertNotNull(registerResult.getRight());
    }
}