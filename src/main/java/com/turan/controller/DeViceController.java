package com.turan.controller;

import com.turan.bo.Device;
import com.turan.bo.Vehicle;
import com.turan.common.ResultBean;
import com.turan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.turan.common.RespCode.SUCCESS;

@RestController
@RequestMapping("/base-service/v1/device")
public class DeViceController
{
    @Autowired
    private DeviceService deviceService;

    @PostMapping("")
    public ResultBean<Void> add(@RequestBody @Valid Device device)
    {
        deviceService.add(device);
        return ResultBean.of(SUCCESS);
    }

    @DeleteMapping("/{vehicleNo}")
    public ResultBean<Void> delete(@PathVariable  Long vehicleNo)
    {
        return ResultBean.of(SUCCESS);
    }

    @PutMapping("")
    public ResultBean<Vehicle>  update(@RequestBody Vehicle vehicle)
    {
        return ResultBean.of(SUCCESS);
    }

    @GetMapping("/{vehicleNo}")
    public ResultBean<Vehicle> get(@PathVariable  Long vehicleNo)
    {
        return ResultBean.of(SUCCESS);
    }
}
