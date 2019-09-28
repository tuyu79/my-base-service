package com.turan.dao;

import com.turan.po.VehicleInfo;
import com.turan.po.VehicleInfoExample;
import org.springframework.stereotype.Repository;

/**
 * VehicleInfoDAO继承基类
 */
@Repository
public interface VehicleInfoDAO extends MyBatisBaseDao<VehicleInfo, Long, VehicleInfoExample> {
}