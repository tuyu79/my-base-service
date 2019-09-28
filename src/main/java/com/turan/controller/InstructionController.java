package com.turan.controller;

import com.turan.common.ResultBean;
import com.turan.feign.api.baseservice.BaseServiceFeignApi;
import com.turan.feign.api.baseservice.bo.InstructionRequest;
import com.turan.service.InstructionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class InstructionController implements BaseServiceFeignApi
{

    @Autowired
    private InstructionService instructionService;

    @Override
    public ResultBean<Void> instruction(InstructionRequest instructionRequest)
    {
        log.info("[instruction request],request: [{}]",instructionRequest);
        return ResultBean.of(instructionService.toGateway(instructionRequest));
    }
}
