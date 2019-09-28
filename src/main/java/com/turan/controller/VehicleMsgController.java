package com.turan.controller;

import com.turan.bo.BaseDownMsg;
import com.turan.common.ResultBean;
import com.turan.service.DevMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base-service/v1/vehicle-msg")
public class VehicleMsgController
{
    @Autowired
    private DevMsgService devMsgService;

    @PostMapping("")
    public ResultBean<Void> sendMsg(BaseDownMsg downMsg)
    {
        return ResultBean.of(devMsgService.sendBaseDownMsg(downMsg));
    }
}
