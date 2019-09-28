package com.turan.po;

import java.io.Serializable;
import java.util.Date;

/**
 * vehicle_info
 * @author 
 */
public class VehicleInfo implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 车辆id
     */
    private Long vehicleNo;

    /**
     * 车辆车牌号
     */
    private String carLicense;

    /**
     * 车牌号颜色
     */
    private Integer plateColor;

    /**
     * 车辆VIN码
     */
    private String vehicleVin;

    /**
     * 驾驶员编号
     */
    private Long driverNo;

    /**
     * 道路运输证号
     */
    private String transportNo;

    /**
     * 车辆类型
     */
    private Integer vehicleType;

    /**
     * 车组编号
     */
    private Long groupNo;

    /**
     * 地域编码
     */
    private Integer areaCode;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(Long vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public Integer getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    public String getVehicleVin() {
        return vehicleVin;
    }

    public void setVehicleVin(String vehicleVin) {
        this.vehicleVin = vehicleVin;
    }

    public Long getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(Long driverNo) {
        this.driverNo = driverNo;
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo;
    }

    public Integer getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Integer vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(Long groupNo) {
        this.groupNo = groupNo;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        VehicleInfo other = (VehicleInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVehicleNo() == null ? other.getVehicleNo() == null : this.getVehicleNo().equals(other.getVehicleNo()))
            && (this.getCarLicense() == null ? other.getCarLicense() == null : this.getCarLicense().equals(other.getCarLicense()))
            && (this.getPlateColor() == null ? other.getPlateColor() == null : this.getPlateColor().equals(other.getPlateColor()))
            && (this.getVehicleVin() == null ? other.getVehicleVin() == null : this.getVehicleVin().equals(other.getVehicleVin()))
            && (this.getDriverNo() == null ? other.getDriverNo() == null : this.getDriverNo().equals(other.getDriverNo()))
            && (this.getTransportNo() == null ? other.getTransportNo() == null : this.getTransportNo().equals(other.getTransportNo()))
            && (this.getVehicleType() == null ? other.getVehicleType() == null : this.getVehicleType().equals(other.getVehicleType()))
            && (this.getGroupNo() == null ? other.getGroupNo() == null : this.getGroupNo().equals(other.getGroupNo()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVehicleNo() == null) ? 0 : getVehicleNo().hashCode());
        result = prime * result + ((getCarLicense() == null) ? 0 : getCarLicense().hashCode());
        result = prime * result + ((getPlateColor() == null) ? 0 : getPlateColor().hashCode());
        result = prime * result + ((getVehicleVin() == null) ? 0 : getVehicleVin().hashCode());
        result = prime * result + ((getDriverNo() == null) ? 0 : getDriverNo().hashCode());
        result = prime * result + ((getTransportNo() == null) ? 0 : getTransportNo().hashCode());
        result = prime * result + ((getVehicleType() == null) ? 0 : getVehicleType().hashCode());
        result = prime * result + ((getGroupNo() == null) ? 0 : getGroupNo().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", vehicleNo=").append(vehicleNo);
        sb.append(", carLicense=").append(carLicense);
        sb.append(", plateColor=").append(plateColor);
        sb.append(", vehicleVin=").append(vehicleVin);
        sb.append(", driverNo=").append(driverNo);
        sb.append(", transportNo=").append(transportNo);
        sb.append(", vehicleType=").append(vehicleType);
        sb.append(", groupNo=").append(groupNo);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}