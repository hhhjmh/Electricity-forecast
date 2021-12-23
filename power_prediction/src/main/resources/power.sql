/*
Navicat MySQL Data Transfer

Source Server         : daike
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : power

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2021-12-22 16:10:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '主变');
INSERT INTO `device` VALUES ('2', '车间总');
INSERT INTO `device` VALUES ('3', '产线1');
INSERT INTO `device` VALUES ('4', '产线2');
INSERT INTO `device` VALUES ('5', '公共设备');

-- ----------------------------
-- Table structure for device_relationship
-- ----------------------------
DROP TABLE IF EXISTS `device_relationship`;
CREATE TABLE `device_relationship` (
  `id` int(11) NOT NULL,
  `deviceId` int(11) NOT NULL,
  `type` int(255) NOT NULL COMMENT '0监测点1用电单元2建筑物',
  `superDeviceId` varchar(255) DEFAULT NULL COMMENT '逻辑上层',
  `sublayerDeviceId` varchar(255) DEFAULT NULL COMMENT '逻辑下层',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for power_analyse_day_avg
-- ----------------------------
DROP TABLE IF EXISTS `power_analyse_day_avg`;
CREATE TABLE `power_analyse_day_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataTime` int(11) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '总负荷',
  `aLoad` varchar(255) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电流谐波畸变率',
  `ibPHD` varchar(255) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电压谐波畸变率',
  `ubPHD` varchar(255) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `uaDeviation` varchar(255) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL COMMENT 'Uab线电压偏差',
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL COMMENT '三相电流不平衡度%',
  `uUnbalance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_analyse_day_avg
-- ----------------------------

-- ----------------------------
-- Table structure for power_analyse_day_max
-- ----------------------------
DROP TABLE IF EXISTS `power_analyse_day_max`;
CREATE TABLE `power_analyse_day_max` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataTime` int(11) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '总负荷',
  `aLoad` varchar(255) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电流谐波畸变率',
  `ibPHD` varchar(255) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电压谐波畸变率',
  `ubPHD` varchar(255) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `uaDeviation` varchar(255) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL COMMENT 'Uab线电压偏差',
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL COMMENT '三相电流不平衡度%',
  `uUnbalance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_analyse_day_max
-- ----------------------------

-- ----------------------------
-- Table structure for power_analyse_day_min
-- ----------------------------
DROP TABLE IF EXISTS `power_analyse_day_min`;
CREATE TABLE `power_analyse_day_min` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataTime` int(11) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '总负荷',
  `aLoad` varchar(255) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电流谐波畸变率',
  `ibPHD` varchar(255) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电压谐波畸变率',
  `ubPHD` varchar(255) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `uaDeviation` varchar(255) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL COMMENT 'Uab线电压偏差',
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL COMMENT '三相电流不平衡度%',
  `uUnbalance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_analyse_day_min
-- ----------------------------

-- ----------------------------
-- Table structure for power_analyse_month_avg
-- ----------------------------
DROP TABLE IF EXISTS `power_analyse_month_avg`;
CREATE TABLE `power_analyse_month_avg` (
  `id` int(11) NOT NULL,
  `dataTime` int(11) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '总负荷',
  `aLoad` varchar(255) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电流谐波畸变率',
  `ibPHD` varchar(255) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电压谐波畸变率',
  `ubPHD` varchar(255) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `uaDeviation` varchar(255) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL COMMENT 'Uab线电压偏差',
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL COMMENT '三相电流不平衡度%',
  `uUnbalance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_analyse_month_avg
-- ----------------------------

-- ----------------------------
-- Table structure for power_analyse_month_max
-- ----------------------------
DROP TABLE IF EXISTS `power_analyse_month_max`;
CREATE TABLE `power_analyse_month_max` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataTime` int(11) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '总负荷',
  `aLoad` varchar(255) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电流谐波畸变率',
  `ibPHD` varchar(255) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电压谐波畸变率',
  `ubPHD` varchar(255) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `uaDeviation` varchar(255) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL COMMENT 'Uab线电压偏差',
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL COMMENT '三相电流不平衡度%',
  `uUnbalance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_analyse_month_max
-- ----------------------------

-- ----------------------------
-- Table structure for power_analyse_month_min
-- ----------------------------
DROP TABLE IF EXISTS `power_analyse_month_min`;
CREATE TABLE `power_analyse_month_min` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataTime` int(11) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '总负荷',
  `aLoad` varchar(255) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电流谐波畸变率',
  `ibPHD` varchar(255) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电压谐波畸变率',
  `ubPHD` varchar(255) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `uaDeviation` varchar(255) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL COMMENT 'Uab线电压偏差',
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL COMMENT '三相电流不平衡度%',
  `uUnbalance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_analyse_month_min
-- ----------------------------

-- ----------------------------
-- Table structure for power_analyse_year_avg
-- ----------------------------
DROP TABLE IF EXISTS `power_analyse_year_avg`;
CREATE TABLE `power_analyse_year_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataTime` int(11) DEFAULT NULL,
  `totalLoadTime` int(11) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '总负荷',
  `aLoadTime` int(11) DEFAULT NULL,
  `aLoad` varchar(255) DEFAULT NULL,
  `bLoadTime` int(11) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `cLoadTime` int(11) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `totalReactivePowerTime` int(11) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `aReactivePowerTime` int(11) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bReactivePowerTime` int(11) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cReactivePowerTime` int(11) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `totalPowerFactorTime` int(11) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `aPowerFactorTime` int(11) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `bPowerFactorTime` int(11) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `cPowerFactorTime` int(11) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `iaTime` int(11) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `ibTime` int(11) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `icTime` int(11) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `zeroiTime` int(11) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  `uaTime` int(11) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `ubTime` int(11) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `ucTime` int(11) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `uabTime` int(11) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ubcTime` int(11) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `ucaTime` int(11) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  `iaPHDTime` int(11) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电流谐波畸变率',
  `ibPHDTime` int(11) DEFAULT NULL,
  `ibPHD` varchar(255) DEFAULT NULL,
  `icPHDTime` int(11) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `uaPHDTime` int(11) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电压谐波畸变率',
  `ubPHDTime` int(11) DEFAULT NULL,
  `ubPHD` varchar(255) DEFAULT NULL,
  `ucPHDTime` int(11) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `uaDeviationTime` int(11) DEFAULT NULL,
  `uaDeviation` varchar(255) DEFAULT NULL,
  `ubDeviationTime` int(11) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ucDeviationTime` int(11) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `uUabDeviationTime` int(11) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL COMMENT 'Uab线电压偏差',
  `uUbcDeviationTime` int(11) DEFAULT NULL,
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviationTime` int(11) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `iUnbalanceTime` int(11) DEFAULT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL COMMENT '三相电流不平衡度%',
  `uUnbalanceTime` int(11) DEFAULT NULL,
  `uUnbalance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_analyse_year_avg
-- ----------------------------

-- ----------------------------
-- Table structure for power_analyse_year_max
-- ----------------------------
DROP TABLE IF EXISTS `power_analyse_year_max`;
CREATE TABLE `power_analyse_year_max` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataTime` int(11) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '总负荷',
  `aLoad` varchar(255) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电流谐波畸变率',
  `ibPHD` varchar(255) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电压谐波畸变率',
  `ubPHD` varchar(255) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `uaDeviation` varchar(255) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL COMMENT 'Uab线电压偏差',
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL COMMENT '三相电流不平衡度%',
  `uUnbalance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_analyse_year_max
-- ----------------------------

-- ----------------------------
-- Table structure for power_analyse_year_min
-- ----------------------------
DROP TABLE IF EXISTS `power_analyse_year_min`;
CREATE TABLE `power_analyse_year_min` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataTime` int(11) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '总负荷',
  `aLoad` varchar(255) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电流谐波畸变率',
  `ibPHD` varchar(255) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电压谐波畸变率',
  `ubPHD` varchar(255) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `uaDeviation` varchar(255) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL COMMENT 'Uab线电压偏差',
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL COMMENT '三相电流不平衡度%',
  `uUnbalance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_analyse_year_min
-- ----------------------------

-- ----------------------------
-- Table structure for power_distribution_day
-- ----------------------------
DROP TABLE IF EXISTS `power_distribution_day`;
CREATE TABLE `power_distribution_day` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deviceId` int(11) NOT NULL,
  `dataTime` int(11) NOT NULL,
  `load` varchar(255) DEFAULT NULL COMMENT '负荷',
  `totalkWh` varchar(255) DEFAULT NULL,
  `highKWh` varchar(255) DEFAULT NULL,
  `lowKWh` varchar(255) DEFAULT NULL,
  `midKWh` varchar(255) DEFAULT NULL,
  `topKWh` varchar(255) DEFAULT NULL,
  `totalCharge` varchar(255) DEFAULT NULL,
  `highCharge` varchar(255) DEFAULT NULL,
  `lowCharge` varchar(255) DEFAULT NULL,
  `midCharge` varchar(255) DEFAULT NULL,
  `topCharge` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_distribution_day
-- ----------------------------

-- ----------------------------
-- Table structure for power_distribution_hour
-- ----------------------------
DROP TABLE IF EXISTS `power_distribution_hour`;
CREATE TABLE `power_distribution_hour` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deivceId` int(11) DEFAULT NULL,
  `datatime` int(11) DEFAULT NULL COMMENT '精确到小时查询的时间戳',
  `totalKWh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_distribution_hour
-- ----------------------------

-- ----------------------------
-- Table structure for power_forecast
-- ----------------------------
DROP TABLE IF EXISTS `power_forecast`;
CREATE TABLE `power_forecast` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deciveId` int(11) DEFAULT NULL,
  `load` varchar(255) DEFAULT NULL,
  `datatime` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '0日预测1月预测2年预测',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_forecast
-- ----------------------------

-- ----------------------------
-- Table structure for power_quality_realtime
-- ----------------------------
DROP TABLE IF EXISTS `power_quality_realtime`;
CREATE TABLE `power_quality_realtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataTime` int(11) DEFAULT NULL,
  `deviceId` int(11) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电流谐波畸变率',
  `ibPHD` varchar(255) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL COMMENT 'A相电压谐波畸变率',
  `ubPHD` varchar(255) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `frequencyDeviation` varchar(255) DEFAULT NULL COMMENT '频率偏差',
  `uaDeviation` varchar(255) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL COMMENT 'Uab线电压偏差',
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL COMMENT '三相电流不平衡度%',
  `uUnbalance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_quality_realtime
-- ----------------------------

-- ----------------------------
-- Table structure for power_realtime
-- ----------------------------
DROP TABLE IF EXISTS `power_realtime`;
CREATE TABLE `power_realtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deviceId` int(11) DEFAULT NULL,
  `dataTime` int(11) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '总负荷',
  `aLoad` varchar(255) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_realtime
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `root` int(11) NOT NULL COMMENT '0用户1系统管理员',
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for util
-- ----------------------------
DROP TABLE IF EXISTS `util`;
CREATE TABLE `util` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `variableAttributeName` varchar(255) DEFAULT NULL,
  `variableAttributeNum` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL COMMENT '0正在使用1弃用',
  `dataTime` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of util
-- ----------------------------
