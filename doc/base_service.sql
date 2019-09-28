CREATE SCHEMA IF NOT EXISTS `base_service` DEFAULT CHARACTER SET utf8mb4;

-- 车辆信息

CREATE TABLE IF NOT EXISTS `base_service`.`vehicle_info`
(
    `id`           BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `vehicle_no`   BIGINT(20) UNSIGNED NOT NULL COMMENT '车辆id',
    `car_license`  VARCHAR(45)         NULL COMMENT '车辆车牌号',
    `plate_color`  INT                 NOT NULL COMMENT '车牌号颜色',
    `vehicle_vin`  VARCHAR(45)         NOT NULL COMMENT '车辆VIN码',
    `driver_no`    BIGINT(20) UNSIGNED NOT NULL COMMENT '驾驶员编号',
    `transport_no` VARCHAR(255)        NULL COMMENT '道路运输证号',
    `vehicle_type` INT                 NOT NULL COMMENT '车辆类型',
    `group_no`     BIGINT(20) UNSIGNED NOT NULL COMMENT '车组编号',
    `area_code`    INT                 NULL COMMENT '地域编码',
    `create_at`    DATETIME(3)         NOT NULL COMMENT '创建时间',
    `update_at`    DATETIME(3)         NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `vehicle_no_UNIQUE` (`vehicle_no` ASC),
    UNIQUE INDEX `car_license_plate_color_UNIQUE` (`car_license` ASC, `plate_color` ASC),
    INDEX `idx_driver_no` (`driver_no` ASC),
    UNIQUE INDEX `vehicle_vin_UNIQUE` (`vehicle_vin` ASC)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COMMENT = '车辆信息表';

CREATE TABLE IF NOT EXISTS `base_service`.`dev_info`
(
    `id`              BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `dev_no`          BIGINT(20) UNSIGNED NOT NULL COMMENT '设备编号(平台唯一编号)',
    `sim_card_no`     VARCHAR(45)         NOT NULL COMMENT '手机卡号',
    `dev_type`        INT                 NOT NULL COMMENT '设备型号',
    `dev_id`          VARCHAR(45)         NOT NULL COMMENT '设备id(制造商)',
    `channel_count`   INT                 NOT NULL COMMENT '通道数',
    `channel_enabled` VARCHAR(45)         NOT NULL COMMENT '激活的通道',
    `protocol_type`   INT                 NOT NULL COMMENT '协议类型',
    `auth_code`       VARCHAR(45) DEFAULT NULL COMMENT '鉴权码',
    `create_at`       DATETIME(3)         NOT NULL COMMENT '创建时间',
    `update_at`       DATETIME(3)         NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `dev_no_UNIQUE` (`dev_no` ASC),
    UNIQUE INDEX `sim_card_id_UNIQUE` (`sim_card_no` ASC),
    UNIQUE INDEX `dev_id_UNIQUE` (`dev_id` ASC)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COMMENT = '设备表';

CREATE TABLE IF NOT EXISTS `base_service`.`vehicle_device_bindings`
(
    `id`         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `binding_no` BIGINT(20)          NOT NULL COMMENT '绑定编号',
    `vehicle_no` BIGINT(20)          NOT NULL COMMENT '车辆号',
    `dev_no`     BIGINT(20)          NOT NULL COMMENT '设备号',
    `create_at`  DATETIME(3)         NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `dev_no_UNIQUE` (`dev_no` ASC),
    UNIQUE INDEX `vehicle_no_UNIQUE` (`vehicle_no` ASC)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '车辆设备绑定表';

