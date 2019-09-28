package com.turan.po;

import java.io.Serializable;
import java.util.Date;

/**
 * vehicle_device_bindings
 * @author 
 */
public class VehicleDeviceBindings implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 绑定编号
     */
    private Long bindingNo;

    /**
     * 车辆号
     */
    private Long vehicleNo;

    /**
     * 设备号
     */
    private Long devNo;

    /**
     * 创建时间
     */
    private Date createAt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBindingNo() {
        return bindingNo;
    }

    public void setBindingNo(Long bindingNo) {
        this.bindingNo = bindingNo;
    }

    public Long getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(Long vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Long getDevNo() {
        return devNo;
    }

    public void setDevNo(Long devNo) {
        this.devNo = devNo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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
        VehicleDeviceBindings other = (VehicleDeviceBindings) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBindingNo() == null ? other.getBindingNo() == null : this.getBindingNo().equals(other.getBindingNo()))
            && (this.getVehicleNo() == null ? other.getVehicleNo() == null : this.getVehicleNo().equals(other.getVehicleNo()))
            && (this.getDevNo() == null ? other.getDevNo() == null : this.getDevNo().equals(other.getDevNo()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBindingNo() == null) ? 0 : getBindingNo().hashCode());
        result = prime * result + ((getVehicleNo() == null) ? 0 : getVehicleNo().hashCode());
        result = prime * result + ((getDevNo() == null) ? 0 : getDevNo().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bindingNo=").append(bindingNo);
        sb.append(", vehicleNo=").append(vehicleNo);
        sb.append(", devNo=").append(devNo);
        sb.append(", createAt=").append(createAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}