CREATE TABLE test.`t_car_info`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `car_no` VARCHAR(40) NOT NULL COMMENT '汽车编号',
    `car_name` VARCHAR(60) NOT NULL COMMENT '汽车名称',
    `created_by` VARCHAR(30) NOT NULL COMMENT '创建人',
    `created_date` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by` VARCHAR(30) NOT NULL COMMENT '修改人',
    `updated_date` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY(`id`),
    UNIQUE KEY `uidx_car_no`(`car_no`),
    KEY `idx_date`(`created_date`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_bin COMMENT '车辆信息';