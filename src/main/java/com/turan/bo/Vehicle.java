package com.turan.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Vehicle
{
    private Long vehicleNo;
    @NotBlank
    private String carLicense;
    @NotNull
    private Integer plateColor;
    @NotBlank
    private String vehicleVin;
    @NotNull
    private Long driverNo;
    @NotBlank
    private String transportNo;
    @NotNull
    private Long groupNo;
    @NotNull
    private Integer areaCode;
    @NotNull
    private Integer vehicleType;
}
