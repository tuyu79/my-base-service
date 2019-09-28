package com.turan.controller;

import com.turan.bo.Vehicle;
import com.turan.common.BaseRespCode;
import com.turan.common.ResultBean;
import com.turan.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static com.turan.common.RespCode.SUCCESS;

@RestController
@RequestMapping("/base-service/v1/vehicle")
public class VehicleController
{
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("")
    public ResultBean<Void> add(@RequestBody @Valid Vehicle vehicle)
    {
        vehicleService.add(vehicle);
        return ResultBean.of(SUCCESS);
    }

    @DeleteMapping("/{vehicleNo}")
    public ResultBean<Void> delete(@PathVariable  Long vehicleNo)
    {
        vehicleService.delete(vehicleNo) ;
        return ResultBean.of(SUCCESS);
    }

    @PutMapping("")
    public ResultBean<Vehicle>  update(@RequestBody Vehicle vehicle)
    {
        return ResultBean.of(SUCCESS,vehicleService.update(vehicle));
    }

    @GetMapping("/{vehicleNo}")
    public ResultBean<Vehicle> get(@PathVariable  Long vehicleNo)
    {
        Optional<Vehicle> result = vehicleService.get(vehicleNo);
        return result.map(vehicle -> ResultBean.of(SUCCESS, vehicle))
                .orElseGet(() -> ResultBean.of(BaseRespCode.VEHICLE_NOT_EXIST));
    }
}
