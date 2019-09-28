package com.turan.service;

import com.turan.feign.api.baseservice.bo.InstructionRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InstructionServiceTest
{

    @InjectMocks
    private InstructionService instructionService;
    @Mock
    private DevAuthService devAuthService;
    @Mock
    private MessageChannel baseServiceDownMsg;

    @Test
    public void whenInstructionRequestThenSuccess()
    {
        doReturn(Optional.of(123)).when(devAuthService).getOnlineChannelIdByVehicleNo(12L);
        doReturn("13452202456").when(devAuthService).getMobileByVehicleNo(12L);

        InstructionRequest request= new InstructionRequest();
        request.setVehicleNo(12L);
        request.setData(null);
        request.setMsgType("UPLOAD_ATTACHMENT");

        instructionService.toGateway(request);

        verify(baseServiceDownMsg,times(1)).send(any(Message.class));
    }
}