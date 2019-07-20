#################基础场景包#################

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_scene_package 
-- ----------------------------
DROP TABLE IF EXISTS `t_scene_package`;
CREATE TABLE `t_scene_package` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id自增字段',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户标识',
  `name` varchar(20) DEFAULT NULL COMMENT '场景包名字',
  `scene_id` varchar(20) DEFAULT NULL COMMENT '场景id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `device_count` int(11)  DEFAULT 0 COMMENT '设备数',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除标识',
  `is_default` int(11) DEFAULT 0 COMMENT '是否默认', 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='场景包';

SET FOREIGN_KEY_CHECKS = 1;

##############################################

-- 与原有的t_scene_package_detail  完全不一样
DROP TABLE IF EXISTS `t_scene_package_detail`;
CREATE TABLE `t_scene_package_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id自增字段',
  `package_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '场景包id',
  `shelf_heght_no` varchar(100) DEFAULT NULL COMMENT '层高组合|220-290-260-260',
  `name` varchar(20)  DEFAULT NULL COMMENT '场景包明细名称',
  `floor_model`  JSON DEFAULT  NULL COMMMENT '层架算法模型{floor1,floor2,floor3,floor4}',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='场景包明细';

########################################

DROP TABLE IF EXISTS `t_scene_package_detail_layout`;
CREATE TABLE `t_scene_package_detail_layout` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id自增字段',
  `package_detail_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '场景包明细id',
  `floor_no` int(11) DEFAULT 1 COMMENT '层架数',
  `item_no` varchar(20)  DEFAULT NULL COMMENT '商品编码',
  `rate` int(11)  DEFAULT NULL COMMENT '配置比例（0<$<100的整数）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='场景包布局';

########################################

-- ----------------------------
-- Table structure for t_scene_package_detail_floor_model
-- ----------------------------
-- DROP TABLE IF EXISTS `t_scene_package_detail_floor_model`;
-- CREATE TABLE `t_scene_package_detail_floor_model` (
--   `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
--   `package_detail_id` varchar(255) NOT NULL COMMENT '场景包明细id',
--   `floor_no` int(11) NOT NULL COMMENT '层架',
--   `model_no` varchar(255) NOT NULL COMMENT '模型编码',
--   `create_user_id` int(11) NOT NULL COMMENT '创建人',
--   `update_user_id` int(11) NOT NULL COMMENT '更新人',
--   `create_time` timestamp NOT NULL,
--   `update_time` timestamp NOT NULL,
--   `del_flag` int(11) DEFAULT '0',
--   PRIMARY KEY (`id`),
--   UNIQUE KEY `t_scene_package_floor_model_package_detail_id_floor_unique` (`package_detail_id`,`floor_no`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8  COMMENT='场景包明细模型';

-- SET FOREIGN_KEY_CHECKS = 1;

#######################################

-- ----------------------------
-- Table structure for t_device_scene_package 
-- ----------------------------
DROP TABLE IF EXISTS `t_device_scene_package`;
CREATE TABLE `t_device_scene_package` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id自增字段',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户标识',
  `device_no` varchar(20) DEFAULT NULL COMMENT ' 设备号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `end_time` datetime  DEFAULT NULL COMMENT '结束日期',
  `floor_model`  JSON DEFAULT  NULL COMMMENT '层架算法模型{floor1,floor2,floor3,floor4}',
  `version`  int(11) DEFAULT NULL COMMENT '版本号',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除标识',
  `is_default` int(11) DEFAULT 0 COMMENT '是否默认', 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='设备场景包';

SET FOREIGN_KEY_CHECKS = 1;

########################################

-- FIXME 确定下设备层数不变就可以 ----------------------------
-- Table structure for t_device_scene_package_floor_model
-- ----------------------------
-- DROP TABLE IF EXISTS `t_device_scene_package_floor_model`;
-- CREATE TABLE `t_device_scene_package_floor_model` (
--   `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
--   `device_scene_id` bigint(10) NOT NULL COMMENT '设备场景id',
--   `floor_no` int(11) NOT NULL COMMENT '层架',
--   `model_no` varchar(255) NOT NULL COMMENT '模型编码',
--   `create_user_id` int(11) NOT NULL COMMENT '创建人',
--   `update_user_id` int(11) NOT NULL COMMENT '更新人',
--   `create_time` timestamp NOT NULL,
--   `update_time` timestamp NOT NULL,
--   `del_flag` int(11) DEFAULT '0',
--   PRIMARY KEY (`id`),
--   UNIQUE KEY `t_device_scene_id_floor_unique` (`device_scene_id`,`floor_no`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8  COMMENT='设备场景包层架模型';

-- SET FOREIGN_KEY_CHECKS = 1;

##########################################

DROP TABLE IF EXISTS `t_device_scene_package_layout`;
CREATE TABLE `t_device_scene_package_layout` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id自增字段',
  `device_scene_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '设备场景包id',
  `floor_no` int(11) DEFAULT 1 COMMENT '层架数',
  `item_no` varchar(20)  DEFAULT NULL COMMENT '商品编码',
  `rate` int(11)  DEFAULT NULL COMMENT '配置比例（0<$<100的整数）',
  `quantity` int(11)  DEFAULT NULL COMMENT '配置数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='设备场景包布局';

########################################
-- 场景(工业园/写字楼)

DROP TABLE IF EXISTS `t_scene`;
CREATE TABLE `t_scene` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id自增字段',
  `name` varchar(20)  DEFAULT NULL COMMENT '场景名字',
  `description` varchar(20)  DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='场景';

-- ########################################
-- -- 全局设置： 设备基础层高 / 低动销比例 /比例优化周期 /品类优化周期
-- DROP TABLE IF EXISTS `t_rate_optimize_param`;
-- CREATE TABLE `t_rate_optimize_param` (
--   -- FIXME 优化区域
--   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id自增字段',
--   `name` varchar(20)  DEFAULT NULL COMMENT '场景名字',
--   `description` varchar(20)  DEFAULT NULL COMMENT '描述',
--   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
--   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
--   `del_flag` int(11) DEFAULT NULL COMMENT '删除标识',
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='比例优化记录';

-- ########################################

-- -- 全局设置： 设备基础层高 / 低动销比例 /比例优化周期 /品类优化周期 /
-- DROP TABLE IF EXISTS `t_category_optimize_param`;
-- CREATE TABLE `t_category_optimize_param` (
--   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id自增字段',
--   `name` varchar(20)  DEFAULT NULL COMMENT '场景名字',
--   `description` varchar(20)  DEFAULT NULL COMMENT '描述',
--   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
--   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
--   `del_flag` int(11) DEFAULT NULL COMMENT '删除标识',
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='品类优化记录';


