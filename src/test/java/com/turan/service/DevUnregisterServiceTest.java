package com.turan.service;

import com.turan.dao.DevInfoDAO;
import com.turan.dao.VehicleDeviceBindingsDAO;
import com.turan.po.DevInfo;
import com.turan.po.DevInfoExample;
import com.turan.po.VehicleDeviceBindingsExample;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DevUnregisterServiceTest
{

    @InjectMocks
    private DevUnregisterService devUnregisterService;
    @Mock
    private DevInfoDAO devInfoDAO;
    @Mock
    private VehicleDeviceBindingsDAO vehicleDeviceBindingsDAO;

    @Test
    public void onUnRegister()
    {
        doReturn(Lists.newArrayList()).when(devInfoDAO).selectByExample(any(DevInfoExample.class));

        devUnregisterService.onUnRegister("13452202456", 1L);

        verify(vehicleDeviceBindingsDAO, times(0))
                .deleteByExample(any(VehicleDeviceBindingsExample.class));

        DevInfo devInfo = new DevInfo();
        devInfo.setDevNo(1L);
        doReturn(Lists.list(devInfo)).when(devInfoDAO).selectByExample(any(DevInfoExample.class));

        devUnregisterService.onUnRegister("13452202456", 1L);
        verify(vehicleDeviceBindingsDAO, times(1))
                .deleteByExample(any(VehicleDeviceBindingsExample.class));
    }
}