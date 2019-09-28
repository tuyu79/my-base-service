package com.turan.dao;

import com.turan.po.DevInfo;
import com.turan.po.DevInfoExample;
import org.springframework.stereotype.Repository;

/**
 * DevInfoDAO继承基类
 */
@Repository
public interface DevInfoDAO extends MyBatisBaseDao<DevInfo, Long, DevInfoExample> {
}