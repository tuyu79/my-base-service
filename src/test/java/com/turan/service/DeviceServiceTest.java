package com.turan.service;

import com.turan.bo.Device;
import com.turan.dao.DevInfoDAO;
import com.turan.po.DevInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeviceServiceTest
{

    @InjectMocks
    private DeviceService deviceService;
    @Mock
    private GlobalSequenceService sequenceService;
    @Mock
    private DevInfoDAO devInfoDAO;

    @Test
    public void whenAddDeviceThenSuccess()
    {
        Device device = new Device();
        device.setSimCardNo("13452202456");
        device.setDevType(1);
        device.setDevId("X123456");
        device.setChannelCount(4);
        device.setChannelEnabled("1,2,3,4");
        device.setProtocolType(0);

        deviceService.add(device);

        verify(sequenceService,times(1)).nextId();
        verify(devInfoDAO,times(1)).insert(any(DevInfo.class));
    }
}