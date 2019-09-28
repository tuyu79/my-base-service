package com.turan.po;

import java.io.Serializable;
import java.util.Date;

/**
 * dev_info
 * @author 
 */
public class DevInfo implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 设备编号(平台唯一编号)
     */
    private Long devNo;

    /**
     * 手机卡号
     */
    private String simCardNo;

    /**
     * 设备型号
     */
    private Integer devType;

    /**
     * 设备id(制造商)
     */
    private String devId;

    /**
     * 通道数
     */
    private Integer channelCount;

    /**
     * 激活的通道
     */
    private String channelEnabled;

    /**
     * 协议类型
     */
    private Integer protocolType;

    /**
     * 鉴权码
     */
    private String authCode;

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

    public Long getDevNo() {
        return devNo;
    }

    public void setDevNo(Long devNo) {
        this.devNo = devNo;
    }

    public String getSimCardNo() {
        return simCardNo;
    }

    public void setSimCardNo(String simCardNo) {
        this.simCardNo = simCardNo;
    }

    public Integer getDevType() {
        return devType;
    }

    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public Integer getChannelCount() {
        return channelCount;
    }

    public void setChannelCount(Integer channelCount) {
        this.channelCount = channelCount;
    }

    public String getChannelEnabled() {
        return channelEnabled;
    }

    public void setChannelEnabled(String channelEnabled) {
        this.channelEnabled = channelEnabled;
    }

    public Integer getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(Integer protocolType) {
        this.protocolType = protocolType;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
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
        DevInfo other = (DevInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDevNo() == null ? other.getDevNo() == null : this.getDevNo().equals(other.getDevNo()))
            && (this.getSimCardNo() == null ? other.getSimCardNo() == null : this.getSimCardNo().equals(other.getSimCardNo()))
            && (this.getDevType() == null ? other.getDevType() == null : this.getDevType().equals(other.getDevType()))
            && (this.getDevId() == null ? other.getDevId() == null : this.getDevId().equals(other.getDevId()))
            && (this.getChannelCount() == null ? other.getChannelCount() == null : this.getChannelCount().equals(other.getChannelCount()))
            && (this.getChannelEnabled() == null ? other.getChannelEnabled() == null : this.getChannelEnabled().equals(other.getChannelEnabled()))
            && (this.getProtocolType() == null ? other.getProtocolType() == null : this.getProtocolType().equals(other.getProtocolType()))
            && (this.getAuthCode() == null ? other.getAuthCode() == null : this.getAuthCode().equals(other.getAuthCode()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDevNo() == null) ? 0 : getDevNo().hashCode());
        result = prime * result + ((getSimCardNo() == null) ? 0 : getSimCardNo().hashCode());
        result = prime * result + ((getDevType() == null) ? 0 : getDevType().hashCode());
        result = prime * result + ((getDevId() == null) ? 0 : getDevId().hashCode());
        result = prime * result + ((getChannelCount() == null) ? 0 : getChannelCount().hashCode());
        result = prime * result + ((getChannelEnabled() == null) ? 0 : getChannelEnabled().hashCode());
        result = prime * result + ((getProtocolType() == null) ? 0 : getProtocolType().hashCode());
        result = prime * result + ((getAuthCode() == null) ? 0 : getAuthCode().hashCode());
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
        sb.append(", devNo=").append(devNo);
        sb.append(", simCardNo=").append(simCardNo);
        sb.append(", devType=").append(devType);
        sb.append(", devId=").append(devId);
        sb.append(", channelCount=").append(channelCount);
        sb.append(", channelEnabled=").append(channelEnabled);
        sb.append(", protocolType=").append(protocolType);
        sb.append(", authCode=").append(authCode);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}