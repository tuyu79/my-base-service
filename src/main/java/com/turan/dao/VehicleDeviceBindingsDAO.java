package com.turan.dao;

import com.turan.po.VehicleDeviceBindings;
import com.turan.po.VehicleDeviceBindingsExample;
import org.springframework.stereotype.Repository;

/**
 * VehicleDeviceBindingsDAO继承基类
 */
@Repository
public interface VehicleDeviceBindingsDAO extends MyBatisBaseDao<VehicleDeviceBindings, Long, VehicleDeviceBindingsExample> {
}