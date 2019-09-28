package com.turan.service;

import com.turan.dao.DevInfoDAO;
import com.turan.dao.VehicleDeviceBindingsDAO;
import com.turan.dao.VehicleInfoDAO;
import com.turan.enums.CommonResultEnum;
import com.turan.po.*;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DevAuthServiceTest
{

    @InjectMocks
    private DevAuthService devAuthService;
    @Mock
    private DevInfoDAO devInfoDAO;
    @Mock
    private VehicleInfoDAO vehicleInfoDAO;
    @Mock
    private MessageChannel onlineOutput;
    @Mock
    private VehicleDeviceBindingsDAO vehicleDeviceBindingsDAO;

    @Test
    public void whenDevNotExistThenFail()
    {

         doReturn(null).when(devInfoDAO).selectByExample(any(DevInfoExample.class));

        CommonResultEnum result = devAuthService.onAuth(123,"13452202456", "abc");
        assertThat(result,is(CommonResultEnum.FAIL));
    }

    @Test
    public void whenAuthCodeWrongThenFail()
    {
        List<DevInfo> devInfos = Lists.newArrayList();
        DevInfo devInfo = new DevInfo();
        devInfo.setAuthCode("abc");
        devInfos.add(devInfo);

        doReturn(devInfos).when(devInfoDAO).selectByExample(any(DevInfoExample.class));

        CommonResultEnum result = devAuthService.onAuth(123,"13452202456", "abc1");
        assertThat(result,is(CommonResultEnum.FAIL));
    }

    @Test
    public void whenAuthCodeRightThenSuccess()
    {
        List<DevInfo> devInfos = Lists.newArrayList();
        DevInfo devInfo = new DevInfo();
        devInfo.setAuthCode("abc");
        devInfo.setDevNo(121L);
        devInfos.add(devInfo);

        doReturn(devInfos).when(devInfoDAO).selectByExample(any(DevInfoExample.class));

        List<VehicleDeviceBindings> bindings = Lists.newArrayList();
        VehicleDeviceBindings vehicleDeviceBindings = new VehicleDeviceBindings();
        vehicleDeviceBindings.setVehicleNo(1L);
        bindings.add(vehicleDeviceBindings);
        doReturn(bindings).when(vehicleDeviceBindingsDAO).selectByExample(any(VehicleDeviceBindingsExample.class));

        CommonResultEnum result = devAuthService.onAuth(123,"13452202456", "abc");
        assertThat(result,is(CommonResultEnum.SUCCESS));
        verify(onlineOutput,times(1)).send(any(Message.class));
    }
}