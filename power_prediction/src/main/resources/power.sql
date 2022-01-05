/*
Navicat MySQL Data Transfer

Source Server         : daike
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : power

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2022-01-04 17:00:19
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
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '主变');
INSERT INTO `device` VALUES ('2', '车间总');
INSERT INTO `device` VALUES ('3', '产线1');
INSERT INTO `device` VALUES ('4', '产线2');
INSERT INTO `device` VALUES ('5', '公共设备');
INSERT INTO `device` VALUES ('6', '电能管理体验馆');
INSERT INTO `device` VALUES ('7', '1#空调柜2');
INSERT INTO `device` VALUES ('8', '3#动力柜');
INSERT INTO `device` VALUES ('9', '1#动力柜');
INSERT INTO `device` VALUES ('10', '1#插座电源');
INSERT INTO `device` VALUES ('11', '2#插座电源');

-- ----------------------------
-- Table structure for device_relationship
-- ----------------------------
DROP TABLE IF EXISTS `device_relationship`;
CREATE TABLE `device_relationship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deviceId` int(11) NOT NULL,
  `type` int(255) NOT NULL COMMENT '0监测点1用电单元2建筑物',
  `superDeviceId` int(255) DEFAULT NULL COMMENT '逻辑上层',
  `sublayerDeviceId` int(255) DEFAULT NULL COMMENT '逻辑下层',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_relationship
-- ----------------------------
INSERT INTO `device_relationship` VALUES ('1', '6', '1', null, '1');
INSERT INTO `device_relationship` VALUES ('2', '1', '1', '6', '2');
INSERT INTO `device_relationship` VALUES ('3', '7', '1', '1', null);
INSERT INTO `device_relationship` VALUES ('4', '8', '1', '1', null);
INSERT INTO `device_relationship` VALUES ('5', '9', '1', '1', '11');
INSERT INTO `device_relationship` VALUES ('9', '9', '1', '1', '10');
INSERT INTO `device_relationship` VALUES ('6', '10', '1', '9', null);
INSERT INTO `device_relationship` VALUES ('7', '11', '1', '9', null);

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
  `deviceId` int(11) NOT NULL,
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
  `aLoadTime` int(11) DEFAULT NULL,
  `aPowerFactorTime` int(11) DEFAULT NULL,
  `aReactivePowerTime` int(11) DEFAULT NULL,
  `bLoadTime` int(11) DEFAULT NULL,
  `bPowerFactorTime` int(11) DEFAULT NULL,
  `bReactivePowerTime` int(11) DEFAULT NULL,
  `cLoadTime` int(11) DEFAULT NULL,
  `cPowerFactorTime` int(11) DEFAULT NULL,
  `cReactivePowerTime` int(11) DEFAULT NULL,
  `deviceId` int(11) NOT NULL,
  `iUnbalanceTime` int(11) DEFAULT NULL,
  `iaPHDTime` int(11) DEFAULT NULL,
  `iaTime` int(11) DEFAULT NULL,
  `ibPHDTime` int(11) DEFAULT NULL,
  `ibTime` int(11) DEFAULT NULL,
  `icPHDTime` int(11) DEFAULT NULL,
  `icTime` int(11) DEFAULT NULL,
  `totalLoadTime` int(11) DEFAULT NULL,
  `totalPowerFactorTime` int(11) DEFAULT NULL,
  `totalReactivePowerTime` int(11) DEFAULT NULL,
  `uUabDeviationTime` int(11) DEFAULT NULL,
  `uUbcDeviationTime` int(11) DEFAULT NULL,
  `uUcaDeviationTime` int(11) DEFAULT NULL,
  `uUnbalanceTime` int(11) DEFAULT NULL,
  `uaDeviationTime` int(11) DEFAULT NULL,
  `uaPHDTime` int(11) DEFAULT NULL,
  `uaTime` int(11) DEFAULT NULL,
  `uabTime` int(11) DEFAULT NULL,
  `ubDeviationTime` int(11) DEFAULT NULL,
  `ubPHDTime` int(11) DEFAULT NULL,
  `ubTime` int(11) DEFAULT NULL,
  `ubcTime` int(11) DEFAULT NULL,
  `ucDeviationTime` int(11) DEFAULT NULL,
  `ucPHDTime` int(11) DEFAULT NULL,
  `ucTime` int(11) DEFAULT NULL,
  `ucaTime` int(11) DEFAULT NULL,
  `zeroiTime` int(11) DEFAULT NULL,
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
  `aLoadTime` int(11) DEFAULT NULL,
  `aPowerFactorTime` int(11) DEFAULT NULL,
  `aReactivePowerTime` int(11) DEFAULT NULL,
  `bLoadTime` int(11) DEFAULT NULL,
  `bPowerFactorTime` int(11) DEFAULT NULL,
  `bReactivePowerTime` int(11) DEFAULT NULL,
  `cLoadTime` int(11) DEFAULT NULL,
  `cPowerFactorTime` int(11) DEFAULT NULL,
  `cReactivePowerTime` int(11) DEFAULT NULL,
  `deviceId` int(11) NOT NULL,
  `iUnbalanceTime` int(11) DEFAULT NULL,
  `iaPHDTime` int(11) DEFAULT NULL,
  `iaTime` int(11) DEFAULT NULL,
  `ibPHDTime` int(11) DEFAULT NULL,
  `ibTime` int(11) DEFAULT NULL,
  `icPHDTime` int(11) DEFAULT NULL,
  `icTime` int(11) DEFAULT NULL,
  `totalLoadTime` int(11) DEFAULT NULL,
  `totalPowerFactorTime` int(11) DEFAULT NULL,
  `totalReactivePowerTime` int(11) DEFAULT NULL,
  `uUabDeviationTime` int(11) DEFAULT NULL,
  `uUbcDeviationTime` int(11) DEFAULT NULL,
  `uUcaDeviationTime` int(11) DEFAULT NULL,
  `uUnbalanceTime` int(11) DEFAULT NULL,
  `uaDeviationTime` int(11) DEFAULT NULL,
  `uaPHDTime` int(11) DEFAULT NULL,
  `uaTime` int(11) DEFAULT NULL,
  `uabTime` int(11) DEFAULT NULL,
  `ubDeviationTime` int(11) DEFAULT NULL,
  `ubPHDTime` int(11) DEFAULT NULL,
  `ubTime` int(11) DEFAULT NULL,
  `ubcTime` int(11) DEFAULT NULL,
  `ucDeviationTime` int(11) DEFAULT NULL,
  `ucPHDTime` int(11) DEFAULT NULL,
  `ucTime` int(11) DEFAULT NULL,
  `ucaTime` int(11) DEFAULT NULL,
  `zeroiTime` int(11) DEFAULT NULL,
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
  `deviceId` int(11) NOT NULL,
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
  `aLoadTime` int(11) DEFAULT NULL,
  `aPowerFactorTime` int(11) DEFAULT NULL,
  `aReactivePowerTime` int(11) DEFAULT NULL,
  `bLoadTime` int(11) DEFAULT NULL,
  `bPowerFactorTime` int(11) DEFAULT NULL,
  `bReactivePowerTime` int(11) DEFAULT NULL,
  `cLoadTime` int(11) DEFAULT NULL,
  `cPowerFactorTime` int(11) DEFAULT NULL,
  `cReactivePowerTime` int(11) DEFAULT NULL,
  `deviceId` int(11) NOT NULL,
  `iUnbalanceTime` int(11) DEFAULT NULL,
  `iaPHDTime` int(11) DEFAULT NULL,
  `iaTime` int(11) DEFAULT NULL,
  `ibPHDTime` int(11) DEFAULT NULL,
  `ibTime` int(11) DEFAULT NULL,
  `icPHDTime` int(11) DEFAULT NULL,
  `icTime` int(11) DEFAULT NULL,
  `totalLoadTime` int(11) DEFAULT NULL,
  `totalPowerFactorTime` int(11) DEFAULT NULL,
  `totalReactivePowerTime` int(11) DEFAULT NULL,
  `uUabDeviationTime` int(11) DEFAULT NULL,
  `uUbcDeviationTime` int(11) DEFAULT NULL,
  `uUcaDeviationTime` int(11) DEFAULT NULL,
  `uUnbalanceTime` int(11) DEFAULT NULL,
  `uaDeviationTime` int(11) DEFAULT NULL,
  `uaPHDTime` int(11) DEFAULT NULL,
  `uaTime` int(11) DEFAULT NULL,
  `uabTime` int(11) DEFAULT NULL,
  `ubDeviationTime` int(11) DEFAULT NULL,
  `ubPHDTime` int(11) DEFAULT NULL,
  `ubTime` int(11) DEFAULT NULL,
  `ubcTime` int(11) DEFAULT NULL,
  `ucDeviationTime` int(11) DEFAULT NULL,
  `ucPHDTime` int(11) DEFAULT NULL,
  `ucTime` int(11) DEFAULT NULL,
  `ucaTime` int(11) DEFAULT NULL,
  `zeroiTime` int(11) DEFAULT NULL,
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
  `aLoadTime` int(11) DEFAULT NULL,
  `aPowerFactorTime` int(11) DEFAULT NULL,
  `aReactivePowerTime` int(11) DEFAULT NULL,
  `bLoadTime` int(11) DEFAULT NULL,
  `bPowerFactorTime` int(11) DEFAULT NULL,
  `bReactivePowerTime` int(11) DEFAULT NULL,
  `cLoadTime` int(11) DEFAULT NULL,
  `cPowerFactorTime` int(11) DEFAULT NULL,
  `cReactivePowerTime` int(11) DEFAULT NULL,
  `deviceId` int(11) NOT NULL,
  `iUnbalanceTime` int(11) DEFAULT NULL,
  `iaPHDTime` int(11) DEFAULT NULL,
  `iaTime` int(11) DEFAULT NULL,
  `ibPHDTime` int(11) DEFAULT NULL,
  `ibTime` int(11) DEFAULT NULL,
  `icPHDTime` int(11) DEFAULT NULL,
  `icTime` int(11) DEFAULT NULL,
  `totalLoadTime` int(11) DEFAULT NULL,
  `totalPowerFactorTime` int(11) DEFAULT NULL,
  `totalReactivePowerTime` int(11) DEFAULT NULL,
  `uUabDeviationTime` int(11) DEFAULT NULL,
  `uUbcDeviationTime` int(11) DEFAULT NULL,
  `uUcaDeviationTime` int(11) DEFAULT NULL,
  `uUnbalanceTime` int(11) DEFAULT NULL,
  `uaDeviationTime` int(11) DEFAULT NULL,
  `uaPHDTime` int(11) DEFAULT NULL,
  `uaTime` int(11) DEFAULT NULL,
  `uabTime` int(11) DEFAULT NULL,
  `ubDeviationTime` int(11) DEFAULT NULL,
  `ubPHDTime` int(11) DEFAULT NULL,
  `ubTime` int(11) DEFAULT NULL,
  `ubcTime` int(11) DEFAULT NULL,
  `ucDeviationTime` int(11) DEFAULT NULL,
  `ucPHDTime` int(11) DEFAULT NULL,
  `ucTime` int(11) DEFAULT NULL,
  `ucaTime` int(11) DEFAULT NULL,
  `zeroiTime` int(11) DEFAULT NULL,
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
  `id` int(11) NOT NULL,
  `aLoad` varchar(255) DEFAULT NULL,
  `aPowerFactor` varchar(255) DEFAULT NULL,
  `aReactivePower` varchar(255) DEFAULT NULL,
  `bLoad` varchar(255) DEFAULT NULL,
  `bPowerFactor` varchar(255) DEFAULT NULL,
  `bReactivePower` varchar(255) DEFAULT NULL,
  `cLoad` varchar(255) DEFAULT NULL,
  `cPowerFactor` varchar(255) DEFAULT NULL,
  `cReactivePower` varchar(255) DEFAULT NULL,
  `dataTime` int(11) DEFAULT NULL,
  `deviceId` int(11) NOT NULL,
  `iUnbalance` varchar(255) DEFAULT NULL,
  `ia` varchar(255) DEFAULT NULL,
  `iaPHD` varchar(255) DEFAULT NULL,
  `ib` varchar(255) DEFAULT NULL,
  `ibPHD` varchar(255) DEFAULT NULL,
  `ic` varchar(255) DEFAULT NULL,
  `icPHD` varchar(255) DEFAULT NULL,
  `totalLoad` varchar(255) DEFAULT NULL,
  `totalPowerFactor` varchar(255) DEFAULT NULL,
  `totalReactivePower` varchar(255) DEFAULT NULL,
  `uUabDeviation` varchar(255) DEFAULT NULL,
  `uUbcDeviation` varchar(255) DEFAULT NULL,
  `uUcaDeviation` varchar(255) DEFAULT NULL,
  `uUnbalance` varchar(255) DEFAULT NULL,
  `ua` varchar(255) DEFAULT NULL,
  `uaDeviation` varchar(255) DEFAULT NULL,
  `uaPHD` varchar(255) DEFAULT NULL,
  `uab` varchar(255) DEFAULT NULL,
  `ub` varchar(255) DEFAULT NULL,
  `ubDeviation` varchar(255) DEFAULT NULL,
  `ubPHD` varchar(255) DEFAULT NULL,
  `ubc` varchar(255) DEFAULT NULL,
  `uc` varchar(255) DEFAULT NULL,
  `ucDeviation` varchar(255) DEFAULT NULL,
  `ucPHD` varchar(255) DEFAULT NULL,
  `uca` varchar(255) DEFAULT NULL,
  `zeroi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `aLoadTime` int(11) DEFAULT NULL,
  `aPowerFactorTime` int(11) DEFAULT NULL,
  `aReactivePowerTime` int(11) DEFAULT NULL,
  `bLoadTime` int(11) DEFAULT NULL,
  `bPowerFactorTime` int(11) DEFAULT NULL,
  `bReactivePowerTime` int(11) DEFAULT NULL,
  `cLoadTime` int(11) DEFAULT NULL,
  `cPowerFactorTime` int(11) DEFAULT NULL,
  `cReactivePowerTime` int(11) DEFAULT NULL,
  `deviceId` int(11) NOT NULL,
  `iUnbalanceTime` int(11) DEFAULT NULL,
  `iaPHDTime` int(11) DEFAULT NULL,
  `iaTime` int(11) DEFAULT NULL,
  `ibPHDTime` int(11) DEFAULT NULL,
  `ibTime` int(11) DEFAULT NULL,
  `icPHDTime` int(11) DEFAULT NULL,
  `icTime` int(11) DEFAULT NULL,
  `totalLoadTime` int(11) DEFAULT NULL,
  `totalPowerFactorTime` int(11) DEFAULT NULL,
  `totalReactivePowerTime` int(11) DEFAULT NULL,
  `uUabDeviationTime` int(11) DEFAULT NULL,
  `uUbcDeviationTime` int(11) DEFAULT NULL,
  `uUcaDeviationTime` int(11) DEFAULT NULL,
  `uUnbalanceTime` int(11) DEFAULT NULL,
  `uaDeviationTime` int(11) DEFAULT NULL,
  `uaPHDTime` int(11) DEFAULT NULL,
  `uaTime` int(11) DEFAULT NULL,
  `uabTime` int(11) DEFAULT NULL,
  `ubDeviationTime` int(11) DEFAULT NULL,
  `ubPHDTime` int(11) DEFAULT NULL,
  `ubTime` int(11) DEFAULT NULL,
  `ubcTime` int(11) DEFAULT NULL,
  `ucDeviationTime` int(11) DEFAULT NULL,
  `ucPHDTime` int(11) DEFAULT NULL,
  `ucTime` int(11) DEFAULT NULL,
  `ucaTime` int(11) DEFAULT NULL,
  `zeroiTime` int(11) DEFAULT NULL,
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
  `aLoadTime` int(11) DEFAULT NULL,
  `aPowerFactorTime` int(11) DEFAULT NULL,
  `aReactivePowerTime` int(11) DEFAULT NULL,
  `bLoadTime` int(11) DEFAULT NULL,
  `bPowerFactorTime` int(11) DEFAULT NULL,
  `bReactivePowerTime` int(11) DEFAULT NULL,
  `cLoadTime` int(11) DEFAULT NULL,
  `cPowerFactorTime` int(11) DEFAULT NULL,
  `cReactivePowerTime` int(11) DEFAULT NULL,
  `deviceId` int(11) NOT NULL,
  `iUnbalanceTime` int(11) DEFAULT NULL,
  `iaPHDTime` int(11) DEFAULT NULL,
  `iaTime` int(11) DEFAULT NULL,
  `ibPHDTime` int(11) DEFAULT NULL,
  `ibTime` int(11) DEFAULT NULL,
  `icPHDTime` int(11) DEFAULT NULL,
  `icTime` int(11) DEFAULT NULL,
  `totalLoadTime` int(11) DEFAULT NULL,
  `totalPowerFactorTime` int(11) DEFAULT NULL,
  `totalReactivePowerTime` int(11) DEFAULT NULL,
  `uUabDeviationTime` int(11) DEFAULT NULL,
  `uUbcDeviationTime` int(11) DEFAULT NULL,
  `uUcaDeviationTime` int(11) DEFAULT NULL,
  `uUnbalanceTime` int(11) DEFAULT NULL,
  `uaDeviationTime` int(11) DEFAULT NULL,
  `uaPHDTime` int(11) DEFAULT NULL,
  `uaTime` int(11) DEFAULT NULL,
  `uabTime` int(11) DEFAULT NULL,
  `ubDeviationTime` int(11) DEFAULT NULL,
  `ubPHDTime` int(11) DEFAULT NULL,
  `ubTime` int(11) DEFAULT NULL,
  `ubcTime` int(11) DEFAULT NULL,
  `ucDeviationTime` int(11) DEFAULT NULL,
  `ucPHDTime` int(11) DEFAULT NULL,
  `ucTime` int(11) DEFAULT NULL,
  `ucaTime` int(11) DEFAULT NULL,
  `zeroiTime` int(11) DEFAULT NULL,
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
  `totalLoad` varchar(255) DEFAULT NULL COMMENT '负荷',
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
) ENGINE=MyISAM AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_distribution_day
-- ----------------------------
INSERT INTO `power_distribution_day` VALUES ('1', '1', '1638547200', '2347.97', '25436.48', '7475.64', '14952.97', '3007.87', '0', '17404.46', '7018.88', '9267.85', '1117.72', '0');
INSERT INTO `power_distribution_day` VALUES ('2', '1', '1638633600', '2394.71', '29160.78', '8530.88', '17178.99', '3450.91', '0', '19939.54', '8009.64', '10647.54', '1282.36', '0');
INSERT INTO `power_distribution_day` VALUES ('3', '1', '1638720000', '2176.61', '23517.78', '6854.66', '13759.54', '2903.58', '0', '16042.97', '6435.84', '8528.16', '1078.97', '0');
INSERT INTO `power_distribution_day` VALUES ('4', '1', '1638806400', '2442.91', '27182.77', '7921.89', '16043.12', '3217.76', '0', '18577.11', '7437.86', '9943.53', '1195.72', '0');
INSERT INTO `power_distribution_day` VALUES ('5', '1', '1638892800', '1913.02', '21170.54', '6179.38', '12486.29', '2504.87', '0', '14471.63', '5801.82', '7739.00', '930.81', '0');
INSERT INTO `power_distribution_day` VALUES ('6', '1', '1638979200', '2470.03', '27857.38', '8029.27', '16389.63', '3438.48', '0', '18974.71', '7538.68', '10158.29', '1277.74', '0');
INSERT INTO `power_distribution_day` VALUES ('7', '1', '1639065600', '1790.46', '20981.96', '6113.87', '12232.60', '2635.49', '0', '14301.43', '5740.31', '7581.77', '979.35', '0');
INSERT INTO `power_distribution_day` VALUES ('8', '1', '1639152000', '2386.57', '29436.68', '8611.83', '17323.72', '3501.13', '0', '20123.91', '8085.65', '10737.24', '1301.02', '0');
INSERT INTO `power_distribution_day` VALUES ('9', '1', '1639238400', '1531.21', '28003.92', '8137.86', '16488.43', '3377.63', '0', '19115.29', '7640.63', '10219.53', '1255.13', '0');
INSERT INTO `power_distribution_day` VALUES ('10', '1', '1639324800', '1559.31', '25753.13', '7458.31', '15210.41', '3084.41', '0', '17576.19', '7002.61', '9427.41', '1146.17', '0');
INSERT INTO `power_distribution_day` VALUES ('11', '1', '1639411200', '1595.73', '22194.98', '6392.37', '13022.81', '2779.80', '0', '15106.31', '6001.80', '8071.54', '1032.97', '0');
INSERT INTO `power_distribution_day` VALUES ('12', '1', '1639497600', '1846.44', '27287.75', '7963.24', '16014.44', '3310.07', '0', '18632.46', '7476.69', '9925.75', '1230.02', '0');
INSERT INTO `power_distribution_day` VALUES ('13', '1', '1639584000', '2207.76', '22209.03', '6496.53', '13071.61', '2640.89', '0', '15182.73', '6099.59', '8101.78', '981.36', '0');
INSERT INTO `power_distribution_day` VALUES ('14', '1', '1639670400', '2098.03', '28642.26', '8332.64', '16919.83', '3389.79', '0', '19570.07', '7823.51', '10486.91', '1259.65', '0');
INSERT INTO `power_distribution_day` VALUES ('15', '1', '1639756800', '2096.82', '23982.84', '6927.61', '14160.39', '2894.83', '0', '16356.67', '6504.34', '8776.61', '1075.72', '0');
INSERT INTO `power_distribution_day` VALUES ('16', '1', '1639843200', '2188.33', '27542.71', '7961.62', '16315.06', '3266.03', '0', '18800.90', '7475.17', '10112.07', '1213.66', '0');
INSERT INTO `power_distribution_day` VALUES ('17', '1', '1639929600', '2149.40', '21125.00', '6056.82', '12398.35', '2669.82', '0', '14363.35', '5686.75', '7684.50', '992.11', '0');
INSERT INTO `power_distribution_day` VALUES ('18', '1', '1640016000', '1896.25', '28451.76', '8226.23', '16729.71', '3495.83', '0', '19391.73', '7723.60', '10369.08', '1299.05', '0');
INSERT INTO `power_distribution_day` VALUES ('19', '1', '1640102400', '2410.36', '29858.42', '8632.61', '17579.25', '3646.56', '0', '20355.84', '8105.16', '10895.62', '1355.06', '0');
INSERT INTO `power_distribution_day` VALUES ('20', '1', '1640188800', '2200.46', '28417.05', '8231.42', '16808.70', '3376.93', '0', '19401.38', '7728.48', '10418.03', '1254.87', '0');
INSERT INTO `power_distribution_day` VALUES ('21', '1', '1640275200', '2125.83', '23618.93', '6804.04', '13925.33', '2889.56', '0', '16092.99', '6388.31', '8630.92', '1073.76', '0');
INSERT INTO `power_distribution_day` VALUES ('22', '1', '1640361600', '1805.55', '23532.98', '6757.76', '13909.83', '2865.39', '0', '16030.95', '6344.86', '8621.31', '1064.78', '0');
INSERT INTO `power_distribution_day` VALUES ('23', '1', '1640448000', '1769.14', '25162.08', '7276.18', '14810.04', '3075.87', '0', '17153.85', '6831.60', '9179.26', '1142.99', '0');
INSERT INTO `power_distribution_day` VALUES ('24', '1', '1640534400', '1965.55', '27943.28', '8148.65', '16410.73', '3383.91', '0', '19079.59', '7650.76', '10171.37', '1257.46', '0');
INSERT INTO `power_distribution_day` VALUES ('25', '1', '1640620800', '2241.13', '22580.75', '6489.85', '13295.64', '2795.26', '0', '15372.68', '6093.32', '8240.64', '1038.72', '0');
INSERT INTO `power_distribution_day` VALUES ('26', '1', '1640707200', '1921.29', '20861.66', '5980.55', '12311.09', '2570.02', '0', '14200.57', '5615.14', '7630.41', '955.02', '0');
INSERT INTO `power_distribution_day` VALUES ('27', '1', '1640793600', '1686.19', '26985.72', '7817.82', '15821.58', '3346.32', '0', '18389.86', '7340.15', '9806.22', '1243.49', '0');
INSERT INTO `power_distribution_day` VALUES ('28', '1', '1640880000', '1518.07', '27637.89', '8058.22', '16216.10', '3363.57', '0', '18866.50', '7565.86', '10050.74', '1249.90', '0');
INSERT INTO `power_distribution_day` VALUES ('29', '1', '1640966400', '1615.53', '30351.62', '8869.61', '17879.50', '3602.51', '0', '20748.09', '8327.68', '11081.71', '1338.69', '0');
INSERT INTO `power_distribution_day` VALUES ('30', '1', '1641052800', '1819.88', '20846.70', '5977.24', '12287.08', '2582.38', '0', '14187.18', '5612.03', '7615.53', '959.61', '0');
INSERT INTO `power_distribution_day` VALUES ('31', '1', '1641139200', '2279.04', '27180.59', '7897.31', '16010.90', '3272.38', '0', '18554.36', '7414.79', '9923.56', '1216.02', '0');
INSERT INTO `power_distribution_day` VALUES ('32', '1', '1641225600', '1786.70', '24126.81', '6995.97', '14245.16', '2885.68', '0', '16469.99', '6568.52', '8829.15', '1072.32', '0');
INSERT INTO `power_distribution_day` VALUES ('33', '1', '1641312000', '2477.16', '23586.01', '6794.24', '13963.40', '2828.36', '0', '16084.65', '6379.11', '8654.52', '1051.02', '0');
INSERT INTO `power_distribution_day` VALUES ('34', '1', '1641398400', '2331.30', '25647.44', '7459.15', '15014.08', '3174.21', '0', '17488.66', '7003.40', '9305.73', '1179.54', '0');
INSERT INTO `power_distribution_day` VALUES ('35', '1', '1641484800', '2254.13', '20948.58', '6079.00', '12341.50', '2528.08', '0', '14296.27', '5707.57', '7649.26', '939.44', '0');
INSERT INTO `power_distribution_day` VALUES ('36', '1', '1641571200', '2321.84', '23829.58', '6915.33', '14087.87', '2826.39', '0', '16274.75', '6492.80', '8731.66', '1050.29', '0');
INSERT INTO `power_distribution_day` VALUES ('37', '1', '1641657600', '2164.09', '24847.25', '7156.84', '14587.71', '3102.69', '0', '16913.99', '6719.56', '9041.46', '1152.96', '0');
INSERT INTO `power_distribution_day` VALUES ('38', '1', '1641744000', '2346.77', '20699.56', '5970.29', '12209.52', '2519.75', '0', '14109.30', '5605.50', '7567.46', '936.34', '0');
INSERT INTO `power_distribution_day` VALUES ('39', '1', '1641830400', '2051.36', '29917.12', '8650.72', '17630.21', '3636.19', '0', '20400.57', '8122.16', '10927.20', '1351.21', '0');
INSERT INTO `power_distribution_day` VALUES ('40', '1', '1641916800', '2308.39', '24601.97', '7218.70', '14446.46', '2936.81', '0', '16822.87', '6777.64', '8953.91', '1091.32', '0');
INSERT INTO `power_distribution_day` VALUES ('41', '1', '1642003200', '1536.41', '29036.83', '8494.05', '17032.67', '3510.12', '0', '19836.27', '7975.07', '10556.85', '1304.36', '0');
INSERT INTO `power_distribution_day` VALUES ('42', '1', '1642089600', '2161.51', '20949.57', '6096.12', '12248.84', '2604.62', '0', '14283.35', '5723.64', '7591.83', '967.88', '0');
INSERT INTO `power_distribution_day` VALUES ('43', '1', '1642176000', '1648.80', '27197.74', '7977.51', '15982.43', '3237.81', '0', '18599.16', '7490.08', '9905.91', '1203.17', '0');
INSERT INTO `power_distribution_day` VALUES ('44', '1', '1642262400', '2363.59', '21437.31', '6193.57', '12576.54', '2667.19', '0', '14601.21', '5815.15', '7794.94', '991.13', '0');
INSERT INTO `power_distribution_day` VALUES ('45', '1', '1642348800', '2298.60', '28957.17', '8441.98', '16952.85', '3562.34', '0', '19757.32', '7926.18', '10507.38', '1323.76', '0');
INSERT INTO `power_distribution_day` VALUES ('46', '1', '1642435200', '1852.73', '26497.91', '7676.95', '15680.83', '3140.13', '0', '18093.74', '7207.88', '9718.98', '1166.87', '0');
INSERT INTO `power_distribution_day` VALUES ('47', '1', '1642521600', '1527.61', '20928.16', '6009.87', '12375.79', '2542.50', '0', '14257.97', '5642.67', '7670.51', '944.79', '0');
INSERT INTO `power_distribution_day` VALUES ('48', '1', '1642608000', '1620.07', '21326.35', '6153.24', '12626.64', '2546.47', '0', '14549.54', '5777.28', '7825.99', '946.27', '0');
INSERT INTO `power_distribution_day` VALUES ('49', '1', '1642694400', '1731.92', '27508.01', '8046.93', '16160.11', '3300.97', '0', '18797.94', '7555.27', '10016.03', '1226.64', '0');
INSERT INTO `power_distribution_day` VALUES ('50', '1', '1642780800', '2192.73', '25750.59', '7426.05', '15141.37', '3183.17', '0', '17539.81', '6972.32', '9384.62', '1182.87', '0');

-- ----------------------------
-- Table structure for power_distribution_hour
-- ----------------------------
DROP TABLE IF EXISTS `power_distribution_hour`;
CREATE TABLE `power_distribution_hour` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deviceId` int(11) DEFAULT NULL,
  `dataTime` int(11) DEFAULT NULL COMMENT '精确到小时查询的时间戳',
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
  `deviceId` int(11) DEFAULT NULL,
  `load` varchar(255) DEFAULT NULL,
  `dataTime` int(11) DEFAULT NULL,
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
) ENGINE=MyISAM AUTO_INCREMENT=551 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_realtime
-- ----------------------------
INSERT INTO `power_realtime` VALUES ('1', '1', '1640679300', '1797.60', '637.23', '579.38', '581.00', '593.61', '201.80', '182.32', '209.49', '0.9223', '0.9970', '0.9503', '0.9680', '2995.85', '2972.69', '2975.92', '197.71', '224.55', '222.38', '223.11', '393.16', '382.05', '393.42');
INSERT INTO `power_realtime` VALUES ('2', '1', '1640679600', '1951.51', '676.97', '639.60', '634.94', '562.41', '195.71', '171.60', '195.10', '0.9293', '0.9158', '0.9978', '0.9249', '2994.17', '2956.29', '2971.46', '199.81', '224.83', '223.85', '220.01', '382.42', '396.55', '391.47');
INSERT INTO `power_realtime` VALUES ('3', '1', '1640679900', '2360.10', '798.10', '744.96', '817.04', '718.25', '242.83', '229.87', '245.55', '0.9915', '0.9006', '0.9375', '0.9172', '2953.74', '2986.66', '2996.98', '199.41', '221.07', '221.04', '224.93', '383.45', '385.13', '394.92');
INSERT INTO `power_realtime` VALUES ('4', '1', '1640680200', '1802.42', '608.83', '579.47', '614.12', '616.61', '224.72', '186.18', '205.71', '0.9866', '0.9472', '0.9713', '0.9003', '2953.10', '2954.24', '2987.25', '197.66', '227.19', '229.92', '227.55', '391.17', '381.14', '384.87');
INSERT INTO `power_realtime` VALUES ('5', '1', '1640680500', '1931.23', '672.24', '597.60', '661.40', '926.59', '317.22', '294.54', '314.83', '0.9004', '0.9557', '0.9524', '0.9084', '2954.47', '2995.99', '2997.07', '197.82', '225.57', '225.65', '220.02', '394.35', '395.83', '396.21');
INSERT INTO `power_realtime` VALUES ('6', '1', '1640680800', '1628.94', '566.69', '537.38', '524.86', '522.19', '178.95', '163.39', '179.85', '0.9833', '0.9291', '0.9360', '0.9027', '2988.51', '2975.85', '2954.60', '196.88', '225.34', '228.09', '229.03', '383.68', '385.45', '384.39');
INSERT INTO `power_realtime` VALUES ('7', '1', '1640681100', '1824.11', '629.08', '583.01', '612.01', '694.11', '243.78', '213.78', '236.55', '0.9139', '0.9031', '0.9223', '0.9842', '2988.27', '2955.61', '2966.80', '199.68', '223.61', '226.01', '226.39', '399.21', '391.07', '384.79');
INSERT INTO `power_realtime` VALUES ('8', '1', '1640681400', '2795.11', '952.14', '910.26', '932.72', '700.99', '243.03', '226.39', '231.56', '0.9726', '0.9616', '0.9695', '0.9124', '2965.31', '2984.51', '2986.74', '198.46', '222.99', '220.19', '229.91', '385.60', '383.56', '383.08');
INSERT INTO `power_realtime` VALUES ('9', '1', '1640681700', '2918.68', '1018.54', '926.45', '973.69', '540.07', '181.23', '166.91', '191.94', '0.9483', '0.9507', '0.9005', '0.9922', '2957.07', '2970.98', '2981.04', '197.55', '224.06', '222.35', '228.38', '387.19', '384.53', '385.87');
INSERT INTO `power_realtime` VALUES ('10', '1', '1640682000', '2361.60', '801.38', '753.32', '806.90', '555.90', '188.40', '168.19', '199.31', '0.9403', '0.9582', '0.9381', '0.9576', '2978.22', '2988.36', '2957.86', '197.47', '226.47', '220.99', '222.43', '386.04', '393.48', '389.06');
INSERT INTO `power_realtime` VALUES ('11', '1', '1640682300', '2863.84', '993.45', '944.99', '925.40', '822.45', '291.93', '256.17', '274.35', '0.9570', '0.9547', '0.9667', '0.9686', '2979.29', '2960.48', '2978.80', '197.03', '229.47', '228.65', '226.92', '383.40', '393.90', '386.10');
INSERT INTO `power_realtime` VALUES ('12', '1', '1640682600', '2520.38', '846.97', '835.47', '837.94', '629.37', '211.58', '194.29', '223.51', '0.9691', '0.9156', '0.9498', '0.9722', '2953.65', '2971.19', '2984.45', '197.12', '229.69', '226.23', '220.37', '389.81', '394.26', '380.07');
INSERT INTO `power_realtime` VALUES ('13', '1', '1640682900', '1838.02', '659.76', '570.00', '608.25', '875.80', '302.85', '289.27', '283.68', '0.9351', '0.9387', '0.9122', '0.9374', '2989.10', '2995.15', '2960.92', '197.78', '222.76', '220.11', '222.67', '380.23', '385.79', '381.99');
INSERT INTO `power_realtime` VALUES ('14', '1', '1640683200', '2821.25', '985.24', '891.89', '944.12', '726.86', '243.22', '234.51', '249.13', '0.9910', '0.9663', '0.9483', '0.9740', '2982.35', '2954.77', '2965.19', '199.93', '224.45', '226.17', '224.10', '389.09', '386.20', '393.21');
INSERT INTO `power_realtime` VALUES ('15', '1', '1640683500', '2928.68', '1019.74', '932.20', '976.75', '517.15', '185.38', '161.23', '170.54', '0.9750', '0.9848', '0.9150', '0.9766', '2974.34', '2970.89', '2959.17', '197.71', '227.64', '221.55', '226.21', '385.02', '388.03', '382.36');
INSERT INTO `power_realtime` VALUES ('16', '1', '1640683800', '1938.36', '683.62', '632.79', '621.95', '592.92', '212.59', '180.22', '200.12', '0.9503', '0.9350', '0.9388', '0.9003', '2970.63', '2991.66', '2977.17', '197.97', '222.18', '220.08', '228.87', '397.23', '381.37', '395.99');
INSERT INTO `power_realtime` VALUES ('17', '1', '1640684100', '2566.47', '861.28', '824.28', '880.91', '570.65', '209.30', '176.76', '184.59', '0.9872', '0.9040', '0.9836', '0.9770', '2985.06', '2956.07', '2968.14', '198.87', '227.57', '221.39', '227.06', '384.37', '393.96', '388.58');
INSERT INTO `power_realtime` VALUES ('18', '1', '1640684400', '1599.47', '549.44', '529.38', '520.64', '853.09', '299.65', '279.66', '273.78', '0.9774', '0.9931', '0.9135', '0.9151', '2985.94', '2975.11', '2963.00', '197.07', '220.67', '225.15', '226.76', '382.35', '386.54', '380.44');
INSERT INTO `power_realtime` VALUES ('19', '1', '1640684700', '2824.33', '983.65', '918.79', '921.89', '686.09', '232.50', '211.06', '242.53', '0.9692', '0.9672', '0.9239', '0.9948', '2981.85', '2994.61', '2968.41', '199.29', '225.55', '223.18', '220.46', '380.32', '398.24', '391.58');
INSERT INTO `power_realtime` VALUES ('20', '1', '1640685000', '2676.39', '919.59', '861.13', '895.67', '559.23', '192.95', '181.17', '185.11', '0.9437', '0.9807', '0.9172', '0.9765', '2959.81', '2989.87', '2981.72', '198.81', '226.86', '220.46', '220.12', '393.62', '395.55', '396.70');
INSERT INTO `power_realtime` VALUES ('21', '1', '1640685300', '2767.32', '937.58', '881.21', '948.54', '851.77', '301.58', '270.24', '279.95', '0.9846', '0.9552', '0.9589', '0.9749', '2980.99', '2982.52', '2957.45', '197.58', '224.51', '224.06', '228.94', '388.59', '398.88', '399.81');
INSERT INTO `power_realtime` VALUES ('22', '1', '1640685600', '1809.32', '617.52', '570.29', '621.52', '801.31', '271.75', '263.58', '265.98', '0.9480', '0.9432', '0.9720', '0.9285', '2998.71', '2965.68', '2983.05', '196.80', '224.16', '224.28', '222.14', '387.82', '383.40', '397.44');
INSERT INTO `power_realtime` VALUES ('23', '1', '1640685900', '2913.60', '995.25', '930.76', '987.59', '627.25', '218.62', '202.46', '206.17', '0.9866', '0.9604', '0.9050', '0.9955', '2990.64', '2973.03', '2991.80', '199.68', '225.65', '227.28', '222.53', '384.15', '395.04', '386.86');
INSERT INTO `power_realtime` VALUES ('24', '1', '1640686200', '1813.31', '611.82', '582.74', '618.75', '973.59', '331.04', '323.45', '319.09', '0.9559', '0.9989', '0.9501', '0.9547', '2990.98', '2982.31', '2952.77', '199.27', '220.54', '220.38', '227.25', '398.98', '388.89', '399.77');
INSERT INTO `power_realtime` VALUES ('25', '1', '1640686500', '1742.08', '602.94', '564.05', '575.09', '746.09', '255.56', '247.82', '242.71', '0.9983', '0.9459', '0.9842', '0.9596', '2969.85', '2953.13', '2981.75', '199.39', '229.50', '223.21', '229.53', '394.35', '385.21', '383.03');
INSERT INTO `power_realtime` VALUES ('26', '1', '1640686800', '2989.81', '998.13', '966.32', '1025.36', '907.91', '307.60', '298.68', '301.62', '0.9910', '0.9364', '0.9643', '0.9087', '2985.38', '2962.64', '2963.95', '199.55', '220.67', '226.73', '221.95', '388.80', '388.30', '386.11');
INSERT INTO `power_realtime` VALUES ('27', '1', '1640687100', '2557.43', '856.94', '819.02', '881.47', '864.25', '298.27', '284.72', '281.26', '0.9330', '0.9469', '0.9270', '0.9364', '2979.93', '2971.81', '2967.31', '197.27', '222.10', '220.83', '226.83', '394.88', '385.46', '389.50');
INSERT INTO `power_realtime` VALUES ('28', '1', '1640687400', '2841.45', '963.50', '910.43', '967.52', '712.19', '245.73', '217.99', '248.47', '0.9509', '0.9088', '0.9153', '0.9094', '2954.39', '2977.97', '2956.69', '198.28', '223.44', '227.17', '223.92', '390.64', '396.80', '380.29');
INSERT INTO `power_realtime` VALUES ('29', '1', '1640687700', '2897.85', '980.54', '919.26', '998.05', '854.34', '288.60', '267.27', '298.47', '0.9175', '0.9698', '0.9949', '0.9264', '2984.81', '2987.74', '2991.64', '197.73', '225.88', '229.20', '226.67', '398.67', '382.26', '389.38');
INSERT INTO `power_realtime` VALUES ('30', '1', '1640688000', '2062.97', '729.82', '673.20', '659.94', '776.87', '267.73', '242.38', '266.75', '0.9954', '0.9706', '0.9152', '0.9648', '2992.71', '2976.91', '2956.15', '197.02', '223.22', '224.41', '224.81', '394.76', '390.06', '390.68');
INSERT INTO `power_realtime` VALUES ('31', '1', '1640688300', '2046.19', '717.48', '651.30', '677.41', '671.27', '232.82', '218.38', '220.06', '0.9519', '0.9222', '0.9266', '0.9034', '2994.77', '2991.65', '2975.64', '197.21', '222.86', '225.86', '223.76', '383.13', '389.51', '384.46');
INSERT INTO `power_realtime` VALUES ('32', '1', '1640688600', '1556.42', '560.65', '505.09', '490.68', '537.26', '187.50', '168.38', '181.38', '0.9310', '0.9780', '0.9770', '0.9628', '2989.28', '2987.01', '2976.50', '198.89', '221.05', '220.03', '229.78', '397.53', '392.96', '386.63');
INSERT INTO `power_realtime` VALUES ('33', '1', '1640688900', '2580.01', '895.03', '839.75', '845.24', '939.50', '325.04', '312.84', '301.63', '0.9176', '0.9814', '0.9877', '0.9582', '2985.53', '2996.29', '2984.88', '198.51', '224.68', '226.83', '224.72', '395.86', '394.45', '381.66');
INSERT INTO `power_realtime` VALUES ('34', '1', '1640689200', '2593.74', '902.98', '820.07', '870.69', '704.68', '252.41', '218.89', '233.37', '0.9891', '0.9462', '0.9374', '0.9437', '2998.16', '2975.50', '2995.56', '197.62', '229.20', '224.80', '224.04', '392.46', '397.55', '389.68');
INSERT INTO `power_realtime` VALUES ('35', '1', '1640689500', '1771.11', '596.77', '548.05', '626.29', '537.52', '180.46', '161.77', '195.30', '0.9186', '0.9835', '0.9781', '0.9463', '2961.80', '2974.09', '2967.70', '198.79', '221.99', '229.86', '228.82', '394.07', '392.02', '388.26');
INSERT INTO `power_realtime` VALUES ('36', '1', '1640689800', '1624.58', '573.21', '498.31', '553.05', '804.21', '271.88', '251.52', '280.81', '0.9705', '0.9342', '0.9563', '0.9419', '2971.53', '2993.39', '2972.82', '198.84', '220.19', '229.98', '224.40', '395.61', '387.39', '396.20');
INSERT INTO `power_realtime` VALUES ('37', '1', '1640690100', '2020.01', '673.38', '644.66', '701.97', '579.72', '193.87', '179.65', '206.20', '0.9174', '0.9904', '0.9259', '0.9145', '2972.32', '2960.40', '2980.54', '198.32', '222.78', '220.83', '226.69', '387.97', '382.23', '389.75');
INSERT INTO `power_realtime` VALUES ('38', '1', '1640690400', '1602.61', '583.97', '516.61', '502.03', '982.13', '344.43', '317.04', '320.67', '0.9056', '0.9029', '0.9064', '0.9605', '2955.31', '2964.18', '2970.61', '196.77', '228.95', '227.85', '221.37', '393.26', '380.44', '382.80');
INSERT INTO `power_realtime` VALUES ('39', '1', '1640690700', '2386.05', '806.58', '787.33', '792.15', '821.16', '291.55', '258.32', '271.29', '0.9992', '0.9679', '0.9726', '0.9588', '2970.60', '2977.57', '2954.34', '198.97', '227.25', '229.94', '221.43', '393.39', '380.22', '399.36');
INSERT INTO `power_realtime` VALUES ('40', '1', '1640691000', '2078.26', '695.92', '665.28', '717.07', '670.65', '241.62', '217.57', '211.47', '0.9519', '0.9643', '0.9487', '0.9183', '2985.51', '2966.39', '2975.94', '198.47', '223.94', '227.32', '224.49', '394.49', '397.45', '381.02');
INSERT INTO `power_realtime` VALUES ('41', '1', '1640691300', '2648.52', '929.25', '840.54', '878.73', '635.66', '218.54', '195.88', '221.24', '0.9776', '0.9810', '0.9291', '0.9388', '2953.27', '2972.54', '2993.09', '197.88', '223.68', '222.47', '223.41', '393.82', '383.60', '383.36');
INSERT INTO `power_realtime` VALUES ('42', '1', '1640691600', '2680.93', '916.36', '872.93', '891.64', '823.13', '280.72', '257.40', '285.01', '0.9278', '0.9190', '0.9571', '0.9828', '2960.90', '2996.48', '2958.02', '197.03', '220.97', '227.70', '221.57', '386.49', '398.08', '382.82');
INSERT INTO `power_realtime` VALUES ('43', '1', '1640691900', '2209.46', '742.24', '703.52', '763.70', '842.54', '296.29', '271.76', '274.49', '0.9249', '0.9903', '0.9558', '0.9506', '2995.34', '2998.46', '2983.41', '197.06', '227.93', '225.78', '228.32', '387.05', '396.69', '380.84');
INSERT INTO `power_realtime` VALUES ('44', '1', '1640692200', '2488.75', '853.68', '822.81', '812.26', '557.43', '191.12', '182.57', '183.75', '0.9555', '0.9505', '0.9371', '0.9768', '2955.09', '2985.91', '2983.86', '197.70', '220.73', '221.52', '229.62', '385.20', '381.93', '393.31');
INSERT INTO `power_realtime` VALUES ('45', '1', '1640692500', '2023.71', '705.66', '638.98', '679.06', '782.34', '265.74', '249.07', '267.53', '0.9890', '0.9059', '0.9970', '0.9339', '2989.25', '2957.77', '2981.16', '199.18', '226.14', '222.44', '224.91', '386.82', '386.18', '392.28');
INSERT INTO `power_realtime` VALUES ('46', '1', '1640692800', '2158.97', '724.35', '707.04', '727.58', '670.44', '232.93', '208.77', '228.74', '0.9602', '0.9218', '0.9520', '0.9230', '2968.56', '2984.17', '2951.97', '199.84', '228.51', '224.51', '222.93', '389.15', '386.33', '382.27');
INSERT INTO `power_realtime` VALUES ('47', '1', '1640693100', '1616.56', '570.15', '505.11', '541.31', '667.09', '224.49', '208.79', '233.81', '0.9320', '0.9311', '0.9744', '0.9641', '2981.93', '2962.33', '2979.06', '198.86', '228.03', '226.12', '226.63', '384.55', '397.98', '385.62');
INSERT INTO `power_realtime` VALUES ('48', '1', '1640693400', '2566.94', '896.75', '827.58', '842.61', '611.59', '206.35', '187.10', '218.14', '0.9509', '0.9939', '0.9521', '0.9662', '2958.85', '2956.68', '2991.49', '197.09', '222.32', '228.59', '221.28', '399.14', '388.27', '380.88');
INSERT INTO `power_realtime` VALUES ('49', '1', '1640693700', '1624.85', '551.10', '505.72', '568.03', '855.36', '286.20', '270.30', '298.86', '0.9010', '0.9048', '0.9167', '0.9566', '2991.90', '2953.17', '2996.19', '197.86', '225.62', '224.93', '228.98', '391.39', '399.75', '384.00');
INSERT INTO `power_realtime` VALUES ('50', '1', '1640694000', '1576.78', '543.32', '515.10', '518.36', '628.33', '210.03', '207.25', '211.05', '0.9778', '0.9614', '0.9704', '0.9846', '2974.26', '2983.97', '2961.94', '197.09', '222.78', '221.10', '228.65', '381.61', '392.49', '385.17');
INSERT INTO `power_realtime` VALUES ('51', '1', '1641277800', '2770.26', '930.00', '873.84', '966.42', '537.10', '197.54', '168.30', '171.26', '0.9777', '0.9283', '0.9108', '0.9871', '2966.24', '2971.64', '2993.78', '198.61', '226.56', '228.12', '225.68', '388.23', '395.07', '393.50');
INSERT INTO `power_realtime` VALUES ('52', '1', '1641278100', '2533.85', '861.67', '823.59', '848.59', '628.68', '213.38', '194.19', '221.11', '0.9451', '0.9097', '0.9029', '0.9959', '2970.53', '2999.94', '2968.82', '199.68', '226.46', '229.08', '221.48', '394.04', '382.35', '387.56');
INSERT INTO `power_realtime` VALUES ('53', '1', '1641278400', '1840.50', '654.21', '606.83', '579.46', '891.74', '303.59', '278.56', '309.59', '0.9367', '0.9606', '0.9649', '0.9368', '2978.15', '2979.66', '2952.94', '198.38', '223.61', '227.45', '229.42', '388.41', '397.81', '396.99');
INSERT INTO `power_realtime` VALUES ('54', '1', '1641278700', '2765.57', '946.15', '916.14', '903.28', '618.36', '219.44', '206.08', '192.84', '0.9774', '0.9582', '0.9855', '0.9046', '2975.76', '2963.06', '2956.40', '199.96', '221.99', '224.42', '224.52', '381.12', '395.23', '392.46');
INSERT INTO `power_realtime` VALUES ('55', '1', '1641279000', '2433.96', '858.90', '768.81', '806.24', '710.78', '250.22', '223.15', '237.41', '0.9192', '0.9830', '0.9956', '0.9626', '2981.85', '2968.18', '2987.14', '197.87', '221.63', '225.15', '225.36', '394.42', '399.70', '382.82');
INSERT INTO `power_realtime` VALUES ('56', '1', '1641279300', '2842.54', '954.71', '936.19', '951.65', '536.79', '196.15', '169.08', '171.56', '0.9607', '0.9461', '0.9494', '0.9929', '2958.78', '2969.49', '2987.65', '196.88', '229.67', '225.21', '222.56', '389.39', '385.53', '399.95');
INSERT INTO `power_realtime` VALUES ('57', '1', '1641279600', '1669.86', '587.58', '556.17', '526.10', '832.77', '286.76', '269.06', '276.94', '0.9910', '0.9866', '0.9382', '0.9625', '2982.23', '2958.32', '2996.84', '198.82', '220.59', '223.57', '223.08', '382.62', '387.01', '382.73');
INSERT INTO `power_realtime` VALUES ('58', '1', '1641279900', '2087.36', '713.59', '661.07', '712.71', '735.63', '247.47', '235.63', '252.53', '0.9671', '0.9264', '0.9518', '0.9960', '2967.69', '2989.33', '2974.24', '197.54', '223.45', '227.28', '224.51', '396.35', '396.39', '391.54');
INSERT INTO `power_realtime` VALUES ('59', '1', '1641280200', '2689.73', '930.00', '857.67', '902.06', '950.68', '332.47', '315.35', '302.86', '0.9269', '0.9813', '0.9698', '0.9737', '2988.36', '2999.85', '2976.42', '196.75', '225.80', '223.81', '227.16', '388.05', '395.94', '385.16');
INSERT INTO `power_realtime` VALUES ('60', '1', '1641280500', '2373.99', '802.30', '759.63', '812.06', '567.24', '205.74', '174.72', '186.79', '0.9488', '0.9251', '0.9956', '0.9265', '2970.78', '2963.50', '2970.55', '196.96', '226.57', '226.35', '222.28', '395.86', '385.53', '389.14');
INSERT INTO `power_realtime` VALUES ('61', '1', '1641280800', '1819.05', '612.91', '592.87', '613.27', '616.14', '215.52', '195.42', '205.20', '0.9838', '0.9816', '0.9361', '0.9932', '2973.63', '2969.39', '2956.80', '198.84', '224.38', '225.16', '220.61', '393.14', '382.93', '398.92');
INSERT INTO `power_realtime` VALUES ('62', '1', '1641281100', '2648.44', '926.76', '873.29', '848.39', '623.97', '226.51', '198.53', '198.93', '0.9093', '0.9869', '0.9766', '0.9289', '2991.35', '2952.47', '2950.91', '199.92', '221.85', '224.05', '227.72', '389.37', '392.66', '392.39');
INSERT INTO `power_realtime` VALUES ('63', '1', '1641281400', '2899.51', '1015.72', '942.62', '941.18', '657.65', '232.41', '205.97', '219.27', '0.9909', '0.9097', '0.9090', '0.9164', '2977.71', '2989.56', '2999.33', '196.77', '222.56', '225.84', '220.14', '385.32', '398.92', '393.82');
INSERT INTO `power_realtime` VALUES ('64', '1', '1641281700', '2072.25', '717.12', '642.02', '713.10', '669.86', '238.76', '222.85', '208.25', '0.9803', '0.9543', '0.9383', '0.9234', '2955.16', '2969.35', '2963.26', '198.31', '223.69', '223.60', '220.79', '388.12', '399.90', '396.81');
INSERT INTO `power_realtime` VALUES ('65', '1', '1641282000', '2290.18', '770.04', '755.65', '764.49', '850.82', '299.44', '265.64', '285.74', '0.9296', '0.9879', '0.9193', '0.9806', '2963.61', '2993.03', '2963.41', '198.48', '224.73', '225.91', '221.35', '396.34', '384.76', '394.83');
INSERT INTO `power_realtime` VALUES ('66', '1', '1641282300', '1974.47', '678.36', '615.52', '680.59', '665.14', '238.96', '215.44', '210.74', '0.9675', '0.9341', '0.9606', '0.9154', '2957.24', '2965.27', '2975.68', '197.23', '221.39', '224.46', '225.61', '396.51', '380.04', '386.87');
INSERT INTO `power_realtime` VALUES ('67', '1', '1641282600', '2410.41', '840.05', '777.36', '793.00', '803.55', '281.45', '249.43', '272.66', '0.9523', '0.9643', '0.9787', '0.9778', '2980.34', '2993.08', '2957.75', '198.58', '222.89', '220.44', '229.15', '390.96', '399.66', '381.30');
INSERT INTO `power_realtime` VALUES ('68', '1', '1641282900', '1672.65', '558.89', '551.87', '561.88', '908.98', '310.71', '290.55', '307.71', '0.9981', '0.9867', '0.9889', '0.9216', '2992.38', '2972.39', '2969.31', '199.41', '221.25', '223.07', '228.49', '381.75', '382.15', '392.87');
INSERT INTO `power_realtime` VALUES ('69', '1', '1641283200', '2572.74', '867.68', '809.68', '895.37', '643.82', '229.54', '201.79', '212.49', '0.9626', '0.9911', '0.9851', '0.9761', '2969.25', '2959.65', '2972.84', '199.57', '222.57', '228.90', '226.45', '387.72', '390.03', '397.58');
INSERT INTO `power_realtime` VALUES ('70', '1', '1641283500', '1598.26', '540.24', '518.90', '539.13', '950.71', '325.15', '310.56', '314.99', '0.9826', '0.9434', '0.9818', '0.9391', '2981.26', '2997.10', '2969.05', '199.45', '222.13', '224.04', '229.87', '390.28', '399.09', '395.72');
INSERT INTO `power_realtime` VALUES ('71', '1', '1641283800', '1728.62', '604.36', '573.29', '550.97', '723.31', '259.52', '221.34', '242.45', '0.9546', '0.9523', '0.9766', '0.9613', '2989.67', '2987.37', '2979.52', '198.67', '228.67', '223.74', '221.49', '389.68', '380.66', '396.66');
INSERT INTO `power_realtime` VALUES ('72', '1', '1641284100', '2037.36', '688.15', '675.72', '673.49', '545.12', '190.45', '179.37', '175.30', '0.9754', '0.9356', '0.9319', '0.9581', '2961.36', '2993.88', '2990.64', '199.20', '226.89', '223.98', '229.00', '385.88', '396.61', '398.57');
INSERT INTO `power_realtime` VALUES ('73', '1', '1641284400', '1625.20', '588.51', '505.97', '530.73', '674.47', '242.94', '219.95', '211.58', '0.9850', '0.9086', '0.9767', '0.9904', '2976.92', '2979.65', '2966.06', '197.51', '222.41', '229.20', '221.69', '397.63', '385.41', '393.22');
INSERT INTO `power_realtime` VALUES ('74', '1', '1641284700', '2671.69', '893.15', '874.44', '904.10', '552.12', '192.26', '175.42', '184.43', '0.9948', '0.9926', '0.9897', '0.9955', '2999.70', '2987.53', '2970.28', '197.48', '229.41', '227.19', '228.38', '380.03', '398.69', '399.19');
INSERT INTO `power_realtime` VALUES ('75', '1', '1641285000', '2246.11', '765.44', '743.34', '737.34', '784.00', '262.41', '249.08', '272.51', '0.9251', '0.9056', '0.9469', '0.9177', '2983.27', '2960.31', '2973.88', '197.59', '227.77', '228.31', '229.58', '393.74', '389.52', '397.70');
INSERT INTO `power_realtime` VALUES ('76', '1', '1641285300', '2481.16', '865.85', '784.71', '830.60', '806.05', '280.21', '255.47', '270.37', '0.9388', '0.9399', '0.9932', '0.9996', '2971.55', '2998.95', '2980.70', '196.92', '224.61', '220.49', '221.87', '399.47', '398.62', '392.23');
INSERT INTO `power_realtime` VALUES ('77', '1', '1641285600', '2784.28', '933.85', '890.90', '959.54', '770.73', '262.96', '256.31', '251.46', '0.9173', '0.9653', '0.9395', '0.9339', '2989.93', '2961.85', '2979.17', '197.24', '223.73', '224.01', '223.63', '398.19', '390.59', '397.64');
INSERT INTO `power_realtime` VALUES ('78', '1', '1641285900', '2942.86', '990.04', '955.96', '996.86', '605.28', '215.43', '190.38', '199.48', '0.9057', '0.9077', '0.9845', '0.9516', '2987.10', '2967.49', '2974.64', '199.68', '226.14', '221.47', '228.33', '391.40', '380.42', '385.19');
INSERT INTO `power_realtime` VALUES ('79', '1', '1641286200', '2269.99', '790.63', '708.48', '770.88', '680.71', '244.68', '218.22', '217.81', '0.9324', '0.9556', '0.9159', '0.9321', '2965.69', '2976.74', '2955.48', '198.08', '225.55', '227.62', '224.43', '396.69', '380.51', '388.12');
INSERT INTO `power_realtime` VALUES ('80', '1', '1641286500', '2837.49', '973.96', '945.08', '918.45', '597.27', '207.79', '197.42', '192.05', '0.9070', '0.9282', '0.9665', '0.9674', '2985.37', '2999.77', '2984.71', '199.74', '224.13', '222.24', '229.89', '381.38', '390.44', '387.24');
INSERT INTO `power_realtime` VALUES ('81', '1', '1641286800', '1851.95', '633.06', '591.05', '627.84', '737.34', '261.49', '245.76', '230.08', '0.9017', '0.9066', '0.9738', '0.9876', '2985.27', '2995.92', '2989.77', '198.14', '226.44', '225.21', '224.22', '391.41', '385.18', '387.41');
INSERT INTO `power_realtime` VALUES ('82', '1', '1641287100', '1848.50', '627.65', '599.40', '621.45', '959.55', '324.35', '317.03', '318.16', '0.9310', '0.9835', '0.9293', '0.9725', '2952.10', '2963.13', '2995.57', '198.52', '222.84', '228.17', '221.52', '394.36', '393.36', '384.75');
INSERT INTO `power_realtime` VALUES ('83', '1', '1641287400', '2104.70', '715.19', '692.05', '697.47', '609.57', '204.78', '201.76', '203.03', '0.9723', '0.9215', '0.9990', '0.9171', '2957.97', '2995.91', '2961.80', '198.13', '227.96', '220.44', '225.07', '383.33', '394.36', '389.60');
INSERT INTO `power_realtime` VALUES ('84', '1', '1641287700', '2014.68', '681.87', '647.61', '685.20', '902.05', '310.97', '291.69', '299.40', '0.9945', '0.9328', '0.9501', '0.9046', '2956.16', '2978.75', '2992.35', '199.85', '225.36', '228.59', '226.12', '383.93', '382.61', '392.58');
INSERT INTO `power_realtime` VALUES ('85', '1', '1641288000', '2610.21', '892.52', '848.15', '869.55', '685.98', '243.45', '213.29', '229.24', '0.9076', '0.9980', '0.9338', '0.9550', '2954.67', '2973.61', '2984.38', '199.72', '225.32', '229.32', '228.78', '388.43', '388.67', '380.56');
INSERT INTO `power_realtime` VALUES ('86', '1', '1641288300', '2471.59', '851.50', '813.65', '806.45', '641.16', '222.11', '208.39', '210.67', '0.9924', '0.9288', '0.9471', '0.9673', '2986.14', '2957.22', '2976.51', '199.37', '220.40', '223.99', '226.78', '389.99', '389.52', '385.05');
INSERT INTO `power_realtime` VALUES ('87', '1', '1641288600', '2436.84', '826.69', '776.63', '833.52', '567.58', '198.92', '178.59', '190.06', '0.9318', '0.9594', '0.9293', '0.9608', '2958.86', '2965.29', '2989.34', '197.17', '221.10', '220.24', '228.84', '385.77', '385.88', '398.75');
INSERT INTO `power_realtime` VALUES ('88', '1', '1641288900', '2792.48', '933.74', '881.04', '977.70', '620.83', '214.00', '195.69', '211.14', '0.9303', '0.9038', '0.9406', '0.9376', '2956.49', '2956.97', '2977.64', '199.40', '223.22', '221.60', '225.45', '380.30', '390.92', '385.72');
INSERT INTO `power_realtime` VALUES ('89', '1', '1641289200', '2013.58', '709.31', '629.23', '675.05', '617.39', '220.19', '204.59', '192.61', '0.9910', '0.9620', '0.9229', '0.9454', '2954.68', '2973.84', '2981.92', '199.65', '228.46', '220.08', '222.39', '389.95', '383.49', '397.33');
INSERT INTO `power_realtime` VALUES ('90', '1', '1641289500', '2114.22', '719.32', '697.80', '697.10', '881.20', '309.50', '289.95', '281.75', '0.9012', '0.9856', '0.9511', '0.9032', '2990.17', '2983.19', '2977.69', '199.44', '220.71', '229.01', '224.54', '385.85', '389.83', '389.73');
INSERT INTO `power_realtime` VALUES ('91', '1', '1641289800', '2772.79', '951.67', '898.71', '922.41', '529.46', '190.61', '167.98', '170.87', '0.9798', '0.9247', '0.9577', '0.9818', '2952.67', '2965.72', '2973.17', '197.19', '222.35', '224.49', '227.64', '395.76', '389.86', '399.09');
INSERT INTO `power_realtime` VALUES ('92', '1', '1641290100', '2608.75', '881.74', '824.40', '902.62', '600.10', '209.80', '181.95', '208.35', '0.9422', '0.9719', '0.9380', '0.9802', '2971.92', '2982.61', '2951.19', '198.16', '227.77', '222.66', '225.91', '395.52', '398.82', '387.95');
INSERT INTO `power_realtime` VALUES ('93', '1', '1641290400', '2809.31', '974.49', '886.99', '947.83', '505.45', '178.38', '162.71', '164.36', '0.9553', '0.9025', '0.9362', '0.9370', '2991.10', '2986.71', '2988.24', '199.23', '224.83', '228.29', '229.65', '397.87', '390.98', '390.71');
INSERT INTO `power_realtime` VALUES ('94', '1', '1641290700', '2235.68', '747.88', '739.81', '747.98', '957.87', '334.86', '311.79', '311.22', '0.9807', '0.9742', '0.9596', '0.9377', '2954.25', '2976.82', '2962.61', '198.81', '229.97', '225.81', '228.57', '390.12', '390.59', '396.69');
INSERT INTO `power_realtime` VALUES ('95', '1', '1641291000', '2179.07', '769.36', '706.02', '703.69', '751.44', '255.57', '240.03', '255.84', '0.9369', '0.9955', '0.9745', '0.9396', '2988.85', '2982.96', '2985.15', '197.11', '228.03', '228.97', '224.96', '383.07', '394.81', '397.79');
INSERT INTO `power_realtime` VALUES ('96', '1', '1641291300', '2586.45', '890.16', '833.27', '863.01', '600.76', '214.14', '189.83', '196.79', '0.9565', '0.9114', '0.9074', '0.9313', '2985.23', '2964.55', '2999.78', '199.02', '224.55', '227.90', '224.60', '391.12', '395.52', '392.12');
INSERT INTO `power_realtime` VALUES ('97', '1', '1641291600', '1835.34', '641.09', '595.36', '598.88', '633.13', '211.07', '197.35', '224.71', '0.9659', '0.9662', '0.9989', '0.9720', '2962.44', '2951.34', '2956.73', '197.81', '225.76', '224.28', '222.88', '388.04', '390.58', '397.06');
INSERT INTO `power_realtime` VALUES ('98', '1', '1641291900', '2505.79', '868.20', '821.64', '815.95', '603.42', '202.83', '185.01', '215.57', '0.9799', '0.9113', '0.9444', '0.9194', '2965.11', '2960.50', '2959.35', '198.34', '229.84', '224.85', '229.81', '394.31', '380.59', '383.31');
INSERT INTO `power_realtime` VALUES ('99', '1', '1641292200', '1575.39', '527.62', '502.54', '545.22', '951.99', '335.61', '315.46', '300.91', '0.9715', '0.9087', '0.9022', '0.9505', '2958.23', '2980.62', '2975.66', '198.60', '222.50', '222.02', '228.98', '390.15', '394.88', '397.50');
INSERT INTO `power_realtime` VALUES ('100', '1', '1641292500', '2550.81', '885.52', '845.06', '820.23', '955.88', '318.82', '311.61', '325.45', '0.9622', '0.9527', '0.9518', '0.9164', '2976.00', '2976.12', '2988.17', '199.67', '220.19', '227.26', '223.26', '393.50', '399.54', '392.84');
INSERT INTO `power_realtime` VALUES ('101', '1', '1641292800', '2746.00', '931.70', '885.23', '929.07', '930.53', '324.28', '300.17', '306.08', '0.9669', '0.9901', '0.9510', '0.9318', '2987.62', '2982.56', '2979.93', '198.07', '225.50', '227.75', '223.69', '394.23', '391.91', '396.53');
INSERT INTO `power_realtime` VALUES ('102', '1', '1641293100', '2223.47', '764.12', '705.84', '753.51', '725.30', '241.86', '222.44', '261.00', '0.9270', '0.9544', '0.9634', '0.9069', '2966.55', '2985.13', '2971.70', '199.59', '221.32', '221.02', '227.47', '394.73', '398.64', '389.08');
INSERT INTO `power_realtime` VALUES ('103', '1', '1641293400', '2330.46', '785.96', '756.25', '788.25', '619.50', '221.31', '194.76', '203.43', '0.9745', '0.9584', '0.9103', '0.9601', '2990.91', '2999.36', '2983.91', '198.56', '223.91', '223.79', '226.39', '392.90', '389.77', '393.02');
INSERT INTO `power_realtime` VALUES ('104', '1', '1641293700', '2286.79', '777.40', '728.16', '781.24', '667.98', '223.67', '212.89', '231.42', '0.9912', '0.9947', '0.9422', '0.9221', '2960.72', '2953.91', '2998.25', '198.65', '228.37', '222.31', '228.45', '395.95', '397.84', '389.01');
INSERT INTO `power_realtime` VALUES ('105', '1', '1641294000', '2915.44', '1010.68', '955.43', '949.33', '564.76', '205.83', '172.68', '186.26', '0.9508', '0.9879', '0.9291', '0.9432', '2992.91', '2961.52', '2987.24', '196.84', '225.76', '220.08', '222.95', '393.25', '390.03', '393.46');
INSERT INTO `power_realtime` VALUES ('106', '1', '1641294300', '2350.54', '819.34', '778.59', '752.61', '691.97', '237.28', '230.41', '224.27', '0.9727', '0.9190', '0.9274', '0.9566', '2997.90', '2954.68', '2965.13', '198.36', '226.44', '226.46', '222.13', '382.60', '381.78', '385.65');
INSERT INTO `power_realtime` VALUES ('107', '1', '1641294600', '1910.55', '660.74', '594.51', '655.29', '696.98', '236.88', '229.93', '230.17', '0.9618', '0.9059', '0.9011', '0.9210', '2950.90', '2957.63', '2991.76', '199.74', '221.38', '225.36', '222.21', '397.63', '382.71', '382.84');
INSERT INTO `power_realtime` VALUES ('108', '1', '1641294900', '2286.74', '775.36', '750.06', '761.33', '695.70', '234.02', '214.00', '247.69', '0.9634', '0.9660', '0.9579', '0.9736', '2998.23', '2966.70', '2980.54', '197.59', '220.96', '227.74', '221.49', '384.30', '390.45', '388.94');
INSERT INTO `power_realtime` VALUES ('109', '1', '1641295200', '1768.79', '596.14', '583.84', '588.81', '531.82', '182.89', '173.56', '175.36', '0.9306', '0.9219', '0.9946', '0.9656', '2982.95', '2965.13', '2973.68', '196.79', '229.38', '224.12', '224.18', '381.24', '393.64', '386.69');
INSERT INTO `power_realtime` VALUES ('110', '1', '1641295500', '2910.74', '997.82', '924.14', '988.78', '933.02', '316.64', '298.11', '318.27', '0.9750', '0.9223', '0.9501', '0.9281', '2985.34', '2958.24', '2952.44', '196.83', '222.67', '224.50', '226.07', '392.78', '393.91', '384.32');
INSERT INTO `power_realtime` VALUES ('111', '1', '1641295800', '2330.78', '797.57', '762.22', '770.99', '893.61', '300.58', '292.24', '300.79', '0.9543', '0.9522', '0.9172', '0.9266', '2952.34', '2978.58', '2996.17', '197.96', '228.72', '222.92', '220.54', '384.22', '386.47', '385.73');
INSERT INTO `power_realtime` VALUES ('112', '1', '1641296100', '1738.27', '626.61', '539.43', '572.24', '679.98', '237.07', '225.69', '217.22', '0.9469', '0.9864', '0.9849', '0.9062', '2985.64', '2979.58', '2992.90', '197.93', '229.49', '221.63', '222.91', '396.36', '390.76', '387.69');
INSERT INTO `power_realtime` VALUES ('113', '1', '1641296400', '2791.03', '936.42', '913.72', '940.90', '500.42', '181.90', '158.57', '159.94', '0.9656', '0.9128', '0.9575', '0.9092', '2970.97', '2959.37', '2984.70', '197.12', '227.87', '226.45', '225.31', '391.13', '396.36', '399.78');
INSERT INTO `power_realtime` VALUES ('114', '1', '1641296700', '2504.03', '882.61', '805.76', '815.66', '603.83', '220.42', '197.98', '185.43', '0.9727', '0.9999', '0.9332', '0.9588', '2961.10', '2984.86', '2954.40', '199.45', '225.17', '229.92', '225.76', '381.26', '385.08', '390.95');
INSERT INTO `power_realtime` VALUES ('115', '1', '1641297000', '2159.08', '745.73', '717.58', '695.77', '873.30', '300.64', '275.99', '296.67', '0.9851', '0.9223', '0.9205', '0.9510', '2972.50', '2968.51', '2975.12', '197.50', '229.70', '221.89', '221.10', '385.36', '387.43', '392.15');
INSERT INTO `power_realtime` VALUES ('116', '1', '1641297300', '2002.43', '699.69', '667.12', '635.61', '859.61', '303.81', '285.86', '269.94', '0.9839', '0.9781', '0.9241', '0.9798', '2969.72', '2988.07', '2951.62', '197.06', '221.89', '229.30', '226.66', '384.87', '391.22', '386.99');
INSERT INTO `power_realtime` VALUES ('117', '1', '1641297600', '2463.68', '826.33', '790.27', '847.08', '657.76', '223.87', '206.42', '227.47', '0.9884', '0.9369', '0.9481', '0.9336', '2993.26', '2981.46', '2982.00', '198.22', '228.08', '227.07', '223.87', '381.31', '381.13', '381.21');
INSERT INTO `power_realtime` VALUES ('118', '1', '1641297900', '2186.02', '747.99', '728.06', '709.97', '564.63', '205.06', '183.74', '175.83', '0.9001', '0.9480', '0.9348', '0.9557', '2985.71', '2995.84', '2960.01', '197.27', '221.78', '220.33', '221.49', '381.27', '391.27', '398.22');
INSERT INTO `power_realtime` VALUES ('119', '1', '1641298200', '2823.01', '959.88', '940.64', '922.49', '570.21', '193.33', '184.91', '191.96', '0.9855', '0.9118', '0.9927', '0.9444', '2986.43', '2971.54', '2972.12', '199.71', '229.82', '225.90', '226.72', '392.10', '397.68', '380.59');
INSERT INTO `power_realtime` VALUES ('120', '1', '1641298500', '2832.04', '988.96', '921.16', '921.92', '926.36', '316.37', '297.25', '312.73', '0.9312', '0.9757', '0.9576', '0.9869', '2998.60', '2997.47', '2969.80', '198.97', '229.49', '226.06', '228.90', '394.26', '384.68', '387.48');
INSERT INTO `power_realtime` VALUES ('121', '1', '1641298800', '2879.08', '987.96', '922.34', '968.78', '807.30', '281.88', '257.39', '268.03', '0.9861', '0.9591', '0.9839', '0.9774', '2982.75', '2985.93', '2965.53', '198.85', '222.89', '221.56', '220.52', '385.42', '387.54', '384.38');
INSERT INTO `power_realtime` VALUES ('122', '1', '1641299100', '2462.80', '840.14', '805.83', '816.84', '924.03', '324.76', '292.73', '306.55', '0.9920', '0.9401', '0.9716', '0.9572', '2998.09', '2979.79', '2961.70', '199.44', '225.77', '223.77', '229.05', '388.06', '384.70', '385.46');
INSERT INTO `power_realtime` VALUES ('123', '1', '1641299400', '2969.18', '1003.84', '979.46', '985.89', '881.20', '309.98', '287.89', '283.33', '0.9981', '0.9458', '0.9071', '0.9346', '2998.20', '2975.79', '2974.31', '199.93', '229.64', '225.91', '226.81', '395.44', '385.20', '388.93');
INSERT INTO `power_realtime` VALUES ('124', '1', '1641299700', '2580.31', '865.03', '850.59', '864.69', '569.41', '194.31', '179.43', '195.67', '0.9662', '0.9868', '0.9248', '0.9038', '2989.06', '2972.28', '2958.01', '197.66', '229.26', '223.45', '226.49', '381.00', '391.24', '383.47');
INSERT INTO `power_realtime` VALUES ('125', '1', '1641300000', '2282.58', '791.21', '744.36', '747.01', '968.39', '327.54', '311.20', '329.65', '0.9834', '0.9547', '0.9838', '0.9695', '2976.78', '2979.55', '2976.36', '197.28', '220.87', '220.74', '226.07', '393.31', '392.27', '397.67');
INSERT INTO `power_realtime` VALUES ('126', '1', '1641300300', '1650.83', '591.08', '514.28', '545.47', '897.03', '305.49', '285.95', '305.59', '0.9281', '0.9680', '0.9055', '0.9116', '2968.57', '2965.16', '2990.27', '199.85', '221.37', '227.62', '228.76', '382.38', '384.73', '395.74');
INSERT INTO `power_realtime` VALUES ('127', '1', '1641300600', '2625.50', '881.50', '859.02', '884.98', '985.25', '332.73', '324.04', '328.48', '0.9676', '0.9994', '0.9222', '0.9840', '2993.98', '2995.81', '2959.09', '197.44', '224.54', '224.13', '221.56', '394.18', '392.03', '390.55');
INSERT INTO `power_realtime` VALUES ('128', '1', '1641300900', '1649.69', '596.10', '503.38', '550.21', '959.39', '339.72', '315.18', '304.50', '0.9088', '0.9516', '0.9569', '0.9354', '2984.08', '2980.69', '2962.29', '198.40', '226.43', '224.43', '220.06', '387.69', '380.66', '390.00');
INSERT INTO `power_realtime` VALUES ('129', '1', '1641301200', '1792.30', '638.91', '553.45', '599.94', '727.94', '259.53', '237.52', '230.89', '0.9784', '0.9670', '0.9785', '0.9695', '2984.07', '2970.06', '2955.78', '198.14', '229.97', '222.71', '226.82', '393.26', '392.58', '394.33');
INSERT INTO `power_realtime` VALUES ('130', '1', '1641301500', '2352.19', '791.13', '745.75', '815.31', '727.44', '257.91', '232.40', '237.13', '0.9685', '0.9576', '0.9645', '0.9249', '2979.90', '2965.52', '2974.63', '197.51', '227.12', '223.59', '226.43', '382.60', '399.29', '380.52');
INSERT INTO `power_realtime` VALUES ('131', '1', '1641301800', '2916.11', '1019.96', '927.82', '968.34', '539.82', '199.25', '177.04', '163.52', '0.9592', '0.9305', '0.9465', '0.9531', '2991.67', '2956.43', '2984.23', '197.18', '226.16', '227.97', '222.19', '398.90', '390.57', '385.55');
INSERT INTO `power_realtime` VALUES ('132', '1', '1641302100', '2430.90', '815.17', '783.17', '832.55', '921.74', '307.85', '297.79', '316.10', '0.9073', '0.9522', '0.9208', '0.9032', '2975.98', '2959.28', '2964.40', '198.37', '222.25', '222.05', '226.82', '380.71', '380.29', '392.45');
INSERT INTO `power_realtime` VALUES ('133', '1', '1641302400', '2046.74', '691.61', '646.72', '708.41', '594.01', '207.67', '192.59', '193.74', '0.9818', '0.9528', '0.9672', '0.9908', '2985.87', '2953.88', '2985.37', '196.73', '220.33', '222.44', '223.32', '385.23', '382.83', '392.32');
INSERT INTO `power_realtime` VALUES ('134', '1', '1641302700', '2795.00', '944.65', '897.82', '952.54', '924.77', '315.71', '304.36', '304.70', '0.9291', '0.9096', '0.9464', '0.9269', '2961.14', '2982.34', '2951.39', '198.81', '221.91', '223.98', '221.62', '395.53', '386.81', '381.59');
INSERT INTO `power_realtime` VALUES ('135', '1', '1641303000', '2079.10', '729.74', '667.15', '682.22', '504.17', '182.91', '165.55', '155.70', '0.9558', '0.9754', '0.9247', '0.9190', '2962.27', '2952.98', '2996.69', '197.83', '220.18', '228.96', '222.02', '382.14', '387.82', '396.73');
INSERT INTO `power_realtime` VALUES ('136', '1', '1641303300', '1982.28', '708.16', '650.07', '624.04', '549.61', '183.29', '179.40', '186.92', '0.9404', '0.9217', '0.9215', '0.9265', '2969.84', '2972.76', '2969.46', '198.55', '222.10', '227.00', '227.91', '381.70', '398.60', '388.45');
INSERT INTO `power_realtime` VALUES ('137', '1', '1641303600', '2530.07', '857.04', '833.80', '839.22', '601.33', '219.25', '188.33', '193.75', '0.9083', '0.9644', '0.9712', '0.9536', '2996.25', '2967.59', '2983.08', '198.94', '220.95', '223.77', '227.54', '395.42', '394.07', '394.08');
INSERT INTO `power_realtime` VALUES ('138', '1', '1641303900', '2289.12', '784.27', '717.93', '786.92', '565.60', '192.89', '177.09', '195.61', '0.9471', '0.9143', '0.9578', '0.9054', '2999.48', '2990.49', '2999.21', '196.83', '228.86', '224.19', '227.99', '395.90', '388.83', '380.58');
INSERT INTO `power_realtime` VALUES ('139', '1', '1641304200', '2036.89', '717.17', '638.08', '681.64', '839.62', '295.15', '276.17', '268.29', '0.9813', '0.9553', '0.9961', '0.9010', '2997.89', '2962.84', '2984.84', '198.24', '225.78', '221.63', '223.48', '384.69', '387.78', '380.63');
INSERT INTO `power_realtime` VALUES ('140', '1', '1641304500', '2199.31', '747.95', '690.29', '761.07', '506.16', '174.92', '153.65', '177.59', '0.9841', '0.9025', '0.9142', '0.9474', '2962.48', '2993.87', '2955.79', '198.32', '228.90', '228.81', '225.52', '382.55', '394.21', '392.31');
INSERT INTO `power_realtime` VALUES ('141', '1', '1641304800', '2825.15', '969.17', '899.54', '956.44', '918.85', '320.80', '287.55', '310.49', '0.9704', '0.9195', '0.9336', '0.9186', '2956.64', '2978.34', '2980.50', '198.65', '225.53', '228.86', '223.46', '381.90', '386.62', '396.23');
INSERT INTO `power_realtime` VALUES ('142', '1', '1641305100', '2046.99', '718.48', '679.39', '649.12', '909.35', '313.18', '286.10', '310.06', '0.9871', '0.9912', '0.9365', '0.9590', '2955.03', '2981.31', '2972.96', '199.23', '221.96', '226.35', '220.81', '384.50', '382.99', '385.72');
INSERT INTO `power_realtime` VALUES ('143', '1', '1641305400', '2269.39', '773.95', '741.12', '754.31', '836.80', '296.72', '265.84', '274.24', '0.9028', '0.9457', '0.9732', '0.9402', '2951.49', '2983.42', '2999.34', '196.96', '221.53', '227.30', '225.94', '388.15', '381.81', '383.37');
INSERT INTO `power_realtime` VALUES ('144', '1', '1641305700', '2224.40', '749.28', '729.78', '745.34', '766.36', '269.84', '252.60', '243.92', '0.9943', '0.9048', '0.9747', '0.9486', '2961.79', '2978.41', '2962.15', '197.87', '226.71', '225.71', '224.54', '394.17', '380.47', '391.85');
INSERT INTO `power_realtime` VALUES ('145', '1', '1641306000', '2044.33', '681.97', '641.89', '720.48', '709.13', '255.43', '225.17', '228.54', '0.9263', '0.9071', '0.9158', '0.9522', '2989.47', '2988.09', '2956.05', '197.47', '222.28', '220.16', '225.98', '381.50', '385.76', '399.13');
INSERT INTO `power_realtime` VALUES ('146', '1', '1641306300', '2119.88', '737.60', '663.90', '718.38', '578.55', '198.33', '188.79', '191.43', '0.9367', '0.9031', '0.9075', '0.9176', '2953.48', '2988.26', '2962.74', '199.77', '220.45', '229.23', '226.58', '395.01', '386.66', '386.22');
INSERT INTO `power_realtime` VALUES ('147', '1', '1641306600', '2739.91', '918.80', '863.62', '957.49', '819.80', '291.09', '266.79', '261.92', '0.9602', '0.9579', '0.9932', '0.9873', '2973.29', '2971.47', '2967.53', '196.79', '222.84', '227.88', '229.57', '383.59', '397.09', '391.48');
INSERT INTO `power_realtime` VALUES ('148', '1', '1641306900', '2346.86', '819.54', '766.85', '760.47', '548.19', '199.37', '171.41', '177.41', '0.9537', '0.9144', '0.9788', '0.9152', '2971.53', '2960.29', '2987.25', '196.79', '229.64', '228.32', '223.96', '398.92', '395.62', '387.58');
INSERT INTO `power_realtime` VALUES ('149', '1', '1641307200', '1687.95', '602.77', '560.01', '525.17', '989.81', '342.35', '321.94', '325.52', '0.9284', '0.9815', '0.9403', '0.9721', '2986.05', '2976.71', '2999.28', '198.49', '222.69', '229.76', '223.31', '387.76', '390.46', '386.46');
INSERT INTO `power_realtime` VALUES ('150', '1', '1641307500', '2699.14', '903.20', '875.40', '920.54', '553.53', '188.58', '183.73', '181.22', '0.9435', '0.9956', '0.9239', '0.9827', '2981.77', '2970.25', '2952.63', '198.51', '226.04', '229.38', '229.88', '399.50', '381.14', '383.86');
INSERT INTO `power_realtime` VALUES ('151', '1', '1641307800', '1623.78', '566.33', '539.80', '517.65', '977.32', '333.42', '307.57', '336.33', '0.9738', '0.9822', '0.9900', '0.9439', '2968.78', '2958.72', '2976.35', '199.07', '225.92', '224.63', '229.96', '386.38', '393.08', '387.67');
INSERT INTO `power_realtime` VALUES ('152', '1', '1641308100', '2143.20', '730.55', '698.64', '714.00', '683.36', '243.98', '227.24', '212.14', '0.9351', '0.9998', '0.9416', '0.9894', '2966.49', '2991.85', '2976.49', '197.08', '221.08', '221.93', '222.81', '396.65', '388.44', '384.39');
INSERT INTO `power_realtime` VALUES ('153', '1', '1641308400', '2180.56', '740.33', '717.56', '722.66', '746.89', '265.21', '237.71', '243.97', '0.9271', '0.9932', '0.9298', '0.9238', '2953.61', '2959.01', '2981.25', '199.16', '224.46', '221.28', '227.73', '390.17', '385.11', '384.64');
INSERT INTO `power_realtime` VALUES ('154', '1', '1641308700', '1532.93', '545.86', '510.51', '476.56', '731.62', '262.01', '234.27', '235.34', '0.9412', '0.9098', '0.9407', '0.9344', '2961.57', '2977.58', '2954.26', '198.88', '227.81', '228.38', '222.30', '382.57', '386.32', '392.20');
INSERT INTO `power_realtime` VALUES ('155', '1', '1641309000', '2089.67', '697.98', '648.54', '743.15', '570.76', '208.30', '183.35', '179.11', '0.9786', '0.9437', '0.9382', '0.9115', '2953.54', '2968.95', '2998.90', '199.63', '223.28', '226.87', '228.76', '387.23', '396.07', '381.45');
INSERT INTO `power_realtime` VALUES ('156', '1', '1641309300', '2607.55', '886.12', '866.60', '854.83', '677.40', '243.69', '219.22', '214.49', '0.9288', '0.9694', '0.9645', '0.9683', '2983.20', '2954.17', '2971.18', '198.98', '228.16', '222.56', '225.89', '394.48', '389.55', '385.64');
INSERT INTO `power_realtime` VALUES ('157', '1', '1641309600', '2834.90', '992.48', '906.18', '936.23', '550.12', '189.36', '163.81', '196.95', '0.9747', '0.9064', '0.9932', '0.9385', '2996.50', '2980.57', '2955.94', '198.19', '223.30', '229.16', '229.74', '384.50', '384.33', '392.21');
INSERT INTO `power_realtime` VALUES ('158', '1', '1641309900', '1707.98', '596.40', '560.31', '551.27', '800.69', '272.72', '256.47', '271.50', '0.9166', '0.9207', '0.9739', '0.9577', '2975.84', '2975.42', '2990.25', '196.88', '229.98', '221.39', '228.54', '394.24', '395.98', '393.04');
INSERT INTO `power_realtime` VALUES ('159', '1', '1641310200', '1883.73', '660.20', '623.83', '599.70', '769.22', '269.78', '248.88', '250.56', '0.9381', '0.9197', '0.9181', '0.9954', '2979.63', '2961.42', '2989.47', '197.90', '225.74', '225.64', '225.09', '389.39', '381.77', '384.75');
INSERT INTO `power_realtime` VALUES ('160', '1', '1641310500', '2522.44', '860.58', '795.93', '865.93', '709.28', '240.70', '236.00', '232.58', '0.9861', '0.9283', '0.9422', '0.9962', '2950.96', '2962.56', '2994.86', '197.93', '226.43', '221.73', '224.00', '390.21', '398.10', '399.63');
INSERT INTO `power_realtime` VALUES ('161', '1', '1641310800', '2993.62', '998.48', '984.16', '1010.98', '920.20', '307.88', '294.91', '317.41', '0.9844', '0.9542', '0.9081', '0.9207', '2956.61', '2977.46', '2967.66', '198.12', '228.90', '220.46', '220.61', '384.35', '380.83', '389.13');
INSERT INTO `power_realtime` VALUES ('162', '1', '1641311100', '2046.71', '725.40', '668.61', '652.69', '677.27', '234.49', '218.01', '224.77', '0.9665', '0.9500', '0.9920', '0.9371', '2973.18', '2950.06', '2952.35', '197.05', '227.36', '221.90', '224.64', '391.41', '383.54', '380.46');
INSERT INTO `power_realtime` VALUES ('163', '1', '1641311400', '2466.38', '864.71', '802.90', '798.78', '861.54', '296.85', '267.44', '297.25', '0.9839', '0.9696', '0.9528', '0.9146', '2958.75', '2975.61', '2972.14', '197.58', '225.95', '227.33', '223.00', '382.01', '395.91', '382.38');
INSERT INTO `power_realtime` VALUES ('164', '1', '1641311700', '1819.66', '633.19', '603.89', '582.58', '820.45', '280.85', '257.71', '281.89', '0.9278', '0.9842', '0.9778', '0.9988', '2988.35', '2992.13', '2952.09', '197.64', '229.96', '224.90', '223.93', '399.42', '394.17', '388.56');
INSERT INTO `power_realtime` VALUES ('165', '1', '1641312000', '2098.72', '730.98', '665.33', '702.41', '698.04', '236.55', '220.10', '241.40', '0.9902', '0.9805', '0.9489', '0.9180', '2987.93', '2974.83', '2989.65', '198.64', '229.79', '224.08', '228.33', '383.82', '386.34', '395.98');
INSERT INTO `power_realtime` VALUES ('166', '1', '1641312300', '2369.52', '816.26', '771.64', '781.62', '759.07', '263.42', '241.46', '254.19', '0.9951', '0.9032', '0.9931', '0.9694', '2975.21', '2972.59', '2959.48', '197.23', '223.69', '227.67', '223.41', '398.07', '388.47', '382.13');
INSERT INTO `power_realtime` VALUES ('167', '1', '1641312600', '2451.90', '865.89', '787.11', '798.90', '595.20', '204.47', '195.81', '194.92', '0.9348', '0.9270', '0.9662', '0.9679', '2956.94', '2952.40', '2997.99', '197.19', '228.48', '222.27', '229.66', '399.67', '382.95', '387.51');
INSERT INTO `power_realtime` VALUES ('168', '1', '1641312900', '2181.53', '743.44', '702.15', '735.94', '543.31', '187.28', '165.50', '190.54', '0.9673', '0.9535', '0.9581', '0.9117', '2990.16', '2998.53', '2964.43', '197.70', '221.54', '228.66', '223.04', '396.26', '386.62', '389.83');
INSERT INTO `power_realtime` VALUES ('169', '1', '1641313200', '2438.72', '852.66', '783.11', '802.95', '665.90', '237.59', '213.34', '214.97', '0.9606', '0.9195', '0.9128', '0.9209', '2990.31', '2999.36', '2968.58', '199.01', '222.35', '222.45', '221.97', '381.44', '395.48', '393.10');
INSERT INTO `power_realtime` VALUES ('170', '1', '1641313500', '1872.38', '646.52', '594.22', '631.64', '741.90', '252.62', '245.12', '244.17', '0.9017', '0.9815', '0.9147', '0.9447', '2961.82', '2995.36', '2990.54', '196.85', '227.63', '222.87', '221.96', '394.14', '393.14', '388.16');
INSERT INTO `power_realtime` VALUES ('171', '1', '1641313800', '1600.69', '540.41', '490.46', '569.81', '892.26', '316.78', '291.87', '283.61', '0.9419', '0.9031', '0.9129', '0.9053', '2986.18', '2956.59', '2995.78', '198.84', '221.36', '223.32', '229.63', '398.10', '392.75', '391.97');
INSERT INTO `power_realtime` VALUES ('172', '1', '1641314100', '2632.24', '892.27', '868.00', '871.97', '719.19', '259.58', '232.09', '227.51', '0.9002', '0.9165', '0.9364', '0.9522', '2979.77', '2958.73', '2968.81', '197.19', '228.29', '221.62', '223.49', '397.85', '386.47', '399.86');
INSERT INTO `power_realtime` VALUES ('173', '1', '1641314400', '1823.57', '612.51', '604.80', '606.26', '670.55', '225.69', '216.59', '228.26', '0.9146', '0.9614', '0.9912', '0.9436', '2977.42', '2980.62', '2950.22', '197.76', '228.71', '220.70', '229.46', '395.14', '382.84', '389.68');
INSERT INTO `power_realtime` VALUES ('174', '1', '1641314700', '1869.57', '652.69', '577.35', '639.53', '751.16', '259.14', '241.64', '250.39', '0.9078', '0.9185', '0.9282', '0.9462', '2959.37', '2955.93', '2966.96', '197.27', '221.60', '221.44', '226.38', '383.02', '380.28', '397.34');
INSERT INTO `power_realtime` VALUES ('175', '1', '1641315000', '2614.31', '893.95', '850.83', '869.54', '692.15', '242.48', '224.84', '224.83', '0.9134', '0.9536', '0.9294', '0.9559', '2967.43', '2975.72', '2991.28', '196.92', '224.24', '229.31', '229.84', '396.05', '395.38', '381.55');
INSERT INTO `power_realtime` VALUES ('176', '1', '1641315300', '2869.57', '964.18', '909.56', '995.83', '755.72', '258.53', '233.37', '263.82', '0.9078', '0.9729', '0.9755', '0.9840', '2951.90', '2957.03', '2953.14', '199.60', '227.48', '224.00', '221.17', '382.42', '395.95', '390.21');
INSERT INTO `power_realtime` VALUES ('177', '1', '1641315600', '2437.32', '856.72', '771.04', '809.56', '998.28', '349.45', '328.85', '319.98', '0.9910', '0.9566', '0.9377', '0.9359', '2953.82', '2966.19', '2961.10', '198.21', '228.79', '228.29', '223.66', '398.54', '382.97', '392.69');
INSERT INTO `power_realtime` VALUES ('178', '1', '1641315900', '1651.69', '553.38', '512.22', '586.09', '537.66', '196.46', '167.52', '173.68', '0.9759', '0.9909', '0.9671', '0.9179', '2956.85', '2963.75', '2960.19', '199.01', '228.37', '226.72', '228.61', '387.76', '380.98', '390.73');
INSERT INTO `power_realtime` VALUES ('179', '1', '1641316200', '2483.28', '870.02', '778.93', '834.34', '671.54', '225.78', '221.54', '224.22', '0.9652', '0.9560', '0.9567', '0.9609', '2990.51', '2970.42', '2970.06', '198.25', '227.96', '228.59', '220.64', '393.37', '393.93', '386.19');
INSERT INTO `power_realtime` VALUES ('180', '1', '1641316500', '1586.70', '545.19', '499.93', '541.58', '573.70', '209.61', '174.20', '189.89', '0.9269', '0.9459', '0.9993', '0.9257', '2980.86', '2991.05', '2954.27', '197.03', '227.60', '220.94', '224.19', '391.09', '382.91', '386.27');
INSERT INTO `power_realtime` VALUES ('181', '1', '1641316800', '2118.46', '729.30', '685.43', '703.73', '752.03', '261.74', '234.60', '255.68', '0.9192', '0.9055', '0.9832', '0.9757', '2976.30', '2975.80', '2971.26', '197.94', '221.33', '228.07', '221.97', '388.30', '383.48', '385.84');
INSERT INTO `power_realtime` VALUES ('182', '1', '1641317100', '1708.97', '605.91', '555.77', '547.29', '987.98', '339.12', '310.33', '338.53', '0.9670', '0.9549', '0.9393', '0.9510', '2974.89', '2994.39', '2998.89', '197.68', '220.42', '222.19', '220.41', '385.93', '383.22', '382.79');
INSERT INTO `power_realtime` VALUES ('183', '1', '1641317400', '2637.53', '886.05', '869.91', '881.58', '591.05', '206.15', '181.99', '202.92', '0.9505', '0.9507', '0.9848', '0.9635', '2995.61', '2950.92', '2958.89', '198.88', '220.77', '227.43', '227.62', '395.19', '385.36', '395.08');
INSERT INTO `power_realtime` VALUES ('184', '1', '1641317700', '2534.40', '861.82', '805.24', '867.33', '993.41', '332.06', '315.33', '346.02', '0.9341', '0.9870', '0.9027', '0.9524', '2969.20', '2972.93', '2993.23', '198.98', '229.81', '224.53', '226.12', '383.33', '390.99', '398.22');
INSERT INTO `power_realtime` VALUES ('185', '1', '1641318000', '1818.06', '637.26', '579.43', '601.37', '980.26', '332.24', '324.86', '323.15', '0.9441', '0.9865', '0.9470', '0.9927', '2974.34', '2969.17', '2963.02', '197.39', '228.86', '227.84', '224.29', '392.68', '381.17', '388.35');
INSERT INTO `power_realtime` VALUES ('186', '1', '1641318300', '1569.69', '571.31', '502.53', '495.85', '699.26', '252.88', '226.90', '219.49', '0.9896', '0.9559', '0.9735', '0.9385', '2962.79', '2966.36', '2950.91', '196.81', '227.11', '228.48', '229.49', '393.20', '390.92', '399.84');
INSERT INTO `power_realtime` VALUES ('187', '1', '1641318600', '2649.63', '921.50', '852.70', '875.43', '518.99', '173.62', '170.92', '174.45', '0.9165', '0.9931', '0.9681', '0.9035', '2951.49', '2955.12', '2950.70', '199.01', '225.93', '228.42', '229.42', '392.38', '399.39', '386.70');
INSERT INTO `power_realtime` VALUES ('188', '1', '1641318900', '2073.32', '715.82', '681.73', '675.78', '810.37', '280.18', '267.90', '262.29', '0.9955', '0.9295', '0.9720', '0.9407', '2961.77', '2950.65', '2972.77', '197.28', '224.53', '229.52', '228.80', '396.07', '395.13', '394.53');
INSERT INTO `power_realtime` VALUES ('189', '1', '1641319200', '2985.63', '1005.51', '977.37', '1002.75', '807.97', '275.50', '264.25', '268.21', '0.9533', '0.9707', '0.9943', '0.9724', '2954.74', '2952.89', '2980.87', '199.15', '221.85', '229.34', '224.28', '391.29', '391.24', '383.74');
INSERT INTO `power_realtime` VALUES ('190', '1', '1641319500', '2003.95', '712.63', '638.07', '653.25', '868.41', '297.04', '279.14', '292.22', '0.9879', '0.9637', '0.9491', '0.9481', '2998.42', '2975.63', '2955.19', '199.36', '224.54', '221.60', '222.81', '385.51', '383.63', '395.99');
INSERT INTO `power_realtime` VALUES ('191', '1', '1641319800', '2240.81', '783.23', '702.03', '755.55', '681.98', '239.60', '225.36', '217.01', '0.9396', '0.9680', '0.9624', '0.9686', '2955.33', '2952.88', '2998.07', '197.90', '226.00', '223.82', '226.35', '388.06', '385.51', '383.80');
INSERT INTO `power_realtime` VALUES ('192', '1', '1641320100', '2466.64', '839.89', '816.66', '810.09', '810.52', '283.42', '262.27', '264.83', '0.9323', '0.9423', '0.9623', '0.9074', '2950.26', '2974.41', '2962.24', '198.69', '228.36', '227.78', '229.82', '396.52', '392.80', '387.82');
INSERT INTO `power_realtime` VALUES ('193', '1', '1641320400', '1632.66', '546.34', '536.71', '549.61', '819.56', '274.50', '264.04', '281.02', '0.9561', '0.9737', '0.9905', '0.9913', '2965.52', '2950.99', '2987.32', '199.61', '226.72', '229.71', '229.19', '395.98', '399.46', '388.47');
INSERT INTO `power_realtime` VALUES ('194', '1', '1641320700', '1842.59', '651.77', '598.79', '592.03', '745.81', '252.40', '240.92', '252.49', '0.9213', '0.9820', '0.9608', '0.9635', '2966.08', '2962.72', '2978.34', '199.51', '223.29', '227.33', '222.05', '389.98', '386.69', '396.49');
INSERT INTO `power_realtime` VALUES ('195', '1', '1641321000', '1839.60', '622.94', '588.12', '628.54', '692.60', '243.21', '218.18', '231.21', '0.9873', '0.9166', '0.9343', '0.9511', '2979.26', '2951.77', '2950.27', '196.90', '228.47', '228.91', '225.00', '380.36', '397.91', '383.23');
INSERT INTO `power_realtime` VALUES ('196', '1', '1641321300', '2162.82', '749.29', '688.30', '725.23', '974.95', '332.02', '317.84', '325.09', '0.9505', '0.9328', '0.9861', '0.9910', '2993.10', '2983.17', '2994.72', '197.14', '226.34', '226.45', '229.68', '398.61', '380.64', '383.16');
INSERT INTO `power_realtime` VALUES ('197', '1', '1641321600', '2324.00', '818.64', '738.47', '766.89', '943.66', '319.75', '301.17', '322.74', '0.9670', '0.9943', '0.9017', '0.9335', '2993.86', '2964.55', '2999.89', '198.03', '223.02', '220.42', '222.95', '382.95', '387.51', '390.54');
INSERT INTO `power_realtime` VALUES ('198', '1', '1641321900', '2161.39', '759.62', '713.17', '688.60', '903.47', '314.53', '295.86', '293.08', '0.9828', '0.9829', '0.9663', '0.9444', '2987.26', '2987.40', '2971.13', '199.77', '228.83', '226.90', '226.11', '394.45', '381.90', '398.42');
INSERT INTO `power_realtime` VALUES ('199', '1', '1641322200', '2443.29', '831.76', '789.12', '822.41', '903.96', '319.80', '284.26', '299.91', '0.9582', '0.9248', '0.9904', '0.9608', '2988.65', '2979.14', '2958.88', '199.07', '228.08', '220.22', '223.67', '391.35', '388.58', '390.82');
INSERT INTO `power_realtime` VALUES ('200', '1', '1641322500', '2818.72', '964.34', '919.73', '934.65', '623.95', '208.12', '193.93', '221.90', '0.9867', '0.9497', '0.9587', '0.9268', '2975.85', '2986.28', '2951.50', '196.95', '224.36', '224.80', '223.56', '393.20', '386.75', '398.78');
INSERT INTO `power_realtime` VALUES ('201', '1', '1641322800', '1846.86', '651.66', '602.87', '592.32', '589.94', '197.24', '196.62', '196.09', '0.9402', '0.9911', '0.9921', '0.9369', '2973.34', '2995.01', '2984.09', '197.95', '224.50', '228.68', '227.74', '385.94', '381.26', '388.02');
INSERT INTO `power_realtime` VALUES ('202', '1', '1641323100', '2080.51', '704.65', '649.54', '726.32', '567.61', '199.48', '172.81', '195.32', '0.9091', '0.9150', '0.9693', '0.9542', '2979.38', '2986.00', '2999.66', '198.38', '229.81', '228.79', '225.92', '385.73', '388.87', '398.99');
INSERT INTO `power_realtime` VALUES ('203', '1', '1641323400', '2532.12', '887.08', '841.20', '803.84', '641.21', '231.66', '209.37', '200.18', '0.9508', '0.9245', '0.9795', '0.9435', '2956.97', '2965.57', '2976.96', '197.02', '220.54', '223.83', '223.78', '392.13', '398.41', '391.01');
INSERT INTO `power_realtime` VALUES ('204', '1', '1641323700', '2312.87', '778.80', '751.68', '782.39', '750.64', '262.51', '241.50', '246.62', '0.9187', '0.9354', '0.9546', '0.9657', '2987.00', '2965.27', '2958.87', '198.97', '226.93', '224.81', '222.74', '381.81', '388.47', '389.22');
INSERT INTO `power_realtime` VALUES ('205', '1', '1641324000', '1807.60', '608.51', '555.16', '643.93', '787.87', '271.92', '259.77', '256.18', '0.9080', '0.9452', '0.9674', '0.9214', '2975.31', '2956.51', '2977.52', '199.37', '229.31', '226.23', '228.90', '380.71', '392.16', '397.45');
INSERT INTO `power_realtime` VALUES ('206', '1', '1641324300', '1929.12', '684.86', '595.17', '649.09', '765.70', '268.09', '245.69', '251.91', '0.9297', '0.9374', '0.9846', '0.9067', '2967.38', '2986.41', '2976.47', '198.62', '229.01', '221.81', '226.29', '386.48', '386.80', '381.01');
INSERT INTO `power_realtime` VALUES ('207', '1', '1641324600', '1786.14', '626.40', '551.35', '608.40', '560.01', '187.60', '168.35', '204.06', '0.9079', '0.9564', '0.9157', '0.9554', '2952.41', '2954.73', '2976.76', '197.30', '222.87', '228.52', '222.08', '394.02', '396.29', '381.56');
INSERT INTO `power_realtime` VALUES ('208', '1', '1641324900', '2998.96', '1049.14', '959.32', '990.50', '793.95', '283.43', '262.71', '247.81', '0.9917', '0.9777', '0.9209', '0.9856', '2984.21', '2970.71', '2972.16', '197.74', '225.21', '220.45', '220.70', '384.17', '385.72', '380.91');
INSERT INTO `power_realtime` VALUES ('209', '1', '1641325200', '2906.29', '1014.25', '966.61', '925.43', '577.37', '193.35', '185.38', '198.64', '0.9716', '0.9607', '0.9150', '0.9473', '2959.42', '2951.96', '2969.97', '199.92', '224.16', '220.69', '228.28', '390.59', '381.62', '382.24');
INSERT INTO `power_realtime` VALUES ('210', '1', '1641325500', '2525.31', '868.17', '791.92', '865.21', '537.98', '189.39', '177.58', '171.01', '0.9070', '0.9274', '0.9393', '0.9806', '2973.35', '2955.60', '2966.36', '198.55', '222.17', '224.34', '229.94', '380.82', '386.83', '386.02');
INSERT INTO `power_realtime` VALUES ('211', '1', '1641325800', '1854.90', '623.42', '597.88', '633.60', '881.95', '311.35', '292.58', '278.02', '0.9909', '0.9449', '0.9726', '0.9436', '2971.11', '2964.49', '2960.96', '199.67', '225.18', '228.96', '228.84', '396.08', '396.33', '383.12');
INSERT INTO `power_realtime` VALUES ('212', '1', '1641326100', '2949.66', '1029.80', '937.89', '981.98', '601.13', '210.97', '191.29', '198.87', '0.9094', '0.9116', '0.9017', '0.9471', '2975.91', '2989.20', '2972.13', '198.25', '220.28', '220.67', '228.83', '389.35', '399.89', '390.13');
INSERT INTO `power_realtime` VALUES ('213', '1', '1641326400', '2638.94', '923.66', '845.80', '869.48', '901.54', '310.22', '289.93', '301.39', '0.9941', '0.9519', '0.9903', '0.9549', '2958.38', '2988.07', '2964.58', '196.79', '227.55', '224.32', '220.97', '383.27', '398.54', '390.91');
INSERT INTO `power_realtime` VALUES ('214', '1', '1641326700', '2821.21', '966.17', '903.28', '951.76', '963.42', '329.32', '315.86', '318.25', '0.9165', '0.9131', '0.9562', '0.9530', '2958.97', '2954.79', '2992.06', '199.21', '229.48', '224.85', '228.68', '398.52', '384.99', '384.68');
INSERT INTO `power_realtime` VALUES ('215', '1', '1641327000', '1929.75', '691.24', '593.61', '644.90', '756.98', '258.85', '246.83', '251.30', '0.9305', '0.9356', '0.9999', '0.9819', '2992.14', '2974.54', '2992.55', '199.56', '229.03', '223.81', '226.89', '398.67', '383.09', '393.66');
INSERT INTO `power_realtime` VALUES ('216', '1', '1641327300', '2440.56', '829.20', '782.39', '828.97', '829.68', '277.00', '274.05', '278.64', '0.9403', '0.9206', '0.9197', '0.9417', '2993.47', '2955.53', '2998.67', '197.01', '226.71', '221.11', '226.82', '380.60', '388.28', '393.40');
INSERT INTO `power_realtime` VALUES ('217', '1', '1641327600', '1677.48', '603.65', '554.93', '518.89', '751.20', '260.35', '233.96', '256.88', '0.9472', '0.9681', '0.9002', '0.9350', '2971.86', '2954.17', '2995.09', '197.72', '226.96', '225.26', '220.43', '388.73', '399.75', '395.29');
INSERT INTO `power_realtime` VALUES ('218', '1', '1641327900', '2663.35', '916.28', '837.83', '909.24', '750.10', '258.45', '231.61', '260.04', '0.9168', '0.9809', '0.9722', '0.9005', '2995.97', '2977.30', '2964.69', '199.97', '224.99', '228.55', '226.72', '387.95', '385.63', '394.64');
INSERT INTO `power_realtime` VALUES ('219', '1', '1641328200', '1869.04', '637.73', '586.77', '644.54', '502.68', '177.69', '148.72', '176.26', '0.9054', '0.9444', '0.9104', '0.9133', '2979.14', '2965.27', '2968.19', '198.78', '227.28', '223.86', '226.60', '393.19', '394.87', '397.95');
INSERT INTO `power_realtime` VALUES ('220', '1', '1641328500', '2424.44', '811.79', '786.17', '826.47', '538.71', '183.87', '166.59', '188.24', '0.9898', '0.9867', '0.9679', '0.9839', '2978.66', '2984.83', '2996.77', '199.39', '221.40', '229.56', '222.70', '383.85', '384.08', '380.38');
INSERT INTO `power_realtime` VALUES ('221', '1', '1641328800', '1677.48', '605.30', '526.55', '545.63', '811.48', '289.65', '263.66', '258.17', '0.9599', '0.9048', '0.9325', '0.9798', '2994.60', '2990.01', '2974.13', '199.31', '225.11', '226.19', '227.03', '388.34', '383.62', '398.68');
INSERT INTO `power_realtime` VALUES ('222', '1', '1641329100', '2418.25', '847.31', '804.24', '766.70', '640.09', '218.48', '203.45', '218.15', '0.9603', '0.9068', '0.9406', '0.9194', '2989.47', '2993.91', '2964.00', '199.02', '228.65', '225.30', '221.18', '387.69', '385.44', '395.88');
INSERT INTO `power_realtime` VALUES ('223', '1', '1641329400', '1625.87', '548.02', '524.54', '553.31', '970.58', '342.11', '304.21', '324.25', '0.9992', '0.9691', '0.9896', '0.9475', '2953.57', '2983.10', '2960.13', '199.44', '220.49', '225.00', '221.72', '398.07', '395.01', '381.85');
INSERT INTO `power_realtime` VALUES ('224', '1', '1641329700', '1745.69', '620.91', '533.48', '591.31', '719.79', '248.76', '230.12', '240.91', '0.9865', '0.9419', '0.9600', '0.9963', '2961.60', '2950.00', '2999.81', '198.02', '222.72', '220.00', '227.46', '389.89', '391.88', '399.04');
INSERT INTO `power_realtime` VALUES ('225', '1', '1641330000', '2763.66', '950.59', '905.26', '907.80', '860.36', '306.45', '278.54', '275.38', '0.9201', '0.9530', '0.9817', '0.9650', '2953.65', '2967.27', '2997.54', '197.74', '220.27', '225.48', '224.99', '385.16', '386.62', '383.86');
INSERT INTO `power_realtime` VALUES ('226', '1', '1641330300', '1713.28', '603.46', '522.60', '587.22', '878.76', '307.61', '285.55', '285.61', '0.9943', '0.9633', '0.9667', '0.9137', '2979.27', '2980.94', '2993.50', '197.61', '226.20', '223.73', '224.70', '386.73', '387.98', '393.33');
INSERT INTO `power_realtime` VALUES ('227', '1', '1641330600', '2228.74', '769.15', '704.39', '755.20', '789.40', '263.49', '259.05', '266.87', '0.9842', '0.9125', '0.9757', '0.9648', '2964.78', '2957.08', '2951.71', '199.42', '224.83', '221.27', '221.14', '390.89', '381.32', '381.58');
INSERT INTO `power_realtime` VALUES ('228', '1', '1641330900', '2845.05', '997.55', '910.89', '936.61', '517.27', '186.74', '162.50', '168.03', '0.9352', '0.9671', '0.9898', '0.9386', '2954.15', '2979.13', '2975.18', '197.34', '224.83', '220.54', '229.44', '380.22', '388.80', '383.38');
INSERT INTO `power_realtime` VALUES ('229', '1', '1641331200', '2943.02', '1008.74', '939.77', '994.50', '669.08', '231.46', '205.04', '232.58', '0.9793', '0.9343', '0.9218', '0.9131', '2979.86', '2960.09', '2979.76', '196.95', '225.52', '225.86', '222.68', '385.37', '393.00', '391.06');
INSERT INTO `power_realtime` VALUES ('230', '1', '1641331500', '2542.68', '851.63', '817.29', '873.76', '998.58', '338.09', '313.39', '347.10', '0.9013', '0.9502', '0.9284', '0.9017', '2994.09', '2955.84', '2985.26', '199.50', '221.82', '226.56', '225.17', '383.46', '398.81', '397.11');
INSERT INTO `power_realtime` VALUES ('231', '1', '1641331800', '1564.80', '521.90', '487.99', '554.91', '735.25', '249.70', '239.52', '246.03', '0.9841', '0.9687', '0.9621', '0.9757', '2981.59', '2991.96', '2991.42', '197.69', '226.52', '222.83', '221.54', '386.61', '383.44', '397.89');
INSERT INTO `power_realtime` VALUES ('232', '1', '1641332100', '2704.51', '920.11', '862.80', '921.60', '887.97', '299.47', '290.30', '298.19', '0.9833', '0.9924', '0.9490', '0.9293', '2983.73', '2998.08', '2957.17', '199.27', '222.42', '229.91', '223.24', '386.54', '381.04', '393.52');
INSERT INTO `power_realtime` VALUES ('233', '1', '1641332400', '1695.79', '587.21', '550.08', '558.50', '654.60', '223.24', '216.14', '215.22', '0.9093', '0.9744', '0.9752', '0.9867', '2988.47', '2979.38', '2995.28', '199.08', '222.07', '225.42', '221.35', '380.88', '387.47', '395.86');
INSERT INTO `power_realtime` VALUES ('234', '1', '1641332700', '2488.89', '847.19', '816.22', '825.47', '667.26', '239.33', '220.52', '207.41', '0.9311', '0.9003', '0.9299', '0.9910', '2983.66', '2995.53', '2979.65', '197.45', '228.54', '222.10', '227.72', '393.25', '391.14', '390.00');
INSERT INTO `power_realtime` VALUES ('235', '1', '1641333000', '2215.94', '764.72', '702.92', '748.31', '978.76', '333.35', '322.63', '322.78', '0.9630', '0.9202', '0.9706', '0.9863', '2980.70', '2962.55', '2990.47', '197.91', '227.75', '223.87', '225.93', '392.11', '398.38', '385.17');
INSERT INTO `power_realtime` VALUES ('236', '1', '1641333300', '2782.48', '939.88', '915.76', '926.84', '950.42', '322.70', '315.25', '312.47', '0.9543', '0.9462', '0.9553', '0.9111', '2992.53', '2993.21', '2992.17', '198.38', '220.58', '227.71', '228.40', '393.97', '386.10', '398.20');
INSERT INTO `power_realtime` VALUES ('237', '1', '1641333600', '2494.11', '862.34', '794.85', '836.92', '533.96', '185.83', '163.59', '184.54', '0.9626', '0.9629', '0.9281', '0.9635', '2993.97', '2996.00', '2951.17', '199.03', '221.65', '226.18', '227.28', '383.19', '380.96', '396.98');
INSERT INTO `power_realtime` VALUES ('238', '1', '1641333900', '2809.05', '983.16', '931.58', '894.31', '850.52', '286.47', '266.27', '297.79', '0.9716', '0.9098', '0.9400', '0.9720', '2953.87', '2962.21', '2954.80', '198.28', '221.46', '227.03', '223.72', '394.73', '391.98', '392.46');
INSERT INTO `power_realtime` VALUES ('239', '1', '1641334200', '2097.55', '734.82', '657.02', '705.71', '959.17', '328.80', '315.42', '314.94', '0.9935', '0.9980', '0.9462', '0.9198', '2956.71', '2984.49', '2988.99', '198.50', '229.23', '225.52', '223.12', '386.76', '393.97', '385.46');
INSERT INTO `power_realtime` VALUES ('240', '1', '1641334500', '2689.21', '937.62', '846.79', '904.79', '773.51', '265.96', '248.21', '259.34', '0.9952', '0.9038', '0.9379', '0.9099', '2977.17', '2969.17', '2971.19', '198.16', '225.03', '223.45', '222.61', '397.92', '390.50', '389.73');
INSERT INTO `power_realtime` VALUES ('241', '1', '1641334800', '2998.40', '1024.67', '964.03', '1009.69', '730.60', '251.86', '236.25', '242.50', '0.9846', '0.9505', '0.9427', '0.9414', '2984.04', '2977.85', '2965.61', '198.06', '222.80', '225.09', '222.28', '398.29', '399.40', '384.05');
INSERT INTO `power_realtime` VALUES ('242', '1', '1641335100', '2136.81', '747.73', '696.97', '692.11', '539.15', '181.17', '161.09', '196.89', '0.9109', '0.9428', '0.9638', '0.9790', '2979.71', '2961.92', '2980.89', '198.30', '228.70', '225.35', '222.06', '384.72', '398.92', '395.02');
INSERT INTO `power_realtime` VALUES ('243', '1', '1641335400', '1650.02', '591.46', '540.44', '518.13', '635.42', '231.46', '197.17', '206.80', '0.9515', '0.9537', '0.9241', '0.9435', '2978.78', '2986.38', '2965.68', '197.67', '224.13', '228.67', '223.05', '399.24', '390.46', '397.38');
INSERT INTO `power_realtime` VALUES ('244', '1', '1641335700', '2352.39', '825.86', '770.68', '755.85', '854.56', '304.44', '270.93', '279.19', '0.9896', '0.9858', '0.9334', '0.9363', '2993.83', '2976.86', '2974.68', '196.76', '227.61', '229.17', '224.65', '384.58', '392.99', '381.34');
INSERT INTO `power_realtime` VALUES ('245', '1', '1641336000', '2181.49', '763.90', '721.60', '695.99', '782.67', '274.63', '257.57', '250.48', '0.9289', '0.9333', '0.9154', '0.9255', '2977.78', '2965.79', '2977.47', '198.09', '226.34', '222.47', '227.63', '392.84', '385.55', '395.21');
INSERT INTO `power_realtime` VALUES ('246', '1', '1641336300', '2049.31', '715.25', '636.07', '697.98', '790.62', '271.30', '256.31', '263.02', '0.9394', '0.9612', '0.9993', '0.9708', '2971.23', '2960.62', '2974.23', '197.27', '225.13', '228.51', '227.48', '391.89', '397.39', '388.10');
INSERT INTO `power_realtime` VALUES ('247', '1', '1641336600', '2833.02', '986.29', '940.40', '906.32', '864.14', '299.17', '284.04', '280.93', '0.9896', '0.9934', '0.9172', '0.9517', '2969.07', '2958.25', '2966.12', '198.30', '228.63', '221.80', '223.05', '390.52', '390.15', '390.04');
INSERT INTO `power_realtime` VALUES ('248', '1', '1641336900', '2923.06', '1022.22', '971.15', '929.69', '536.90', '183.05', '165.41', '188.44', '0.9863', '0.9564', '0.9397', '0.9817', '2953.75', '2986.44', '2954.64', '197.22', '222.00', '220.87', '221.97', '385.18', '383.43', '396.99');
INSERT INTO `power_realtime` VALUES ('249', '1', '1641337200', '2630.53', '918.44', '873.55', '838.54', '503.22', '175.61', '149.21', '178.41', '0.9257', '0.9739', '0.9319', '0.9446', '2993.00', '2963.45', '2962.07', '198.42', '224.75', '222.93', '226.39', '381.44', '383.92', '394.73');
INSERT INTO `power_realtime` VALUES ('250', '1', '1641337500', '2749.40', '945.56', '887.64', '916.20', '835.11', '296.01', '264.78', '274.31', '0.9415', '0.9287', '0.9265', '0.9786', '2967.42', '2982.93', '2976.20', '199.47', '223.90', '221.85', '221.05', '399.02', '388.53', '399.26');
INSERT INTO `power_realtime` VALUES ('251', '1', '1641337800', '2172.43', '735.93', '693.67', '742.84', '654.57', '235.91', '216.52', '202.15', '0.9372', '0.9238', '0.9758', '0.9552', '2977.78', '2951.42', '2974.58', '197.67', '224.00', '228.76', '229.96', '393.02', '384.99', '391.76');
INSERT INTO `power_realtime` VALUES ('252', '1', '1641338100', '2671.68', '918.58', '851.05', '902.05', '616.88', '212.70', '190.90', '213.28', '0.9926', '0.9709', '0.9793', '0.9568', '2984.17', '2980.55', '2979.05', '197.14', '224.79', '223.60', '227.88', '393.83', '387.11', '383.53');
INSERT INTO `power_realtime` VALUES ('253', '1', '1641338400', '2776.51', '964.68', '886.09', '925.74', '642.42', '214.16', '207.27', '221.00', '0.9525', '0.9106', '0.9687', '0.9498', '2997.79', '2965.87', '2977.80', '199.79', '220.61', '223.75', '229.10', '385.17', '398.64', '380.47');
INSERT INTO `power_realtime` VALUES ('254', '1', '1641338700', '1613.13', '566.72', '512.03', '534.38', '995.97', '343.20', '319.25', '333.52', '0.9284', '0.9390', '0.9824', '0.9731', '2982.96', '2968.52', '2981.90', '199.91', '220.74', '222.11', '227.92', '383.95', '397.53', '387.86');
INSERT INTO `power_realtime` VALUES ('255', '1', '1641339000', '2610.13', '871.66', '851.63', '886.83', '550.55', '190.87', '182.79', '176.90', '0.9794', '0.9608', '0.9683', '0.9253', '2979.90', '2954.77', '2954.37', '197.13', '225.14', '221.50', '223.22', '395.92', '392.35', '383.85');
INSERT INTO `power_realtime` VALUES ('256', '1', '1641339300', '2124.47', '721.14', '676.43', '726.90', '890.35', '305.40', '295.24', '289.71', '0.9831', '0.9229', '0.9217', '0.9237', '2979.75', '2992.55', '2963.61', '199.48', '226.73', '225.27', '223.42', '399.07', '384.64', '395.37');
INSERT INTO `power_realtime` VALUES ('257', '1', '1641339600', '2301.67', '770.89', '728.98', '801.81', '801.68', '279.44', '251.15', '271.09', '0.9576', '0.9019', '0.9907', '0.9432', '2971.22', '2952.08', '2968.96', '197.49', '229.03', '225.71', '227.94', '391.21', '394.51', '391.34');
INSERT INTO `power_realtime` VALUES ('258', '1', '1641339900', '2852.47', '966.22', '904.17', '982.08', '674.70', '232.29', '221.67', '220.75', '0.9607', '0.9199', '0.9682', '0.9995', '2983.01', '2961.02', '2993.72', '197.63', '225.99', '221.27', '227.06', '389.28', '392.58', '387.13');
INSERT INTO `power_realtime` VALUES ('259', '1', '1641340200', '2906.38', '991.27', '933.22', '981.89', '889.31', '313.17', '278.11', '298.03', '0.9632', '0.9495', '0.9338', '0.9449', '2968.62', '2972.26', '2981.79', '199.94', '220.68', '222.72', '223.77', '386.61', '388.72', '389.17');
INSERT INTO `power_realtime` VALUES ('260', '1', '1641340500', '2690.01', '936.41', '889.57', '864.02', '888.52', '308.23', '280.52', '299.77', '0.9741', '0.9412', '0.9143', '0.9715', '2969.36', '2964.96', '2965.78', '199.55', '229.37', '224.22', '228.88', '399.12', '397.44', '381.49');
INSERT INTO `power_realtime` VALUES ('261', '1', '1641340800', '1974.52', '690.74', '619.09', '664.69', '849.75', '297.87', '278.41', '273.47', '0.9862', '0.9603', '0.9958', '0.9878', '2998.23', '2966.45', '2999.55', '198.59', '229.22', '221.40', '224.21', '383.65', '390.96', '384.60');
INSERT INTO `power_realtime` VALUES ('262', '1', '1641341100', '1543.19', '515.44', '487.91', '539.84', '650.34', '235.99', '196.89', '217.46', '0.9112', '0.9606', '0.9415', '0.9307', '2960.81', '2954.64', '2974.58', '197.57', '229.47', '221.58', '228.23', '390.60', '384.35', '383.70');
INSERT INTO `power_realtime` VALUES ('263', '1', '1641341400', '2845.05', '988.02', '940.38', '916.64', '687.34', '248.68', '226.86', '211.80', '0.9809', '0.9469', '0.9557', '0.9149', '2970.47', '2976.95', '2998.62', '199.05', '229.61', '223.61', '223.87', '398.44', '391.55', '385.73');
INSERT INTO `power_realtime` VALUES ('264', '1', '1641341700', '2526.00', '878.08', '816.04', '831.88', '553.40', '202.82', '169.76', '180.82', '0.9121', '0.9863', '0.9730', '0.9852', '2973.33', '2952.95', '2966.08', '199.68', '221.83', '225.39', '229.91', '390.74', '388.70', '384.94');
INSERT INTO `power_realtime` VALUES ('265', '1', '1641342000', '1662.67', '571.52', '539.19', '551.96', '590.74', '216.01', '185.65', '189.08', '0.9598', '0.9214', '0.9560', '0.9480', '2973.69', '2963.99', '2993.19', '198.10', '229.91', '225.99', '224.26', '395.54', '399.18', '393.16');
INSERT INTO `power_realtime` VALUES ('266', '1', '1641342300', '2768.11', '952.68', '916.89', '898.53', '943.26', '334.22', '303.95', '305.09', '0.9183', '0.9146', '0.9425', '0.9895', '2993.26', '2973.40', '2976.12', '199.44', '223.04', '226.71', '221.11', '393.52', '395.98', '384.55');
INSERT INTO `power_realtime` VALUES ('267', '1', '1641342600', '2491.51', '831.80', '811.34', '848.36', '903.12', '319.11', '287.18', '296.84', '0.9822', '0.9166', '0.9075', '0.9665', '2957.06', '2966.30', '2958.13', '199.67', '229.45', '221.38', '222.93', '394.48', '399.05', '395.15');
INSERT INTO `power_realtime` VALUES ('268', '1', '1641342900', '2396.35', '819.75', '790.54', '786.05', '602.56', '217.01', '181.21', '204.34', '0.9294', '0.9965', '0.9810', '0.9580', '2976.11', '2998.00', '2961.78', '196.85', '222.96', '220.34', '223.41', '381.83', '389.95', '384.71');
INSERT INTO `power_realtime` VALUES ('269', '1', '1641343200', '1773.32', '601.95', '556.85', '614.52', '934.17', '312.43', '308.70', '313.04', '0.9575', '0.9010', '0.9043', '0.9115', '2990.67', '2994.49', '2954.05', '199.29', '223.93', '225.42', '228.78', '392.01', '392.18', '392.71');
INSERT INTO `power_realtime` VALUES ('270', '1', '1641343500', '1625.44', '549.46', '506.80', '569.17', '993.53', '340.20', '325.04', '328.29', '0.9789', '0.9265', '0.9034', '0.9885', '2999.47', '2957.87', '2966.55', '198.50', '226.03', '224.26', '221.54', '389.31', '393.69', '381.30');
INSERT INTO `power_realtime` VALUES ('271', '1', '1641343800', '2253.30', '777.42', '736.53', '739.35', '826.89', '283.17', '258.36', '285.36', '0.9634', '0.9854', '0.9192', '0.9293', '2978.59', '2993.85', '2989.68', '198.49', '220.88', '221.89', '224.02', '397.54', '398.12', '396.04');
INSERT INTO `power_realtime` VALUES ('272', '1', '1641344100', '2768.42', '968.68', '876.86', '922.88', '833.46', '295.43', '276.95', '261.09', '0.9127', '0.9335', '0.9471', '0.9968', '2989.41', '2996.64', '2997.85', '197.97', '223.76', '225.85', '227.92', '397.63', '383.16', '390.06');
INSERT INTO `power_realtime` VALUES ('273', '1', '1641344400', '2871.61', '974.67', '918.67', '978.27', '816.89', '291.69', '255.42', '269.78', '0.9509', '0.9892', '0.9188', '0.9412', '2987.85', '2950.48', '2993.82', '199.66', '226.75', '227.12', '220.57', '394.65', '398.02', '388.91');
INSERT INTO `power_realtime` VALUES ('274', '1', '1641344700', '2852.46', '985.26', '924.13', '943.07', '903.64', '312.07', '285.49', '306.08', '0.9324', '0.9339', '0.9928', '0.9387', '2977.20', '2984.70', '2983.44', '196.72', '228.40', '224.33', '229.92', '399.20', '387.88', '382.05');
INSERT INTO `power_realtime` VALUES ('275', '1', '1641345000', '2993.54', '1025.04', '962.16', '1006.34', '847.29', '286.75', '277.51', '283.04', '0.9846', '0.9122', '0.9161', '0.9055', '2993.96', '2952.32', '2956.91', '197.73', '223.94', '222.16', '226.53', '396.38', '390.30', '392.36');
INSERT INTO `power_realtime` VALUES ('276', '1', '1641345300', '1900.53', '635.25', '606.67', '658.61', '617.13', '215.48', '192.54', '209.11', '0.9388', '0.9776', '0.9728', '0.9709', '2980.68', '2989.33', '2960.15', '198.04', '224.98', '226.35', '223.73', '390.66', '388.34', '397.25');
INSERT INTO `power_realtime` VALUES ('277', '1', '1641345600', '2726.54', '938.38', '894.54', '893.62', '626.96', '213.83', '204.56', '208.57', '0.9411', '0.9315', '0.9530', '0.9086', '2981.13', '2954.16', '2989.78', '197.66', '224.06', '228.10', '225.56', '397.00', '385.96', '394.33');
INSERT INTO `power_realtime` VALUES ('278', '1', '1641345900', '2814.41', '955.67', '906.35', '952.39', '995.69', '343.37', '318.04', '334.29', '0.9846', '0.9941', '0.9434', '0.9763', '2992.18', '2993.63', '2986.23', '199.19', '226.60', '229.43', '226.78', '397.41', '394.75', '380.53');
INSERT INTO `power_realtime` VALUES ('279', '1', '1641346200', '2446.99', '857.74', '806.62', '782.62', '845.02', '288.43', '272.16', '284.42', '0.9643', '0.9188', '0.9781', '0.9998', '2972.61', '2983.02', '2984.35', '199.06', '220.77', '227.91', '229.51', '398.04', '385.69', '386.59');
INSERT INTO `power_realtime` VALUES ('280', '1', '1641346500', '1669.75', '573.54', '512.28', '583.93', '831.38', '288.94', '267.66', '274.78', '0.9247', '0.9230', '0.9787', '0.9550', '2992.12', '2994.44', '2956.09', '199.45', '225.13', '224.95', '227.66', '384.29', '386.75', '398.67');
INSERT INTO `power_realtime` VALUES ('281', '1', '1641346800', '2034.79', '714.63', '647.22', '672.93', '879.56', '299.40', '290.58', '289.58', '0.9487', '0.9471', '0.9628', '0.9581', '2954.43', '2958.10', '2998.91', '198.45', '223.40', '225.62', '222.40', '381.25', '395.77', '385.46');
INSERT INTO `power_realtime` VALUES ('282', '1', '1641347100', '2108.55', '738.93', '688.48', '681.14', '933.09', '319.02', '298.10', '315.96', '0.9214', '0.9843', '0.9136', '0.9582', '2995.47', '2997.14', '2983.55', '197.48', '227.34', '220.50', '220.46', '382.80', '388.60', '392.74');
INSERT INTO `power_realtime` VALUES ('283', '1', '1641347400', '2188.96', '731.28', '714.42', '743.26', '963.39', '340.68', '308.98', '313.73', '0.9021', '0.9331', '0.9716', '0.9550', '2992.99', '2986.63', '2977.78', '199.11', '229.83', '220.95', '221.05', '396.35', '395.06', '387.95');
INSERT INTO `power_realtime` VALUES ('284', '1', '1641347700', '2389.79', '817.58', '778.39', '793.82', '983.45', '335.75', '324.31', '323.38', '0.9428', '0.9219', '0.9394', '0.9144', '2975.04', '2962.38', '2957.40', '197.35', '223.62', '228.27', '227.44', '399.98', '389.65', '394.48');
INSERT INTO `power_realtime` VALUES ('285', '1', '1641348000', '1572.11', '554.25', '502.07', '515.78', '894.75', '303.37', '287.76', '303.62', '0.9064', '0.9341', '0.9794', '0.9517', '2984.64', '2984.84', '2953.03', '197.03', '224.73', '225.20', '225.32', '386.10', '380.01', '389.56');
INSERT INTO `power_realtime` VALUES ('286', '1', '1641348300', '1533.54', '545.87', '461.22', '526.45', '656.60', '236.89', '210.04', '209.67', '0.9632', '0.9279', '0.9338', '0.9755', '2993.69', '2997.80', '2960.37', '198.35', '224.06', '224.22', '221.98', '389.21', '394.48', '391.00');
INSERT INTO `power_realtime` VALUES ('287', '1', '1641348600', '1906.90', '640.97', '622.91', '643.02', '505.88', '179.79', '151.69', '174.41', '0.9791', '0.9943', '0.9016', '0.9441', '2962.81', '2960.38', '2962.96', '198.17', '226.66', '221.66', '228.48', '386.65', '389.89', '385.48');
INSERT INTO `power_realtime` VALUES ('288', '1', '1641348900', '2369.31', '838.72', '787.72', '742.87', '772.04', '263.22', '246.13', '262.69', '0.9518', '0.9289', '0.9773', '0.9838', '2964.69', '2974.78', '2980.34', '199.57', '224.34', '229.91', '220.76', '398.23', '382.53', '396.54');
INSERT INTO `power_realtime` VALUES ('289', '1', '1641349200', '2022.60', '708.42', '641.98', '672.20', '727.29', '251.22', '227.02', '249.05', '0.9045', '0.9120', '0.9794', '0.9450', '2975.81', '2980.38', '2960.03', '197.10', '225.12', '221.18', '225.45', '395.76', '389.37', '391.46');
INSERT INTO `power_realtime` VALUES ('290', '1', '1641349500', '1674.03', '578.24', '535.40', '560.39', '885.01', '314.76', '284.42', '285.83', '0.9098', '0.9941', '0.9861', '0.9352', '2997.11', '2988.12', '2979.94', '199.39', '221.13', '226.45', '222.02', '384.47', '391.59', '385.38');
INSERT INTO `power_realtime` VALUES ('291', '1', '1641349800', '2724.69', '940.67', '866.72', '917.30', '710.65', '251.41', '235.04', '224.20', '0.9858', '0.9700', '0.9368', '0.9670', '2985.84', '2986.57', '2968.04', '197.12', '226.16', '221.34', '224.55', '396.64', '380.49', '396.00');
INSERT INTO `power_realtime` VALUES ('292', '1', '1641350100', '2960.29', '998.68', '985.65', '975.96', '838.91', '290.89', '278.59', '269.43', '0.9923', '0.9945', '0.9664', '0.9904', '2970.51', '2963.87', '2978.20', '199.23', '224.33', '227.70', '223.98', '383.14', '395.00', '394.88');
INSERT INTO `power_realtime` VALUES ('293', '1', '1641350400', '2735.62', '939.39', '902.49', '893.74', '598.29', '210.49', '198.70', '189.09', '0.9391', '0.9515', '0.9011', '0.9438', '2977.40', '2956.51', '2986.13', '197.27', '222.43', '224.70', '225.52', '380.21', '391.13', '390.25');
INSERT INTO `power_realtime` VALUES ('294', '1', '1641350700', '2350.42', '820.44', '737.99', '791.99', '930.02', '322.94', '306.23', '300.84', '0.9246', '0.9233', '0.9680', '0.9609', '2970.84', '2958.11', '2985.58', '199.96', '220.93', '226.99', '225.09', '388.07', '397.04', '382.61');
INSERT INTO `power_realtime` VALUES ('295', '1', '1641351000', '2329.74', '789.02', '744.81', '795.90', '651.94', '218.22', '201.43', '232.28', '0.9281', '0.9356', '0.9545', '0.9048', '2950.48', '2997.49', '2974.46', '197.56', '221.45', '229.58', '224.39', '383.42', '382.20', '397.08');
INSERT INTO `power_realtime` VALUES ('296', '1', '1641351300', '1846.77', '623.71', '588.75', '634.31', '959.86', '327.49', '316.95', '315.42', '0.9986', '0.9587', '0.9936', '0.9691', '2956.84', '2976.93', '2971.02', '198.63', '222.87', '229.61', '225.44', '380.72', '386.10', '396.54');
INSERT INTO `power_realtime` VALUES ('297', '1', '1641351600', '1660.47', '595.89', '542.12', '522.47', '578.93', '204.59', '188.02', '186.33', '0.9129', '0.9410', '0.9568', '0.9914', '2961.88', '2997.03', '2994.18', '199.76', '222.97', '224.11', '222.95', '396.51', '390.53', '395.96');
INSERT INTO `power_realtime` VALUES ('298', '1', '1641351900', '2683.99', '939.66', '864.45', '879.88', '575.82', '202.34', '174.14', '199.34', '0.9103', '0.9260', '0.9904', '0.9613', '2963.79', '2985.41', '2977.18', '199.11', '228.60', '220.40', '225.79', '397.54', '380.32', '392.37');
INSERT INTO `power_realtime` VALUES ('299', '1', '1641352200', '2152.75', '747.74', '675.29', '729.71', '518.49', '189.83', '160.17', '168.49', '0.9602', '0.9659', '0.9584', '0.9782', '2964.98', '2991.65', '2961.44', '196.81', '224.12', '221.54', '228.48', '386.71', '399.60', '394.88');
INSERT INTO `power_realtime` VALUES ('300', '1', '1641352500', '2323.69', '824.49', '762.25', '736.95', '925.15', '320.12', '301.78', '303.24', '0.9741', '0.9936', '0.9305', '0.9218', '2988.97', '2960.85', '2987.70', '199.11', '225.76', '223.40', '228.52', '380.82', '395.25', '386.82');
INSERT INTO `power_realtime` VALUES ('301', '1', '1641352800', '1708.79', '578.12', '562.85', '567.82', '776.09', '262.10', '256.46', '257.52', '0.9387', '0.9404', '0.9928', '0.9376', '2986.32', '2952.78', '2963.10', '199.64', '228.25', '222.95', '226.39', '381.39', '385.31', '396.09');
INSERT INTO `power_realtime` VALUES ('302', '1', '1641353100', '2527.10', '869.42', '812.61', '845.07', '772.96', '268.06', '250.70', '254.20', '0.9234', '0.9069', '0.9591', '0.9173', '2990.62', '2983.04', '2987.57', '198.83', '229.65', '228.21', '222.27', '393.46', '398.20', '391.03');
INSERT INTO `power_realtime` VALUES ('303', '1', '1641353400', '1850.25', '657.07', '612.91', '580.27', '518.88', '188.12', '162.74', '168.02', '0.9967', '0.9889', '0.9174', '0.9630', '2964.32', '2976.44', '2969.00', '199.54', '221.16', '220.21', '226.48', '388.20', '398.76', '396.89');
INSERT INTO `power_realtime` VALUES ('304', '1', '1641353700', '1816.15', '636.98', '591.57', '587.59', '859.43', '302.28', '268.87', '288.28', '0.9839', '0.9464', '0.9628', '0.9698', '2969.74', '2991.83', '2995.40', '198.86', '229.93', '224.93', '229.21', '392.70', '388.75', '382.97');
INSERT INTO `power_realtime` VALUES ('305', '1', '1641354000', '1794.75', '617.45', '555.90', '621.39', '769.86', '274.94', '242.59', '252.33', '0.9963', '0.9718', '0.9442', '0.9372', '2963.36', '2950.64', '2963.24', '199.97', '225.71', '220.25', '220.55', '384.96', '383.26', '382.11');
INSERT INTO `power_realtime` VALUES ('306', '1', '1641354300', '1508.77', '551.49', '472.94', '484.34', '896.75', '318.49', '283.59', '294.67', '0.9802', '0.9637', '0.9908', '0.9373', '2991.65', '2979.78', '2983.73', '197.49', '225.27', '227.19', '221.86', '393.17', '380.24', '392.81');
INSERT INTO `power_realtime` VALUES ('307', '1', '1641354600', '2839.90', '963.48', '904.21', '972.21', '663.86', '228.23', '214.05', '221.57', '0.9510', '0.9508', '0.9754', '0.9111', '2963.84', '2962.11', '2954.53', '197.50', '223.30', '228.65', '226.91', '387.15', '397.59', '399.68');
INSERT INTO `power_realtime` VALUES ('308', '1', '1641354900', '2388.67', '809.22', '772.61', '806.84', '731.09', '247.40', '240.08', '243.61', '0.9109', '0.9313', '0.9296', '0.9499', '2991.48', '2975.19', '2991.21', '196.72', '223.27', '220.27', '223.45', '384.39', '391.71', '390.32');
INSERT INTO `power_realtime` VALUES ('309', '1', '1641355200', '1802.86', '645.74', '597.56', '559.55', '553.15', '185.35', '182.08', '185.72', '0.9907', '0.9981', '0.9381', '0.9308', '2966.17', '2991.28', '2962.90', '197.49', '228.48', '228.41', '224.58', '395.57', '392.76', '385.84');
INSERT INTO `power_realtime` VALUES ('310', '1', '1641355500', '2445.39', '861.19', '800.31', '783.89', '820.07', '290.01', '257.75', '272.31', '0.9024', '0.9103', '0.9132', '0.9311', '2995.64', '2958.18', '2967.71', '198.73', '220.46', '228.88', '223.73', '383.11', '394.83', '398.29');
INSERT INTO `power_realtime` VALUES ('311', '1', '1641355800', '2138.41', '724.34', '705.45', '708.63', '675.57', '234.97', '219.68', '220.93', '0.9519', '0.9447', '0.9833', '0.9269', '2984.44', '2982.14', '2967.96', '199.21', '229.93', '227.17', '227.81', '382.08', '384.17', '381.44');
INSERT INTO `power_realtime` VALUES ('312', '1', '1641356100', '1994.92', '708.92', '646.16', '639.84', '801.05', '281.27', '248.53', '271.24', '0.9283', '0.9213', '0.9215', '0.9030', '2978.40', '2990.30', '2981.16', '197.26', '224.74', '226.43', '229.05', '395.56', '395.68', '390.79');
INSERT INTO `power_realtime` VALUES ('313', '1', '1641356400', '2733.65', '929.28', '870.36', '934.02', '723.12', '241.79', '227.14', '254.18', '0.9649', '0.9375', '0.9914', '0.9551', '2992.71', '2960.89', '2990.89', '197.53', '229.19', '223.47', '228.68', '385.93', '396.47', '395.79');
INSERT INTO `power_realtime` VALUES ('314', '1', '1641356700', '1866.73', '641.17', '592.15', '633.41', '550.67', '190.44', '171.97', '188.26', '0.9530', '0.9743', '0.9978', '0.9521', '2960.56', '2975.16', '2952.40', '197.20', '229.92', '225.41', '223.84', '399.91', '385.73', '390.49');
INSERT INTO `power_realtime` VALUES ('315', '1', '1641357000', '2752.35', '964.91', '888.14', '899.31', '773.78', '274.75', '249.07', '249.96', '0.9887', '0.9498', '0.9018', '0.9504', '2974.57', '2965.01', '2970.43', '197.85', '225.50', '220.49', '223.25', '388.69', '393.15', '389.59');
INSERT INTO `power_realtime` VALUES ('316', '1', '1641357300', '1717.48', '577.07', '551.11', '589.30', '761.04', '273.30', '238.16', '249.58', '0.9368', '0.9897', '0.9874', '0.9075', '2994.46', '2955.63', '2971.51', '198.52', '229.83', '225.86', '227.27', '394.22', '391.76', '393.85');
INSERT INTO `power_realtime` VALUES ('317', '1', '1641357600', '2777.00', '942.44', '884.28', '950.27', '674.63', '237.00', '218.55', '219.08', '0.9137', '0.9659', '0.9566', '0.9354', '2964.13', '2981.68', '2980.07', '199.46', '222.78', '222.85', '224.26', '390.26', '397.96', '383.41');
INSERT INTO `power_realtime` VALUES ('318', '1', '1641357900', '2907.15', '1018.52', '948.07', '940.56', '682.90', '244.73', '213.05', '225.12', '0.9123', '0.9198', '0.9788', '0.9574', '2967.23', '2990.20', '2987.15', '199.62', '226.70', '226.38', '226.98', '390.06', '389.28', '388.23');
INSERT INTO `power_realtime` VALUES ('319', '1', '1641358200', '2371.58', '812.39', '757.34', '801.85', '589.01', '196.45', '188.14', '204.43', '0.9326', '0.9339', '0.9269', '0.9952', '2953.83', '2982.21', '2971.56', '199.04', '222.52', '229.82', '220.74', '383.90', '390.27', '393.19');
INSERT INTO `power_realtime` VALUES ('320', '1', '1641358500', '2748.01', '952.36', '871.74', '923.91', '811.29', '279.93', '250.83', '280.53', '0.9171', '0.9509', '0.9005', '0.9044', '2991.57', '2988.87', '2997.36', '197.67', '226.17', '229.65', '229.08', '386.99', '399.18', '399.91');
INSERT INTO `power_realtime` VALUES ('321', '1', '1641358800', '2063.18', '705.94', '673.36', '683.89', '545.65', '194.86', '177.08', '173.70', '0.9512', '0.9567', '0.9630', '0.9078', '2982.38', '2976.29', '2967.08', '197.99', '223.32', '225.60', '222.42', '382.79', '391.50', '389.26');
INSERT INTO `power_realtime` VALUES ('322', '1', '1641359100', '1812.06', '630.25', '585.96', '595.85', '913.89', '306.19', '300.95', '306.76', '0.9447', '0.9446', '0.9037', '0.9371', '2990.93', '2976.26', '2958.14', '199.57', '228.67', '222.08', '220.92', '398.31', '382.00', '386.98');
INSERT INTO `power_realtime` VALUES ('323', '1', '1641359400', '1615.43', '582.12', '507.60', '525.71', '952.70', '334.38', '314.44', '303.89', '0.9873', '0.9673', '0.9849', '0.9935', '2953.26', '2997.81', '2960.21', '196.79', '225.98', '224.96', '224.54', '386.14', '394.76', '390.34');
INSERT INTO `power_realtime` VALUES ('324', '1', '1641359700', '2857.49', '991.53', '903.85', '962.11', '927.72', '320.28', '301.25', '306.19', '0.9477', '0.9513', '0.9335', '0.9672', '2973.34', '2987.28', '2963.56', '199.36', '224.55', '224.40', '221.02', '393.07', '399.60', '386.10');
INSERT INTO `power_realtime` VALUES ('325', '1', '1641360000', '1841.75', '614.74', '592.27', '634.74', '664.55', '232.87', '220.81', '210.87', '0.9812', '0.9065', '0.9053', '0.9230', '2971.93', '2971.11', '2972.96', '198.47', '229.87', '220.02', '225.79', '387.27', '384.75', '399.08');
INSERT INTO `power_realtime` VALUES ('326', '1', '1641360300', '2809.60', '982.25', '889.50', '937.84', '874.22', '299.85', '271.62', '302.75', '0.9051', '0.9014', '0.9701', '0.9611', '2975.93', '2988.16', '2988.53', '197.39', '227.70', '227.87', '227.74', '394.75', '388.85', '397.10');
INSERT INTO `power_realtime` VALUES ('327', '1', '1641360600', '2581.67', '890.97', '841.64', '849.06', '814.24', '280.17', '261.70', '272.38', '0.9160', '0.9992', '0.9512', '0.9958', '2977.34', '2994.24', '2953.90', '199.40', '224.38', '221.29', '229.91', '381.70', '390.00', '380.47');
INSERT INTO `power_realtime` VALUES ('328', '1', '1641360900', '2106.85', '710.60', '664.90', '731.36', '568.54', '204.00', '179.36', '185.18', '0.9380', '0.9592', '0.9923', '0.9640', '2999.16', '2953.01', '2972.95', '198.64', '220.05', '227.88', '225.77', '391.86', '386.78', '384.48');
INSERT INTO `power_realtime` VALUES ('329', '1', '1641361200', '1838.02', '630.63', '588.27', '619.13', '749.46', '260.07', '248.53', '240.86', '0.9195', '0.9992', '0.9278', '0.9805', '2980.76', '2963.35', '2989.97', '197.88', '226.39', '223.86', '228.90', '387.72', '384.68', '399.82');
INSERT INTO `power_realtime` VALUES ('330', '1', '1641361500', '2097.56', '716.64', '662.09', '718.83', '522.99', '191.42', '170.83', '160.74', '0.9357', '0.9942', '0.9943', '0.9951', '2987.96', '2963.74', '2963.51', '197.27', '226.63', '224.75', '227.37', '390.50', '382.02', '389.57');
INSERT INTO `power_realtime` VALUES ('331', '1', '1641361800', '2948.19', '1022.84', '976.69', '948.66', '535.00', '183.43', '173.70', '177.87', '0.9974', '0.9460', '0.9385', '0.9773', '2962.64', '2999.49', '2991.67', '196.87', '222.26', '226.82', '223.18', '387.36', '392.01', '391.57');
INSERT INTO `power_realtime` VALUES ('332', '1', '1641362100', '2047.71', '722.05', '673.03', '652.63', '570.36', '204.56', '173.89', '191.91', '0.9263', '0.9048', '0.9588', '0.9639', '2953.76', '2988.66', '2966.81', '199.90', '228.62', '228.31', '222.27', '394.34', '381.92', '382.72');
INSERT INTO `power_realtime` VALUES ('333', '1', '1641362400', '2537.43', '864.42', '823.25', '849.76', '609.47', '203.87', '202.39', '203.22', '0.9196', '0.9564', '0.9558', '0.9442', '2965.45', '2977.12', '2999.38', '199.92', '220.61', '221.87', '221.78', '390.40', '396.36', '385.59');
INSERT INTO `power_realtime` VALUES ('334', '1', '1641362700', '1695.56', '612.41', '562.31', '520.84', '857.37', '301.64', '278.99', '276.74', '0.9034', '0.9996', '0.9659', '0.9341', '2969.57', '2982.47', '2955.03', '199.44', '229.08', '221.19', '228.15', '392.13', '380.20', '399.04');
INSERT INTO `power_realtime` VALUES ('335', '1', '1641363000', '2877.34', '971.33', '913.55', '992.47', '809.31', '288.06', '254.08', '267.17', '0.9583', '0.9418', '0.9078', '0.9995', '2958.16', '2990.69', '2995.56', '198.17', '229.19', '224.08', '222.78', '399.15', '386.18', '392.34');
INSERT INTO `power_realtime` VALUES ('336', '1', '1641363300', '2163.44', '742.84', '720.12', '700.48', '983.64', '344.81', '323.45', '315.38', '0.9938', '0.9199', '0.9932', '0.9361', '2957.17', '2987.91', '2952.78', '197.10', '223.80', '222.42', '220.62', '388.00', '384.47', '397.13');
INSERT INTO `power_realtime` VALUES ('337', '1', '1641363600', '2647.48', '922.82', '871.04', '853.62', '597.85', '212.32', '196.60', '188.92', '0.9509', '0.9253', '0.9232', '0.9883', '2985.48', '2983.29', '2995.36', '199.13', '227.02', '225.86', '222.13', '386.85', '384.91', '383.47');
INSERT INTO `power_realtime` VALUES ('338', '1', '1641363900', '2912.42', '994.60', '945.72', '972.10', '686.62', '239.69', '220.21', '226.72', '0.9270', '0.9615', '0.9348', '0.9049', '2973.47', '2956.85', '2971.49', '199.47', '226.92', '221.14', '229.67', '384.76', '398.49', '394.39');
INSERT INTO `power_realtime` VALUES ('339', '1', '1641364200', '2973.15', '1034.52', '943.33', '995.30', '962.39', '323.90', '312.22', '326.27', '0.9349', '0.9007', '0.9507', '0.9785', '2952.34', '2999.05', '2975.65', '196.83', '220.40', '222.07', '226.16', '397.24', '381.90', '399.24');
INSERT INTO `power_realtime` VALUES ('340', '1', '1641364500', '1800.37', '648.36', '563.69', '588.32', '597.76', '201.36', '182.00', '214.40', '0.9426', '0.9263', '0.9447', '0.9930', '2990.17', '2996.22', '2994.91', '199.93', '228.77', '227.20', '226.50', '385.51', '388.55', '388.16');
INSERT INTO `power_realtime` VALUES ('341', '1', '1641364800', '2987.55', '1044.95', '964.82', '977.78', '567.19', '205.39', '185.40', '176.40', '0.9796', '0.9538', '0.9462', '0.9240', '2981.77', '2958.19', '2989.86', '199.05', '228.74', '222.26', '220.75', '388.20', '390.48', '389.33');
INSERT INTO `power_realtime` VALUES ('342', '1', '1641365100', '2678.81', '926.80', '888.22', '863.79', '720.53', '255.21', '235.83', '229.49', '0.9446', '0.9122', '0.9832', '0.9867', '2998.77', '2981.27', '2957.05', '199.45', '220.62', '223.25', '222.65', '393.74', '398.79', '386.63');
INSERT INTO `power_realtime` VALUES ('343', '1', '1641365400', '1541.14', '536.98', '466.91', '537.24', '875.21', '300.77', '291.66', '282.78', '0.9108', '0.9421', '0.9925', '0.9083', '2971.78', '2991.18', '2953.62', '199.58', '223.83', '223.12', '227.58', '397.08', '395.32', '388.50');
INSERT INTO `power_realtime` VALUES ('344', '1', '1641365700', '2339.35', '797.25', '762.84', '779.26', '905.38', '314.46', '285.28', '305.64', '0.9903', '0.9249', '0.9213', '0.9254', '2960.07', '2966.75', '2991.13', '197.96', '228.70', '220.33', '220.34', '387.08', '394.87', '388.31');
INSERT INTO `power_realtime` VALUES ('345', '1', '1641366000', '2556.38', '853.49', '819.84', '883.05', '576.54', '208.21', '183.74', '184.59', '0.9025', '0.9018', '0.9945', '0.9581', '2964.26', '2956.28', '2973.65', '199.42', '223.57', '222.02', '225.43', '380.55', '386.20', '383.52');
INSERT INTO `power_realtime` VALUES ('346', '1', '1641366300', '2495.07', '862.05', '815.73', '817.30', '722.34', '249.39', '222.14', '250.81', '0.9719', '0.9663', '0.9312', '0.9002', '2955.15', '2963.59', '2965.91', '199.51', '227.30', '226.32', '221.03', '395.14', '390.76', '384.34');
INSERT INTO `power_realtime` VALUES ('347', '1', '1641366600', '2400.94', '803.84', '752.05', '845.04', '786.37', '277.87', '254.66', '253.84', '0.9839', '0.9270', '0.9674', '0.9904', '2976.58', '2951.70', '2979.88', '196.70', '228.77', '229.72', '221.84', '396.63', '390.15', '383.02');
INSERT INTO `power_realtime` VALUES ('348', '1', '1641366900', '2857.43', '1002.18', '933.05', '922.20', '756.37', '270.13', '244.93', '241.30', '0.9290', '0.9342', '0.9688', '0.9832', '2982.04', '2986.33', '2962.98', '197.47', '228.26', '224.39', '226.06', '386.42', '388.19', '392.42');
INSERT INTO `power_realtime` VALUES ('349', '1', '1641367200', '2527.25', '845.47', '806.25', '875.53', '600.45', '220.07', '193.88', '186.50', '0.9836', '0.9413', '0.9077', '0.9310', '2983.83', '2971.60', '2958.28', '197.46', '228.96', '228.14', '228.25', '391.65', '389.31', '396.49');
INSERT INTO `power_realtime` VALUES ('350', '1', '1641367500', '2244.34', '777.16', '715.42', '751.77', '976.08', '344.76', '312.50', '318.83', '0.9998', '0.9402', '0.9262', '0.9146', '2980.00', '2964.30', '2986.30', '197.96', '221.59', '225.92', '221.24', '384.78', '393.32', '386.40');
INSERT INTO `power_realtime` VALUES ('351', '1', '1641367800', '2501.65', '862.06', '803.21', '836.37', '720.83', '242.10', '235.94', '242.79', '0.9103', '0.9570', '0.9155', '0.9192', '2977.46', '2992.34', '2969.27', '198.82', '220.97', '226.34', '228.85', '389.87', '386.44', '384.21');
INSERT INTO `power_realtime` VALUES ('352', '1', '1641368100', '2029.82', '721.43', '645.00', '663.39', '951.10', '321.07', '316.91', '313.12', '0.9993', '0.9275', '0.9087', '0.9469', '2950.74', '2996.51', '2982.66', '199.44', '229.59', '229.71', '224.53', '390.45', '390.39', '380.50');
INSERT INTO `power_realtime` VALUES ('353', '1', '1641368400', '2421.00', '847.76', '797.17', '776.07', '989.95', '332.10', '311.38', '346.47', '0.9427', '0.9915', '0.9094', '0.9865', '2963.27', '2963.12', '2974.26', '198.20', '221.03', '225.51', '221.24', '398.60', '395.21', '394.32');
INSERT INTO `power_realtime` VALUES ('354', '1', '1641368700', '2120.89', '715.43', '703.33', '702.13', '818.42', '287.26', '257.08', '274.08', '0.9828', '0.9464', '0.9666', '0.9238', '2983.39', '2968.31', '2989.30', '198.38', '224.26', '227.28', '223.48', '396.04', '386.74', '382.22');
INSERT INTO `power_realtime` VALUES ('355', '1', '1641369000', '2089.93', '743.83', '669.15', '676.94', '795.69', '281.92', '252.49', '261.28', '0.9758', '0.9855', '0.9502', '0.9733', '2999.43', '2962.34', '2980.28', '198.64', '229.32', '221.15', '224.17', '396.34', '387.51', '398.73');
INSERT INTO `power_realtime` VALUES ('356', '1', '1641369300', '2522.13', '846.48', '792.30', '883.35', '523.29', '193.14', '170.89', '159.27', '0.9308', '0.9209', '0.9847', '0.9446', '2977.51', '2984.84', '2962.37', '197.07', '225.32', '220.95', '226.60', '382.63', '399.03', '382.81');
INSERT INTO `power_realtime` VALUES ('357', '1', '1641369600', '2706.69', '912.16', '866.93', '927.60', '935.59', '327.21', '303.72', '304.67', '0.9480', '0.9433', '0.9666', '0.9224', '2962.51', '2968.96', '2950.10', '198.79', '222.63', '228.28', '225.47', '386.89', '384.64', '394.20');
INSERT INTO `power_realtime` VALUES ('358', '1', '1641369900', '2923.65', '1012.75', '973.46', '937.44', '984.89', '340.46', '320.28', '324.15', '0.9676', '0.9116', '0.9096', '0.9401', '2996.11', '2964.33', '2977.47', '198.75', '223.59', '229.37', '220.34', '396.24', '385.17', '389.38');
INSERT INTO `power_realtime` VALUES ('359', '1', '1641370200', '2180.73', '767.12', '713.06', '700.56', '652.87', '223.34', '216.03', '213.49', '0.9458', '0.9905', '0.9480', '0.9626', '2967.24', '2985.17', '2962.86', '199.21', '229.04', '222.77', '220.40', '396.99', '394.84', '390.18');
INSERT INTO `power_realtime` VALUES ('360', '1', '1641370500', '2122.76', '710.41', '703.13', '709.21', '962.23', '324.01', '307.35', '330.86', '0.9961', '0.9602', '0.9690', '0.9613', '2967.87', '2971.18', '2980.97', '197.64', '222.08', '222.44', '220.87', '399.96', '381.47', '397.54');
INSERT INTO `power_realtime` VALUES ('361', '1', '1641370800', '2580.00', '875.12', '814.51', '890.37', '682.31', '228.86', '208.24', '245.20', '0.9603', '0.9186', '0.9470', '0.9716', '2952.97', '2984.48', '2997.60', '198.66', '225.41', '229.72', '228.53', '390.43', '393.86', '399.82');
INSERT INTO `power_realtime` VALUES ('362', '1', '1641371100', '2465.07', '832.13', '803.29', '829.65', '520.66', '178.65', '162.45', '179.56', '0.9121', '0.9701', '0.9123', '0.9570', '2995.51', '2956.91', '2958.29', '197.41', '224.60', '225.14', '227.39', '391.80', '399.86', '398.67');
INSERT INTO `power_realtime` VALUES ('363', '1', '1641371400', '2080.95', '718.39', '670.53', '692.04', '768.76', '274.85', '254.77', '239.14', '0.9423', '0.9604', '0.9094', '0.9812', '2987.49', '2996.74', '2999.77', '197.05', '226.39', '226.93', '224.47', '386.09', '381.07', '385.70');
INSERT INTO `power_realtime` VALUES ('364', '1', '1641371700', '2365.56', '792.24', '770.92', '802.40', '624.44', '227.35', '195.64', '201.45', '0.9316', '0.9579', '0.9767', '0.9917', '2964.55', '2964.10', '2972.92', '197.29', '229.13', '227.17', '221.02', '393.73', '394.53', '390.75');
INSERT INTO `power_realtime` VALUES ('365', '1', '1641372000', '2669.47', '907.21', '887.19', '875.07', '746.30', '258.76', '229.40', '258.15', '0.9804', '0.9187', '0.9212', '0.9642', '2976.19', '2979.17', '2978.03', '196.91', '220.91', '229.45', '225.40', '382.92', '397.90', '386.68');
INSERT INTO `power_realtime` VALUES ('366', '1', '1641372300', '2345.06', '831.54', '740.73', '772.79', '505.65', '172.07', '159.28', '174.29', '0.9437', '0.9815', '0.9577', '0.9295', '2984.37', '2986.05', '2967.35', '197.80', '220.90', '223.04', '221.06', '391.97', '382.80', '396.60');
INSERT INTO `power_realtime` VALUES ('367', '1', '1641372600', '2215.61', '762.42', '720.17', '733.03', '890.80', '307.74', '291.16', '291.90', '0.9990', '0.9406', '0.9416', '0.9161', '2952.37', '2959.83', '2966.47', '198.52', '229.85', '228.11', '225.85', '389.40', '390.97', '387.48');
INSERT INTO `power_realtime` VALUES ('368', '1', '1641372900', '2392.78', '842.15', '778.87', '771.76', '584.89', '195.83', '186.34', '202.73', '0.9724', '0.9288', '0.9397', '0.9862', '2980.88', '2962.55', '2954.57', '196.88', '227.30', '224.49', '227.82', '383.81', '399.72', '388.86');
INSERT INTO `power_realtime` VALUES ('369', '1', '1641373200', '2920.30', '977.09', '929.38', '1013.83', '883.88', '309.93', '282.01', '291.93', '0.9495', '0.9086', '0.9626', '0.9207', '2961.48', '2977.56', '2974.50', '198.86', '225.68', '223.21', '227.69', '390.29', '396.85', '387.31');
INSERT INTO `power_realtime` VALUES ('370', '1', '1641373500', '1840.37', '640.31', '597.58', '602.48', '844.21', '291.09', '265.53', '287.59', '0.9094', '0.9229', '0.9140', '0.9237', '2997.61', '2979.47', '2966.47', '196.74', '224.53', '224.73', '228.57', '381.29', '381.00', '395.26');
INSERT INTO `power_realtime` VALUES ('371', '1', '1641373800', '2506.94', '854.35', '791.88', '860.72', '851.08', '292.10', '275.66', '283.32', '0.9438', '0.9936', '0.9122', '0.9624', '2990.15', '2980.04', '2984.61', '197.75', '222.95', '221.15', '220.64', '398.45', '380.57', '399.20');
INSERT INTO `power_realtime` VALUES ('372', '1', '1641374100', '2808.15', '952.64', '893.48', '962.03', '677.55', '229.67', '224.63', '223.24', '0.9532', '0.9769', '0.9899', '0.9410', '2999.62', '2977.45', '2962.71', '197.30', '223.28', '221.60', '220.86', '396.74', '384.00', '393.52');
INSERT INTO `power_realtime` VALUES ('373', '1', '1641374400', '2406.08', '805.27', '781.67', '819.13', '562.24', '188.81', '173.89', '199.54', '0.9515', '0.9888', '0.9934', '0.9256', '2977.92', '2978.82', '2995.26', '199.93', '225.41', '220.10', '226.38', '394.34', '395.19', '386.41');
INSERT INTO `power_realtime` VALUES ('374', '1', '1641374700', '2158.98', '768.75', '674.35', '715.88', '869.17', '302.46', '276.35', '290.36', '0.9645', '0.9062', '0.9780', '0.9842', '2962.00', '2962.46', '2991.45', '198.04', '228.32', '223.98', '225.04', '390.74', '391.23', '399.66');
INSERT INTO `power_realtime` VALUES ('375', '1', '1641375000', '1556.09', '528.77', '487.89', '539.43', '506.80', '174.87', '163.14', '168.80', '0.9599', '0.9203', '0.9249', '0.9930', '2987.31', '2997.98', '2993.99', '197.76', '223.50', '227.80', '226.59', '391.05', '384.21', '397.42');
INSERT INTO `power_realtime` VALUES ('376', '1', '1641375300', '2270.29', '800.54', '752.04', '717.71', '975.45', '344.10', '318.03', '313.33', '0.9239', '0.9800', '0.9000', '0.9805', '2962.30', '2998.53', '2980.43', '199.28', '224.07', '223.63', '224.79', '397.40', '396.09', '388.83');
INSERT INTO `power_realtime` VALUES ('377', '1', '1641375600', '1818.05', '632.42', '605.02', '580.61', '682.17', '232.73', '214.32', '235.12', '0.9693', '0.9040', '0.9267', '0.9324', '2995.40', '2990.35', '2983.15', '198.60', '223.13', '222.18', '222.85', '397.54', '384.21', '395.99');
INSERT INTO `power_realtime` VALUES ('378', '1', '1641375900', '2309.92', '776.30', '741.58', '792.04', '510.38', '184.51', '153.03', '172.85', '0.9527', '0.9694', '0.9531', '0.9696', '2983.79', '2950.38', '2974.79', '199.71', '226.26', '221.78', '222.79', '397.48', '385.40', '382.48');
INSERT INTO `power_realtime` VALUES ('379', '1', '1641376200', '1877.62', '641.07', '591.45', '645.11', '557.75', '193.47', '185.25', '179.02', '0.9730', '0.9936', '0.9661', '0.9358', '2957.33', '2982.90', '2968.20', '199.78', '224.42', '223.23', '223.94', '387.87', '399.71', '397.84');
INSERT INTO `power_realtime` VALUES ('380', '1', '1641376500', '2576.27', '884.90', '818.96', '872.41', '960.23', '322.18', '305.02', '333.03', '0.9310', '0.9254', '0.9353', '0.9842', '2973.83', '2981.26', '2975.31', '199.33', '226.77', '227.56', '225.32', '384.39', '388.35', '391.09');
INSERT INTO `power_realtime` VALUES ('381', '1', '1641376800', '1882.28', '677.36', '605.21', '599.71', '802.77', '276.30', '262.03', '264.44', '0.9425', '0.9395', '0.9559', '0.9489', '2979.96', '2950.20', '2956.09', '196.74', '226.36', '221.63', '223.32', '399.04', '397.38', '380.28');
INSERT INTO `power_realtime` VALUES ('382', '1', '1641377100', '2338.21', '823.02', '752.61', '762.58', '777.71', '274.50', '246.29', '256.92', '0.9261', '0.9930', '0.9100', '0.9074', '2989.21', '2998.76', '2968.12', '199.88', '226.49', '222.72', '227.73', '383.38', '396.43', '396.21');
INSERT INTO `power_realtime` VALUES ('383', '1', '1641377400', '2436.71', '835.83', '788.19', '812.69', '990.70', '331.68', '325.52', '333.51', '0.9183', '0.9543', '0.9735', '0.9055', '2981.22', '2952.65', '2998.67', '199.17', '221.02', '227.57', '227.29', '395.34', '381.63', '386.50');
INSERT INTO `power_realtime` VALUES ('384', '1', '1641377700', '1985.49', '685.89', '636.20', '663.39', '631.06', '220.03', '191.43', '219.60', '0.9136', '0.9447', '0.9628', '0.9058', '2997.73', '2978.86', '2974.91', '196.78', '228.63', '224.72', '229.82', '399.13', '394.12', '390.93');
INSERT INTO `power_realtime` VALUES ('385', '1', '1641378000', '2954.48', '1009.74', '982.46', '962.28', '618.09', '213.36', '199.04', '205.69', '0.9786', '0.9538', '0.9397', '0.9540', '2998.19', '2963.32', '2953.56', '198.94', '228.33', '220.36', '221.79', '391.81', '388.89', '380.71');
INSERT INTO `power_realtime` VALUES ('386', '1', '1641378300', '2675.04', '929.48', '862.75', '882.81', '808.46', '281.47', '250.67', '276.32', '0.9550', '0.9907', '0.9829', '0.9162', '2992.99', '2986.00', '2989.45', '199.60', '222.11', '227.51', '227.90', '382.07', '394.65', '392.77');
INSERT INTO `power_realtime` VALUES ('387', '1', '1641378600', '1739.13', '617.45', '575.27', '546.41', '900.82', '317.53', '297.02', '286.27', '0.9333', '0.9191', '0.9763', '0.9419', '2994.65', '2995.04', '2972.42', '199.54', '229.92', '227.26', '223.22', '384.58', '392.45', '385.94');
INSERT INTO `power_realtime` VALUES ('388', '1', '1641378900', '1533.73', '519.46', '492.52', '521.75', '803.09', '277.37', '247.75', '277.97', '0.9648', '0.9977', '0.9700', '0.9365', '2966.61', '2994.46', '2954.54', '196.98', '222.41', '227.15', '227.60', '398.50', '390.75', '397.84');
INSERT INTO `power_realtime` VALUES ('389', '1', '1641379200', '2042.55', '712.30', '631.22', '699.03', '935.67', '321.03', '297.18', '317.45', '0.9670', '0.9993', '0.9340', '0.9946', '2955.92', '2976.75', '2964.20', '199.34', '228.23', '227.02', '226.23', '390.94', '385.15', '390.71');
INSERT INTO `power_realtime` VALUES ('390', '1', '1641379500', '1853.25', '620.05', '579.93', '653.27', '729.30', '258.01', '223.14', '248.15', '0.9787', '0.9247', '0.9486', '0.9465', '2969.74', '2953.75', '2970.23', '197.68', '224.77', '226.72', '229.23', '384.84', '384.79', '380.49');
INSERT INTO `power_realtime` VALUES ('391', '1', '1641379800', '1723.90', '597.89', '533.12', '592.89', '939.93', '330.27', '309.42', '300.24', '0.9295', '0.9503', '0.9560', '0.9038', '2996.87', '2965.55', '2968.21', '196.70', '224.33', '221.57', '228.92', '396.59', '381.91', '386.24');
INSERT INTO `power_realtime` VALUES ('392', '1', '1641380100', '2587.45', '862.97', '836.73', '887.75', '845.27', '300.38', '274.12', '270.77', '0.9089', '0.9567', '0.9426', '0.9612', '2983.23', '2978.40', '2962.35', '198.99', '221.90', '222.49', '224.79', '381.30', '398.04', '397.14');
INSERT INTO `power_realtime` VALUES ('393', '1', '1641380400', '1506.90', '507.82', '465.18', '533.90', '907.16', '312.71', '283.99', '310.46', '0.9453', '0.9790', '0.9207', '0.9139', '2996.00', '2968.61', '2959.47', '197.39', '225.47', '226.53', '223.31', '383.20', '399.33', '390.53');
INSERT INTO `power_realtime` VALUES ('394', '1', '1641380700', '2337.97', '824.62', '771.80', '741.55', '582.54', '210.77', '186.10', '185.68', '0.9459', '0.9959', '0.9400', '0.9904', '2953.28', '2979.81', '2977.24', '199.08', '226.05', '220.80', '223.33', '395.05', '393.54', '388.56');
INSERT INTO `power_realtime` VALUES ('395', '1', '1641381000', '2708.74', '946.54', '884.93', '877.27', '641.82', '222.67', '212.01', '207.14', '0.9919', '0.9382', '0.9797', '0.9690', '2956.19', '2986.36', '2996.41', '197.58', '221.05', '228.84', '226.67', '383.59', '384.32', '390.98');
INSERT INTO `power_realtime` VALUES ('396', '1', '1641381300', '2388.35', '826.74', '759.86', '801.75', '607.74', '216.70', '192.98', '198.06', '0.9432', '0.9402', '0.9515', '0.9586', '2986.87', '2995.56', '2956.73', '199.34', '222.85', '222.77', '228.90', '398.28', '382.32', '389.37');
INSERT INTO `power_realtime` VALUES ('397', '1', '1641381600', '1688.49', '575.68', '542.51', '570.29', '760.76', '273.16', '241.18', '246.43', '0.9687', '0.9916', '0.9822', '0.9607', '2980.32', '2976.00', '2958.29', '197.73', '222.94', '227.06', '226.41', '387.66', '399.03', '391.86');
INSERT INTO `power_realtime` VALUES ('398', '1', '1641381900', '2722.56', '913.67', '904.26', '904.64', '567.03', '189.97', '174.68', '202.39', '0.9955', '0.9587', '0.9434', '0.9089', '2988.90', '2958.75', '2984.24', '198.66', '221.56', '221.20', '222.58', '381.31', '397.54', '388.87');
INSERT INTO `power_realtime` VALUES ('399', '1', '1641382200', '2138.18', '717.26', '668.84', '752.09', '874.44', '305.61', '279.36', '289.47', '0.9552', '0.9452', '0.9542', '0.9896', '2987.20', '2971.88', '2957.29', '198.97', '223.79', '227.91', '229.21', '396.49', '384.02', '388.16');
INSERT INTO `power_realtime` VALUES ('400', '1', '1641382500', '1838.13', '646.44', '571.33', '620.37', '788.56', '275.96', '262.68', '249.91', '0.9951', '0.9456', '0.9978', '0.9939', '2960.23', '2987.91', '2981.01', '196.97', '224.12', '221.76', '228.06', '395.91', '396.02', '382.13');
INSERT INTO `power_realtime` VALUES ('401', '1', '1641382800', '2214.56', '783.16', '716.21', '715.19', '785.71', '262.52', '242.53', '280.66', '0.9315', '0.9126', '0.9726', '0.9288', '2981.00', '2986.76', '2997.83', '199.07', '224.32', '229.44', '222.11', '397.55', '396.94', '382.46');
INSERT INTO `power_realtime` VALUES ('402', '1', '1641383100', '2539.72', '891.78', '836.41', '811.54', '843.32', '284.29', '275.07', '283.97', '0.9280', '0.9098', '0.9302', '0.9284', '2963.59', '2965.05', '2968.46', '198.58', '222.85', '227.82', '227.19', '399.29', '382.06', '385.31');
INSERT INTO `power_realtime` VALUES ('403', '1', '1641383400', '2384.50', '827.56', '747.79', '809.15', '669.12', '241.51', '206.33', '221.28', '0.9088', '0.9621', '0.9521', '0.9541', '2974.71', '2955.48', '2992.94', '197.82', '228.19', '229.35', '221.07', '388.63', '398.74', '395.99');
INSERT INTO `power_realtime` VALUES ('404', '1', '1641383700', '2273.50', '771.41', '743.98', '758.12', '989.92', '335.84', '312.13', '341.95', '0.9448', '0.9326', '0.9683', '0.9557', '2951.66', '2957.14', '2950.48', '197.62', '224.03', '226.12', '229.83', '383.73', '382.82', '384.27');
INSERT INTO `power_realtime` VALUES ('405', '1', '1641384000', '2232.22', '756.27', '734.72', '741.23', '818.65', '275.84', '257.67', '285.14', '0.9928', '0.9629', '0.9361', '0.9782', '2955.73', '2970.05', '2985.28', '197.21', '220.45', '224.06', '220.03', '393.29', '394.52', '380.71');
INSERT INTO `power_realtime` VALUES ('406', '1', '1641384300', '2437.90', '824.51', '797.02', '816.38', '653.42', '228.07', '200.40', '224.95', '0.9166', '0.9022', '0.9720', '0.9543', '2989.10', '2973.95', '2956.87', '197.61', '222.13', '227.56', '229.58', '392.24', '380.16', '380.40');
INSERT INTO `power_realtime` VALUES ('407', '1', '1641384600', '2851.30', '964.96', '932.10', '954.23', '676.66', '239.92', '205.71', '231.03', '0.9792', '0.9267', '0.9590', '0.9043', '2969.24', '2992.71', '2957.69', '198.11', '223.23', '221.75', '220.69', '385.57', '391.14', '393.63');
INSERT INTO `power_realtime` VALUES ('408', '1', '1641384900', '2481.42', '873.88', '803.12', '804.42', '713.90', '253.61', '236.39', '223.90', '0.9627', '0.9051', '0.9482', '0.9851', '2987.93', '2992.34', '2976.64', '199.37', '227.13', '225.24', '224.72', '395.50', '398.33', '392.59');
INSERT INTO `power_realtime` VALUES ('409', '1', '1641385200', '1819.58', '615.28', '567.73', '636.58', '982.04', '338.09', '321.92', '322.03', '0.9528', '0.9147', '0.9208', '0.9861', '2982.30', '2970.91', '2955.72', '196.97', '229.61', '220.24', '221.12', '396.64', '388.77', '390.03');
INSERT INTO `power_realtime` VALUES ('410', '1', '1641385500', '1972.86', '673.68', '617.36', '681.82', '504.93', '180.60', '164.42', '159.91', '0.9088', '0.9341', '0.9901', '0.9549', '2963.05', '2964.85', '2997.28', '197.42', '224.65', '229.17', '220.80', '380.14', '382.33', '389.49');
INSERT INTO `power_realtime` VALUES ('411', '1', '1641385800', '2629.90', '895.47', '839.74', '894.69', '500.44', '175.32', '148.58', '176.54', '0.9397', '0.9541', '0.9921', '0.9590', '2979.37', '2965.86', '2982.17', '199.25', '224.26', '227.86', '228.55', '391.15', '398.31', '386.90');
INSERT INTO `power_realtime` VALUES ('412', '1', '1641386100', '2704.61', '904.11', '884.50', '916.01', '547.51', '196.58', '166.61', '184.32', '0.9127', '0.9436', '0.9446', '0.9497', '2952.32', '2967.92', '2953.90', '197.59', '226.12', '224.74', '229.35', '393.90', '396.32', '380.89');
INSERT INTO `power_realtime` VALUES ('413', '1', '1641386400', '2324.83', '799.94', '732.13', '792.76', '924.41', '328.05', '305.43', '290.93', '0.9339', '0.9846', '0.9397', '0.9802', '2977.35', '2993.53', '2961.03', '198.29', '226.96', '223.03', '229.28', '396.07', '392.05', '383.28');
INSERT INTO `power_realtime` VALUES ('414', '1', '1641386700', '1764.57', '616.09', '545.54', '602.94', '669.67', '237.65', '212.70', '219.32', '0.9681', '0.9612', '0.9888', '0.9612', '2982.89', '2982.36', '2979.23', '197.52', '223.99', '229.26', '224.12', '387.53', '386.84', '392.26');
INSERT INTO `power_realtime` VALUES ('415', '1', '1641387000', '2458.41', '849.16', '819.26', '789.99', '656.43', '220.44', '200.55', '235.45', '0.9986', '0.9297', '0.9410', '0.9928', '2985.60', '2964.80', '2955.82', '197.72', '222.48', '225.86', '226.14', '399.66', '389.39', '398.80');
INSERT INTO `power_realtime` VALUES ('416', '1', '1641387300', '2887.20', '966.32', '936.19', '984.69', '787.35', '264.71', '247.65', '275.00', '0.9703', '0.9364', '0.9675', '0.9096', '2953.24', '2986.55', '2983.42', '197.81', '224.08', '228.78', '224.22', '389.00', '390.50', '381.49');
INSERT INTO `power_realtime` VALUES ('417', '1', '1641387600', '1882.88', '659.29', '593.23', '630.36', '812.66', '284.38', '254.98', '273.30', '0.9131', '0.9629', '0.9280', '0.9012', '2974.22', '2998.54', '2964.82', '198.01', '227.92', '222.49', '221.44', '393.34', '394.96', '387.02');
INSERT INTO `power_realtime` VALUES ('418', '1', '1641387900', '1769.26', '620.57', '567.25', '581.44', '746.74', '268.52', '244.93', '233.30', '0.9065', '0.9850', '0.9229', '0.9375', '2987.78', '2979.93', '2979.65', '197.19', '225.03', '224.53', '220.78', '380.03', '380.49', '391.68');
INSERT INTO `power_realtime` VALUES ('419', '1', '1641388200', '2233.55', '758.04', '710.45', '765.06', '910.24', '315.07', '294.08', '301.09', '0.9146', '0.9135', '0.9788', '0.9215', '2950.98', '2969.37', '2953.03', '196.87', '226.01', '220.39', '220.83', '384.25', '381.14', '395.03');
INSERT INTO `power_realtime` VALUES ('420', '1', '1641388500', '1910.75', '640.72', '589.48', '680.56', '753.62', '258.72', '236.60', '258.31', '0.9056', '0.9613', '0.9205', '0.9275', '2958.18', '2992.25', '2959.38', '197.88', '222.02', '225.99', '221.21', '380.31', '381.86', '389.13');
INSERT INTO `power_realtime` VALUES ('421', '1', '1641388800', '1859.81', '631.14', '616.08', '612.59', '826.25', '280.57', '275.05', '270.64', '0.9578', '0.9315', '0.9467', '0.9474', '2985.10', '2989.04', '2968.50', '199.01', '220.56', '220.41', '220.99', '381.13', '382.15', '395.75');
INSERT INTO `power_realtime` VALUES ('422', '1', '1641389100', '2416.74', '808.48', '757.98', '850.27', '540.03', '191.90', '161.46', '186.67', '0.9563', '0.9650', '0.9489', '0.9685', '2953.49', '2971.16', '2958.41', '199.31', '229.72', '225.21', '222.93', '399.53', '399.94', '390.38');
INSERT INTO `power_realtime` VALUES ('423', '1', '1641389400', '2325.24', '820.90', '767.72', '736.63', '740.97', '257.12', '243.45', '240.40', '0.9899', '0.9075', '0.9959', '0.9424', '2953.43', '2957.91', '2977.81', '196.69', '227.41', '228.72', '221.64', '391.39', '381.68', '394.46');
INSERT INTO `power_realtime` VALUES ('424', '1', '1641389700', '1570.38', '526.19', '473.65', '570.54', '543.62', '187.11', '175.74', '180.77', '0.9824', '0.9662', '0.9506', '0.9720', '2968.18', '2978.62', '2992.49', '198.12', '226.62', '224.15', '225.60', '392.58', '381.54', '397.34');
INSERT INTO `power_realtime` VALUES ('425', '1', '1641390000', '2475.08', '836.19', '792.10', '846.79', '903.42', '302.03', '281.69', '319.70', '0.9143', '0.9172', '0.9832', '0.9497', '2972.19', '2960.61', '2993.31', '198.39', '222.11', '229.54', '229.66', '381.94', '391.38', '386.05');
INSERT INTO `power_realtime` VALUES ('426', '1', '1641390300', '1862.94', '622.60', '591.67', '648.67', '500.19', '177.33', '160.89', '161.96', '0.9326', '0.9052', '0.9102', '0.9158', '2965.12', '2963.68', '2978.62', '197.85', '220.63', '224.75', '228.60', '388.04', '383.67', '394.51');
INSERT INTO `power_realtime` VALUES ('427', '1', '1641390600', '1943.85', '670.43', '621.09', '652.34', '682.19', '229.15', '215.65', '237.40', '0.9914', '0.9343', '0.9047', '0.9814', '2964.68', '2967.38', '2951.99', '198.38', '222.80', '226.75', '220.94', '391.66', '392.15', '394.42');
INSERT INTO `power_realtime` VALUES ('428', '1', '1641390900', '2541.19', '879.10', '799.72', '862.36', '974.68', '325.30', '313.06', '336.32', '0.9222', '0.9995', '0.9065', '0.9640', '2957.67', '2967.14', '2995.84', '197.45', '223.31', '228.59', '227.88', '395.24', '399.22', '397.20');
INSERT INTO `power_realtime` VALUES ('429', '1', '1641391200', '1851.41', '661.81', '615.79', '573.81', '989.25', '338.77', '322.20', '328.28', '0.9987', '0.9338', '0.9976', '0.9274', '2953.23', '2990.11', '2993.47', '199.78', '224.37', '220.23', '222.74', '398.15', '385.42', '380.62');
INSERT INTO `power_realtime` VALUES ('430', '1', '1641391500', '2107.72', '729.39', '680.78', '697.55', '981.08', '332.11', '308.62', '340.35', '0.9365', '0.9660', '0.9066', '0.9924', '2992.84', '2950.64', '2976.68', '197.38', '227.29', '220.66', '223.95', '390.19', '384.35', '394.90');
INSERT INTO `power_realtime` VALUES ('431', '1', '1641391800', '2810.27', '967.42', '899.98', '942.86', '789.77', '280.41', '257.34', '252.02', '0.9494', '0.9784', '0.9654', '0.9957', '2950.92', '2979.65', '2972.05', '198.85', '227.44', '220.07', '227.02', '396.58', '396.50', '381.02');
INSERT INTO `power_realtime` VALUES ('432', '1', '1641392100', '2084.92', '722.84', '688.18', '673.90', '966.60', '327.03', '310.51', '329.06', '0.9825', '0.9403', '0.9564', '0.9169', '2954.78', '2980.62', '2957.99', '197.39', '229.60', '229.27', '220.11', '395.48', '387.11', '388.52');
INSERT INTO `power_realtime` VALUES ('433', '1', '1641392400', '2242.43', '760.47', '736.75', '745.22', '535.78', '186.83', '174.26', '174.69', '0.9410', '0.9600', '0.9663', '0.9750', '2966.06', '2988.35', '2975.35', '197.94', '223.23', '229.55', '222.75', '383.25', '387.15', '392.27');
INSERT INTO `power_realtime` VALUES ('434', '1', '1641392700', '2227.86', '779.69', '722.88', '725.29', '560.59', '187.06', '169.71', '203.82', '0.9475', '0.9504', '0.9976', '0.9055', '2995.49', '2984.85', '2957.29', '199.48', '220.25', '221.57', '227.61', '384.48', '391.91', '395.76');
INSERT INTO `power_realtime` VALUES ('435', '1', '1641393000', '2378.64', '797.19', '744.60', '836.85', '986.63', '337.80', '311.08', '337.74', '0.9840', '0.9393', '0.9843', '0.9816', '2970.18', '2959.33', '2959.40', '196.75', '222.87', '224.90', '222.53', '391.71', '389.35', '394.28');
INSERT INTO `power_realtime` VALUES ('436', '1', '1641393300', '1746.87', '603.35', '565.57', '577.95', '613.46', '207.85', '199.85', '205.75', '0.9022', '0.9780', '0.9142', '0.9198', '2987.03', '2986.77', '2978.48', '198.86', '223.71', '221.62', '221.98', '395.07', '389.49', '393.43');
INSERT INTO `power_realtime` VALUES ('437', '1', '1641393600', '1688.10', '587.80', '561.78', '538.52', '504.01', '172.02', '157.65', '174.33', '0.9314', '0.9051', '0.9716', '0.9298', '2967.44', '2991.68', '2997.72', '197.45', '227.18', '227.86', '226.48', '384.16', '387.62', '397.83');
INSERT INTO `power_realtime` VALUES ('438', '1', '1641393900', '1975.29', '702.79', '628.57', '643.92', '676.06', '227.89', '212.77', '235.40', '0.9573', '0.9142', '0.9894', '0.9179', '2977.14', '2960.53', '2988.06', '197.77', '227.95', '225.58', '222.14', '393.10', '396.99', '380.73');
INSERT INTO `power_realtime` VALUES ('439', '1', '1641394200', '2861.87', '993.01', '930.12', '938.75', '534.56', '178.95', '174.28', '181.34', '0.9094', '0.9469', '0.9325', '0.9396', '2991.26', '2967.83', '2979.30', '198.41', '220.56', '224.02', '223.88', '395.80', '391.76', '398.32');
INSERT INTO `power_realtime` VALUES ('440', '1', '1641394500', '1792.92', '615.52', '555.11', '622.29', '694.96', '247.61', '212.85', '234.50', '0.9604', '0.9916', '0.9252', '0.9143', '2967.51', '2986.87', '2990.52', '196.77', '223.38', '226.01', '221.48', '380.82', '387.71', '382.48');
INSERT INTO `power_realtime` VALUES ('441', '1', '1641394800', '1847.75', '655.33', '582.26', '610.17', '617.91', '209.07', '192.03', '216.82', '0.9200', '0.9116', '0.9876', '0.9704', '2991.01', '2967.40', '2978.01', '197.12', '229.88', '227.88', '220.43', '384.89', '397.20', '391.99');
INSERT INTO `power_realtime` VALUES ('442', '1', '1641395100', '2990.66', '1008.92', '955.99', '1025.75', '823.96', '291.98', '264.78', '267.19', '0.9926', '0.9519', '0.9564', '0.9776', '2971.62', '2977.68', '2969.15', '196.67', '221.40', '224.68', '227.68', '380.52', '385.11', '386.36');
INSERT INTO `power_realtime` VALUES ('443', '1', '1641395400', '2309.88', '811.88', '728.43', '769.57', '882.93', '314.18', '287.35', '281.41', '0.9658', '0.9888', '0.9369', '0.9440', '2959.51', '2978.85', '2953.30', '198.63', '227.11', '222.72', '226.54', '396.28', '385.21', '386.34');
INSERT INTO `power_realtime` VALUES ('444', '1', '1641395700', '2637.01', '925.52', '836.22', '875.28', '877.17', '311.62', '285.79', '279.76', '0.9014', '0.9787', '0.9606', '0.9143', '2996.44', '2974.54', '2996.06', '197.40', '220.07', '221.03', '225.25', '398.66', '390.84', '383.00');
INSERT INTO `power_realtime` VALUES ('445', '1', '1641396000', '2761.00', '922.84', '901.69', '936.47', '620.34', '223.04', '187.26', '210.04', '0.9184', '0.9449', '0.9132', '0.9960', '2989.44', '2958.05', '2979.71', '198.45', '221.66', '221.16', '229.67', '381.18', '389.76', '390.99');
INSERT INTO `power_realtime` VALUES ('446', '1', '1641396300', '2381.95', '825.08', '776.62', '780.25', '574.20', '197.43', '183.67', '193.10', '0.9794', '0.9063', '0.9463', '0.9658', '2979.87', '2963.99', '2952.48', '198.67', '221.52', '220.56', '222.74', '390.64', '391.22', '393.05');
INSERT INTO `power_realtime` VALUES ('447', '1', '1641396600', '2990.52', '1037.26', '982.76', '970.50', '644.29', '217.31', '211.32', '215.66', '0.9291', '0.9001', '0.9923', '0.9691', '2984.12', '2970.26', '2990.22', '198.01', '225.91', '229.59', '221.12', '390.76', '393.53', '390.61');
INSERT INTO `power_realtime` VALUES ('448', '1', '1641396900', '2008.61', '713.92', '647.96', '646.73', '852.72', '297.49', '265.02', '290.21', '0.9751', '0.9837', '0.9709', '0.9199', '2953.18', '2989.71', '2988.15', '196.92', '223.41', '225.41', '223.55', '381.49', '381.83', '380.08');
INSERT INTO `power_realtime` VALUES ('449', '1', '1641397200', '1786.29', '605.38', '588.44', '592.48', '780.96', '279.59', '253.18', '248.18', '0.9550', '0.9201', '0.9015', '0.9366', '2985.82', '2989.57', '2955.72', '199.77', '225.16', '227.09', '225.07', '396.48', '389.86', '396.36');
INSERT INTO `power_realtime` VALUES ('450', '1', '1641397500', '1918.51', '689.38', '597.65', '631.48', '648.80', '230.91', '215.06', '202.83', '0.9965', '0.9533', '0.9196', '0.9130', '2985.36', '2979.54', '2985.97', '198.66', '224.42', '226.42', '227.15', '392.74', '384.93', '383.40');
INSERT INTO `power_realtime` VALUES ('451', '1', '1641397800', '1823.32', '634.10', '569.77', '619.44', '947.04', '318.71', '308.03', '320.30', '0.9483', '0.9648', '0.9448', '0.9209', '2972.23', '2967.29', '2960.75', '198.56', '220.38', '227.38', '225.52', '384.80', '382.91', '387.32');
INSERT INTO `power_realtime` VALUES ('452', '1', '1641398100', '2110.63', '714.89', '661.51', '734.23', '670.51', '227.44', '213.38', '229.69', '0.9418', '0.9762', '0.9485', '0.9736', '2953.69', '2992.57', '2985.62', '199.40', '220.83', '223.68', '224.92', '380.64', '389.17', '399.76');
INSERT INTO `power_realtime` VALUES ('453', '1', '1641398400', '1967.25', '669.94', '628.69', '668.62', '906.01', '304.02', '288.62', '313.37', '0.9322', '0.9162', '0.9346', '0.9440', '2959.09', '2968.33', '2972.83', '197.83', '229.93', '229.24', '223.91', '388.98', '393.09', '388.44');
INSERT INTO `power_realtime` VALUES ('454', '1', '1641398700', '2090.21', '728.65', '665.74', '695.83', '815.03', '274.40', '253.52', '287.11', '0.9698', '0.9108', '0.9722', '0.9340', '2972.33', '2978.93', '2957.40', '196.86', '229.26', '220.19', '222.13', '386.01', '396.25', '397.90');
INSERT INTO `power_realtime` VALUES ('455', '1', '1641399000', '2615.91', '880.92', '824.59', '910.40', '914.99', '320.42', '302.97', '291.60', '0.9607', '0.9794', '0.9975', '0.9252', '2984.61', '2962.12', '2990.47', '199.12', '223.74', '228.79', '227.86', '395.81', '389.93', '386.41');
INSERT INTO `power_realtime` VALUES ('456', '1', '1641399300', '2017.43', '676.12', '646.48', '694.82', '504.79', '179.40', '151.09', '174.30', '0.9930', '0.9285', '0.9489', '0.9109', '2998.36', '2982.78', '2954.98', '199.21', '227.58', '220.51', '225.45', '390.98', '394.18', '384.85');
INSERT INTO `power_realtime` VALUES ('457', '1', '1641399600', '2076.71', '696.78', '654.53', '725.40', '600.20', '215.93', '196.39', '187.88', '0.9366', '0.9267', '0.9967', '0.9138', '2988.79', '2992.02', '2992.20', '198.37', '221.05', '224.35', '229.00', '399.86', '389.36', '399.98');
INSERT INTO `power_realtime` VALUES ('458', '1', '1641399900', '2781.88', '944.55', '927.21', '910.11', '842.98', '284.07', '261.32', '297.59', '0.9567', '0.9226', '0.9932', '0.9310', '2971.99', '2956.12', '2963.19', '198.68', '224.08', '223.86', '222.50', '392.76', '391.78', '398.19');
INSERT INTO `power_realtime` VALUES ('459', '1', '1641400200', '2853.17', '954.08', '903.31', '995.79', '523.86', '193.57', '170.83', '159.46', '0.9345', '0.9293', '0.9865', '0.9208', '2988.13', '2984.84', '2996.63', '199.05', '220.24', '222.16', '225.35', '393.15', '387.68', '396.27');
INSERT INTO `power_realtime` VALUES ('460', '1', '1641400500', '1563.11', '564.74', '506.27', '492.10', '613.76', '217.05', '190.86', '205.85', '0.9371', '0.9434', '0.9213', '0.9535', '2985.35', '2988.70', '2994.76', '199.67', '221.97', '228.82', '227.71', '399.78', '383.79', '392.99');
INSERT INTO `power_realtime` VALUES ('461', '1', '1641400800', '2088.49', '730.37', '672.32', '685.80', '530.37', '185.99', '171.03', '173.35', '0.9523', '0.9982', '0.9919', '0.9881', '2983.94', '2999.41', '2981.00', '197.46', '226.80', '228.60', '221.04', '392.76', '399.24', '399.47');
INSERT INTO `power_realtime` VALUES ('462', '1', '1641401100', '2312.94', '783.04', '769.75', '760.15', '777.67', '261.46', '244.90', '271.31', '0.9708', '0.9669', '0.9059', '0.9146', '2961.69', '2996.92', '2976.95', '199.97', '224.22', '223.97', '226.11', '390.36', '391.61', '387.61');
INSERT INTO `power_realtime` VALUES ('463', '1', '1641401400', '2289.17', '789.19', '758.35', '741.63', '584.77', '211.27', '177.00', '196.50', '0.9898', '0.9264', '0.9792', '0.9091', '2979.78', '2950.76', '2993.25', '198.42', '223.00', '222.24', '224.02', '384.38', '399.89', '393.42');
INSERT INTO `power_realtime` VALUES ('464', '1', '1641401700', '2470.05', '844.11', '807.26', '818.68', '737.56', '258.67', '227.37', '251.52', '0.9003', '0.9803', '0.9981', '0.9962', '2964.28', '2951.79', '2957.05', '199.38', '220.85', '226.54', '224.33', '389.18', '398.86', '387.26');
INSERT INTO `power_realtime` VALUES ('465', '1', '1641402000', '2326.94', '794.99', '766.22', '765.73', '941.25', '314.97', '299.10', '327.18', '0.9265', '0.9055', '0.9599', '0.9892', '2971.06', '2983.97', '2979.92', '198.50', '220.33', '226.44', '229.47', '394.29', '393.44', '394.60');
INSERT INTO `power_realtime` VALUES ('466', '1', '1641402300', '1592.33', '562.21', '520.45', '509.67', '775.48', '270.01', '242.36', '263.12', '0.9965', '0.9392', '0.9426', '0.9941', '2991.95', '2964.00', '2992.79', '199.12', '228.65', '228.48', '225.33', '391.78', '396.67', '399.27');
INSERT INTO `power_realtime` VALUES ('467', '1', '1641402600', '2591.77', '894.69', '851.46', '845.62', '604.69', '217.01', '195.07', '192.60', '0.9469', '0.9591', '0.9443', '0.9095', '2957.49', '2959.11', '2989.98', '199.80', '223.27', '220.77', '224.46', '397.68', '393.11', '387.02');
INSERT INTO `power_realtime` VALUES ('468', '1', '1641402900', '2967.67', '996.54', '977.07', '994.06', '685.81', '238.22', '214.34', '233.24', '0.9930', '0.9326', '0.9930', '0.9373', '2955.43', '2981.08', '2981.39', '198.11', '220.47', '227.12', '221.23', '382.33', '388.12', '389.16');
INSERT INTO `power_realtime` VALUES ('469', '1', '1641403200', '1544.20', '550.04', '501.88', '492.28', '673.08', '228.23', '205.52', '239.33', '0.9377', '0.9140', '0.9373', '0.9339', '2966.41', '2996.40', '2951.95', '196.67', '220.38', '226.87', '226.75', '385.89', '385.20', '385.44');
INSERT INTO `power_realtime` VALUES ('470', '1', '1641403500', '2138.61', '733.57', '675.41', '729.63', '755.17', '270.58', '235.24', '249.35', '0.9441', '0.9597', '0.9043', '0.9852', '2966.51', '2989.62', '2968.55', '197.89', '229.04', '224.67', '225.74', '384.86', '396.59', '381.42');
INSERT INTO `power_realtime` VALUES ('471', '1', '1641403800', '1790.01', '642.53', '579.34', '568.14', '773.76', '261.98', '253.65', '258.12', '0.9521', '0.9046', '0.9423', '0.9705', '2962.56', '2968.07', '2959.37', '199.90', '226.33', '222.18', '228.27', '390.48', '396.97', '388.42');
INSERT INTO `power_realtime` VALUES ('472', '1', '1641404100', '1651.43', '566.80', '546.70', '537.92', '864.46', '291.86', '282.75', '289.85', '0.9909', '0.9033', '0.9588', '0.9020', '2959.27', '2952.79', '2965.95', '197.12', '227.49', '228.74', '225.50', '383.25', '397.53', '384.00');
INSERT INTO `power_realtime` VALUES ('473', '1', '1641404400', '2175.16', '759.89', '705.37', '709.90', '931.24', '312.41', '292.55', '326.27', '0.9173', '0.9792', '0.9157', '0.9792', '2957.44', '2960.94', '2987.02', '199.06', '225.97', '222.15', '220.94', '396.69', '385.88', '397.73');
INSERT INTO `power_realtime` VALUES ('474', '1', '1641404700', '1715.32', '601.74', '535.69', '577.88', '613.25', '215.81', '184.60', '212.85', '0.9956', '0.9558', '0.9534', '0.9868', '2950.19', '2950.87', '2993.67', '199.18', '226.52', '223.33', '226.96', '380.20', '388.23', '390.43');
INSERT INTO `power_realtime` VALUES ('475', '1', '1641405000', '2274.23', '761.04', '737.12', '776.06', '829.68', '284.48', '265.84', '279.36', '0.9316', '0.9536', '0.9883', '0.9865', '2968.79', '2971.22', '2997.80', '199.42', '228.82', '229.15', '220.62', '394.18', '382.43', '395.54');
INSERT INTO `power_realtime` VALUES ('476', '1', '1641405300', '2332.01', '801.73', '761.59', '768.69', '992.25', '336.75', '326.47', '329.02', '0.9821', '0.9311', '0.9534', '0.9092', '2981.53', '2980.10', '2951.00', '198.88', '225.33', '227.20', '222.93', '380.33', '385.34', '388.74');
INSERT INTO `power_realtime` VALUES ('477', '1', '1641405600', '2520.21', '853.49', '792.29', '874.43', '557.79', '187.67', '184.79', '185.32', '0.9735', '0.9331', '0.9461', '0.9480', '2968.33', '2980.63', '2987.86', '198.83', '220.22', '224.00', '221.76', '387.64', '393.45', '385.94');
INSERT INTO `power_realtime` VALUES ('478', '1', '1641405900', '1831.59', '627.45', '574.80', '629.33', '753.85', '269.89', '238.15', '245.80', '0.9897', '0.9689', '0.9911', '0.9759', '2979.80', '2952.65', '2957.05', '196.69', '221.34', '224.21', '220.62', '397.79', '394.62', '380.96');
INSERT INTO `power_realtime` VALUES ('479', '1', '1641406200', '1598.88', '554.96', '494.38', '549.54', '549.00', '184.92', '174.72', '189.36', '0.9234', '0.9958', '0.9361', '0.9711', '2993.28', '2950.28', '2954.86', '199.51', '222.62', '223.12', '223.53', '385.14', '388.16', '382.20');
INSERT INTO `power_realtime` VALUES ('480', '1', '1641406500', '2624.85', '910.50', '836.68', '877.67', '756.50', '261.96', '235.82', '258.72', '0.9290', '0.9155', '0.9652', '0.9320', '2998.63', '2977.94', '2989.74', '198.09', '220.81', '227.59', '220.16', '383.49', '392.58', '392.25');
INSERT INTO `power_realtime` VALUES ('481', '1', '1641406800', '2105.67', '748.51', '672.06', '685.10', '555.00', '202.10', '166.78', '186.13', '0.9676', '0.9085', '0.9403', '0.9868', '2984.80', '2956.40', '2961.79', '198.46', '228.05', '222.25', '225.01', '396.82', '384.10', '396.33');
INSERT INTO `power_realtime` VALUES ('482', '1', '1641407100', '2357.96', '789.05', '762.54', '806.37', '683.03', '234.02', '208.32', '240.69', '0.9978', '0.9357', '0.9681', '0.9703', '2952.91', '2993.14', '2989.54', '198.38', '220.24', '227.59', '220.48', '382.23', '394.58', '383.76');
INSERT INTO `power_realtime` VALUES ('483', '1', '1641407400', '2838.13', '977.55', '908.93', '951.65', '615.31', '209.66', '188.12', '217.52', '0.9361', '0.9195', '0.9336', '0.9355', '2953.93', '2979.34', '2956.39', '199.68', '220.30', '224.84', '225.17', '391.78', '384.86', '382.38');
INSERT INTO `power_realtime` VALUES ('484', '1', '1641407700', '1529.78', '520.98', '480.38', '528.41', '658.44', '238.29', '205.22', '214.93', '0.9949', '0.9919', '0.9476', '0.9015', '2988.53', '2998.00', '2981.38', '198.65', '225.98', '229.59', '226.53', '385.01', '399.13', '397.97');
INSERT INTO `power_realtime` VALUES ('485', '1', '1641408000', '2972.03', '1015.27', '952.44', '1004.31', '610.83', '208.30', '193.26', '209.27', '0.9938', '0.9491', '0.9181', '0.9031', '2963.06', '2995.05', '2993.60', '197.01', '223.01', '220.96', '220.39', '395.84', '396.94', '399.94');
INSERT INTO `power_realtime` VALUES ('486', '1', '1641408300', '2007.46', '677.37', '620.34', '709.75', '917.56', '317.25', '301.31', '299.00', '0.9401', '0.9942', '0.9802', '0.9109', '2969.55', '2986.99', '2956.36', '198.35', '226.56', '227.10', '229.71', '396.66', '392.76', '380.76');
INSERT INTO `power_realtime` VALUES ('487', '1', '1641408600', '1744.15', '629.92', '553.32', '560.91', '614.46', '210.36', '189.43', '214.67', '0.9863', '0.9714', '1.0000', '0.9234', '2998.60', '2955.31', '2995.99', '199.01', '227.01', '229.84', '229.99', '387.88', '387.72', '399.41');
INSERT INTO `power_realtime` VALUES ('488', '1', '1641408900', '2750.97', '956.90', '912.51', '881.56', '797.90', '266.94', '255.28', '275.67', '0.9873', '0.9064', '0.9123', '0.9033', '2952.08', '2958.79', '2991.53', '198.51', '220.35', '221.58', '220.54', '394.10', '395.36', '398.99');
INSERT INTO `power_realtime` VALUES ('489', '1', '1641409200', '1639.82', '555.19', '519.23', '565.40', '876.31', '308.83', '278.87', '288.61', '0.9110', '0.9580', '0.9514', '0.9342', '2997.91', '2981.04', '2974.57', '199.80', '228.13', '226.97', '227.76', '387.53', '381.65', '385.43');
INSERT INTO `power_realtime` VALUES ('490', '1', '1641409500', '2431.88', '848.95', '783.04', '799.88', '958.13', '326.23', '310.53', '321.37', '0.9916', '0.9645', '0.9969', '0.9110', '2951.87', '2971.08', '2974.28', '199.23', '228.18', '228.78', '220.31', '385.42', '380.32', '387.65');
INSERT INTO `power_realtime` VALUES ('491', '1', '1641409800', '2458.18', '862.47', '778.98', '816.74', '906.74', '318.87', '284.32', '303.55', '0.9630', '0.9295', '0.9740', '0.9510', '2980.97', '2979.85', '2970.14', '198.87', '223.97', '223.80', '224.78', '382.00', '386.88', '390.04');
INSERT INTO `power_realtime` VALUES ('492', '1', '1641410100', '2507.13', '860.92', '801.17', '845.04', '847.56', '300.31', '262.57', '284.67', '0.9646', '0.9396', '0.9314', '0.9182', '2999.72', '2995.84', '2984.91', '197.38', '228.27', '228.33', '225.95', '395.05', '399.30', '395.60');
INSERT INTO `power_realtime` VALUES ('493', '1', '1641410400', '2503.33', '868.95', '816.11', '818.27', '744.93', '250.54', '246.99', '247.40', '0.9780', '0.9324', '0.9549', '0.9972', '2975.08', '2987.24', '2962.38', '198.80', '225.70', '225.95', '226.70', '394.65', '399.24', '381.95');
INSERT INTO `power_realtime` VALUES ('494', '1', '1641410700', '1683.31', '562.70', '542.12', '578.48', '577.03', '200.49', '180.97', '195.57', '0.9291', '0.9539', '0.9748', '0.9252', '2966.73', '2967.88', '2978.58', '199.70', '228.25', '221.28', '229.66', '395.25', '396.10', '393.83');
INSERT INTO `power_realtime` VALUES ('495', '1', '1641411000', '2524.29', '853.50', '793.07', '877.72', '625.92', '224.28', '190.22', '211.42', '0.9706', '0.9385', '0.9841', '0.9040', '2958.02', '2967.61', '2981.84', '198.89', '228.43', '223.02', '225.61', '393.17', '385.94', '393.51');
INSERT INTO `power_realtime` VALUES ('496', '1', '1641411300', '1581.86', '538.63', '493.55', '549.68', '966.58', '341.72', '303.62', '321.23', '0.9595', '0.9307', '0.9991', '0.9562', '2978.66', '2957.02', '2995.40', '198.79', '226.65', '227.50', '222.60', '399.11', '389.33', '385.22');
INSERT INTO `power_realtime` VALUES ('497', '1', '1641411600', '2401.94', '839.28', '799.80', '762.86', '883.99', '301.04', '291.37', '291.58', '0.9411', '0.9359', '0.9725', '0.9694', '2982.74', '2999.45', '2997.23', '198.69', '221.21', '220.90', '224.63', '389.96', '385.83', '381.81');
INSERT INTO `power_realtime` VALUES ('498', '1', '1641411900', '1790.93', '624.99', '595.36', '570.58', '670.28', '233.24', '204.58', '232.46', '0.9673', '0.9371', '0.9043', '0.9854', '2976.18', '2981.49', '2964.86', '199.07', '223.58', '222.37', '229.27', '385.31', '398.40', '389.85');
INSERT INTO `power_realtime` VALUES ('499', '1', '1641412200', '1955.89', '689.95', '623.08', '642.86', '555.34', '198.83', '175.04', '181.47', '0.9986', '0.9560', '0.9898', '0.9391', '2984.32', '2955.87', '2987.86', '197.74', '225.20', '224.69', '220.67', '382.64', '398.55', '395.42');
INSERT INTO `power_realtime` VALUES ('500', '1', '1641412500', '1864.30', '648.40', '615.70', '600.21', '903.69', '317.29', '286.65', '299.75', '0.9673', '0.9510', '0.9013', '0.9328', '2965.47', '2968.00', '2958.30', '198.35', '227.93', '229.88', '226.76', '399.99', '382.49', '394.74');
INSERT INTO `power_realtime` VALUES ('501', '1', '1641412800', '2619.33', '903.46', '845.28', '870.58', '767.85', '274.04', '237.03', '256.79', '0.9239', '0.9576', '0.9115', '0.9492', '2957.12', '2979.85', '2998.93', '197.05', '226.16', '228.08', '228.12', '397.25', '389.52', '393.17');
INSERT INTO `power_realtime` VALUES ('502', '1', '1641413100', '2702.99', '918.04', '877.92', '907.02', '924.20', '310.99', '299.95', '313.25', '0.9362', '0.9603', '0.9410', '0.9563', '2990.89', '2951.21', '2980.62', '197.14', '225.95', '226.54', '220.60', '395.74', '397.21', '392.16');
INSERT INTO `power_realtime` VALUES ('503', '1', '1641413400', '2605.00', '875.32', '844.03', '885.65', '630.92', '226.05', '198.59', '206.29', '0.9697', '0.9620', '0.9448', '0.9426', '2977.83', '2990.49', '2964.42', '197.22', '224.64', '222.29', '224.06', '391.90', '392.99', '396.65');
INSERT INTO `power_realtime` VALUES ('504', '1', '1641413700', '1630.03', '562.19', '516.24', '551.60', '539.78', '193.33', '164.26', '182.19', '0.9483', '0.9765', '0.9456', '0.9403', '2999.11', '2992.77', '2979.99', '199.80', '223.38', '228.18', '226.25', '383.14', '388.26', '385.31');
INSERT INTO `power_realtime` VALUES ('505', '1', '1641414000', '2560.26', '890.34', '826.31', '843.61', '963.19', '336.89', '313.85', '312.45', '0.9712', '0.9090', '0.9720', '0.9492', '2987.39', '2994.32', '2970.09', '196.86', '225.07', '225.48', '222.82', '393.75', '390.22', '392.62');
INSERT INTO `power_realtime` VALUES ('506', '1', '1641414300', '2844.05', '986.85', '899.96', '957.23', '546.45', '185.39', '169.71', '191.35', '0.9482', '0.9202', '0.9703', '0.9587', '2951.55', '2987.83', '2991.68', '197.70', '221.12', '228.93', '223.12', '384.99', '397.09', '395.45');
INSERT INTO `power_realtime` VALUES ('507', '1', '1641414600', '1584.22', '539.65', '493.49', '551.08', '821.10', '277.68', '263.29', '280.13', '0.9158', '0.9800', '0.9311', '0.9937', '2982.51', '2963.32', '2966.61', '197.85', '222.26', '220.77', '225.38', '396.80', '394.84', '397.14');
INSERT INTO `power_realtime` VALUES ('508', '1', '1641414900', '2312.11', '772.20', '729.01', '810.90', '619.87', '212.62', '200.42', '206.83', '0.9976', '0.9110', '0.9991', '0.9610', '2979.40', '2964.29', '2969.85', '197.19', '221.56', '229.72', '225.11', '398.54', '387.89', '399.55');
INSERT INTO `power_realtime` VALUES ('509', '1', '1641415200', '2855.22', '997.12', '946.05', '912.05', '916.15', '306.99', '289.42', '319.74', '0.9941', '0.9066', '0.9234', '0.9682', '2954.71', '2978.56', '2980.28', '199.72', '221.34', '228.62', '226.57', '383.54', '392.64', '387.64');
INSERT INTO `power_realtime` VALUES ('510', '1', '1641415500', '2537.45', '859.39', '815.59', '862.47', '811.51', '270.57', '268.82', '272.11', '0.9055', '0.9684', '0.9565', '0.9109', '2963.15', '2967.43', '2998.36', '197.27', '220.56', '220.38', '229.44', '385.78', '380.55', '382.24');
INSERT INTO `power_realtime` VALUES ('511', '1', '1641415800', '1991.43', '676.81', '649.14', '665.48', '633.74', '226.20', '200.90', '206.64', '0.9310', '0.9602', '0.9154', '0.9849', '2952.58', '2975.92', '2956.18', '197.65', '224.74', '226.83', '220.31', '387.87', '397.71', '384.58');
INSERT INTO `power_realtime` VALUES ('512', '1', '1641416100', '2012.50', '718.48', '629.67', '664.35', '924.61', '322.84', '305.22', '296.56', '0.9279', '0.9081', '0.9857', '0.9747', '2955.86', '2960.35', '2959.46', '198.20', '227.16', '227.72', '222.98', '387.30', '389.38', '381.20');
INSERT INTO `power_realtime` VALUES ('513', '1', '1641416400', '2142.78', '730.77', '692.99', '719.03', '991.52', '343.67', '327.96', '319.89', '0.9690', '0.9932', '0.9776', '0.9963', '2980.38', '2968.17', '2956.38', '198.21', '227.24', '228.94', '221.12', '392.26', '382.23', '399.07');
INSERT INTO `power_realtime` VALUES ('514', '1', '1641416700', '2043.01', '725.25', '648.32', '669.45', '670.62', '239.38', '217.28', '213.96', '0.9976', '0.9887', '0.9261', '0.9393', '2957.15', '2957.88', '2976.48', '197.59', '221.07', '228.76', '222.65', '389.70', '381.94', '399.97');
INSERT INTO `power_realtime` VALUES ('515', '1', '1641417000', '2687.27', '933.74', '894.19', '859.34', '500.04', '186.10', '148.58', '165.36', '0.9530', '0.9752', '0.9759', '0.9474', '2983.40', '2954.60', '2973.02', '199.18', '227.60', '229.14', '227.03', '386.81', '391.92', '398.04');
INSERT INTO `power_realtime` VALUES ('516', '1', '1641417300', '2003.54', '712.35', '661.26', '629.94', '631.17', '210.53', '190.43', '230.21', '0.9190', '0.9432', '0.9923', '0.9089', '2982.06', '2999.38', '2984.20', '196.91', '225.05', '226.32', '224.14', '391.90', '387.86', '397.10');
INSERT INTO `power_realtime` VALUES ('517', '1', '1641417600', '1779.60', '639.01', '546.96', '593.64', '513.80', '175.61', '155.16', '183.03', '0.9386', '0.9456', '0.9080', '0.9985', '2958.31', '2967.52', '2953.85', '198.85', '222.92', '229.61', '227.07', '392.90', '394.23', '393.39');
INSERT INTO `power_realtime` VALUES ('518', '1', '1641417900', '2460.00', '847.73', '797.98', '814.30', '676.21', '231.72', '210.46', '234.03', '0.9395', '0.9010', '0.9344', '0.9066', '2956.74', '2952.93', '2968.23', '199.94', '227.10', '221.42', '220.72', '390.58', '381.96', '395.58');
INSERT INTO `power_realtime` VALUES ('519', '1', '1641418200', '2375.30', '827.03', '745.34', '802.93', '785.30', '277.47', '247.55', '260.27', '0.9221', '0.9769', '0.9517', '0.9321', '2964.10', '2991.94', '2975.10', '199.81', '229.23', '223.43', '223.56', '389.19', '381.41', '396.55');
INSERT INTO `power_realtime` VALUES ('520', '1', '1641418500', '2969.83', '1030.81', '953.65', '985.38', '613.62', '207.27', '192.91', '213.43', '0.9819', '0.9849', '0.9341', '0.9831', '2960.35', '2981.54', '2952.02', '197.70', '224.68', '224.34', '221.10', '380.01', '381.62', '391.73');
INSERT INTO `power_realtime` VALUES ('521', '1', '1641418800', '2728.28', '956.06', '860.42', '911.80', '560.26', '190.50', '175.71', '194.04', '0.9660', '0.9187', '0.9658', '0.9315', '2996.52', '2982.55', '2984.16', '197.50', '229.36', '223.75', '227.32', '392.80', '385.70', '395.05');
INSERT INTO `power_realtime` VALUES ('522', '1', '1641419100', '2745.26', '934.24', '904.04', '906.97', '970.67', '335.20', '307.04', '328.43', '0.9996', '0.9381', '0.9663', '0.9083', '2969.83', '2988.88', '2997.71', '199.86', '220.85', '224.01', '223.20', '396.40', '392.66', '397.33');
INSERT INTO `power_realtime` VALUES ('523', '1', '1641419400', '2234.94', '761.48', '718.59', '754.87', '676.72', '231.67', '224.47', '220.58', '0.9674', '0.9668', '0.9628', '0.9977', '2976.87', '2989.57', '2972.07', '196.81', '226.62', '227.65', '221.03', '383.22', '398.47', '382.52');
INSERT INTO `power_realtime` VALUES ('524', '1', '1641419700', '2240.24', '756.80', '712.01', '771.43', '932.75', '327.99', '305.54', '299.22', '0.9886', '0.9160', '0.9287', '0.9958', '2952.05', '2999.85', '2974.61', '198.65', '229.61', '222.68', '227.97', '392.14', '393.65', '384.07');
INSERT INTO `power_realtime` VALUES ('525', '1', '1641420000', '2872.86', '987.93', '939.90', '945.03', '755.94', '253.48', '250.19', '252.26', '0.9917', '0.9783', '0.9420', '0.9394', '2992.93', '2992.36', '2973.21', '198.80', '220.46', '220.18', '223.87', '391.85', '380.70', '388.59');
INSERT INTO `power_realtime` VALUES ('526', '1', '1641420300', '2596.64', '890.19', '840.41', '866.04', '589.72', '204.51', '181.35', '203.86', '0.9684', '0.9481', '0.9217', '0.9885', '2985.09', '2968.94', '2986.40', '197.14', '225.15', '220.29', '224.89', '380.01', '383.02', '394.27');
INSERT INTO `power_realtime` VALUES ('527', '1', '1641420600', '1857.10', '625.96', '607.58', '623.56', '698.11', '239.23', '215.43', '243.44', '0.9717', '0.9271', '0.9525', '0.9534', '2967.91', '2977.41', '2977.27', '199.04', '227.49', '222.04', '227.76', '394.81', '386.71', '390.19');
INSERT INTO `power_realtime` VALUES ('528', '1', '1641420900', '1760.17', '590.37', '549.20', '620.60', '765.35', '268.16', '242.53', '254.65', '0.9164', '0.9543', '0.9293', '0.9049', '2978.01', '2996.39', '2985.88', '199.38', '227.48', '220.56', '228.37', '382.82', '388.73', '396.91');
INSERT INTO `power_realtime` VALUES ('529', '1', '1641421200', '1512.14', '512.44', '502.64', '497.05', '820.57', '287.80', '264.50', '268.27', '0.9426', '0.9696', '0.9264', '0.9814', '2970.26', '2984.75', '2975.81', '198.02', '229.07', '221.57', '223.05', '381.80', '398.40', '380.79');
INSERT INTO `power_realtime` VALUES ('530', '1', '1641421500', '2951.65', '1031.17', '966.63', '953.85', '830.12', '286.39', '266.65', '277.08', '0.9165', '0.9713', '0.9340', '0.9229', '2995.92', '2970.15', '2993.39', '199.42', '224.12', '228.36', '221.78', '398.40', '395.06', '382.91');
INSERT INTO `power_realtime` VALUES ('531', '1', '1641421800', '2732.59', '941.29', '899.79', '891.51', '601.59', '219.95', '192.66', '188.98', '0.9632', '0.9652', '0.9999', '0.9082', '2965.09', '2984.19', '2953.45', '196.84', '223.97', '229.17', '229.35', '388.73', '381.98', '388.94');
INSERT INTO `power_realtime` VALUES ('532', '1', '1641422100', '2054.10', '705.73', '637.07', '711.30', '522.93', '186.56', '165.69', '170.67', '0.9580', '0.9229', '0.9668', '0.9522', '2984.71', '2988.74', '2972.67', '198.34', '225.16', '225.31', '223.08', '385.52', '396.09', '388.60');
INSERT INTO `power_realtime` VALUES ('533', '1', '1641422400', '2780.63', '968.84', '883.46', '928.32', '617.52', '224.33', '198.74', '194.45', '0.9446', '0.9734', '0.9129', '0.9400', '2995.17', '2980.58', '2971.24', '196.91', '222.08', '220.14', '224.10', '396.81', '394.35', '392.70');
INSERT INTO `power_realtime` VALUES ('534', '1', '1641422700', '1851.31', '628.64', '610.58', '612.08', '931.90', '323.47', '302.75', '305.67', '0.9942', '0.9412', '0.9734', '0.9211', '2977.29', '2957.94', '2955.37', '197.81', '226.61', '227.99', '224.10', '390.70', '380.52', '391.49');
INSERT INTO `power_realtime` VALUES ('535', '1', '1641423000', '2043.23', '685.36', '655.30', '702.58', '886.22', '315.17', '293.78', '277.27', '0.9855', '0.9190', '0.9554', '0.9756', '2967.25', '2984.41', '2976.94', '198.48', '222.86', '228.92', '229.59', '395.96', '381.32', '391.47');
INSERT INTO `power_realtime` VALUES ('536', '1', '1641423300', '2428.29', '829.24', '801.71', '797.33', '909.91', '313.45', '291.75', '304.70', '0.9472', '0.9201', '0.9509', '0.9801', '2950.64', '2991.43', '2992.84', '197.93', '224.16', '221.01', '222.24', '391.26', '387.53', '397.19');
INSERT INTO `power_realtime` VALUES ('537', '1', '1641423600', '2247.32', '762.08', '716.77', '768.46', '954.64', '319.95', '315.36', '319.33', '0.9873', '0.9994', '0.9014', '0.9601', '2956.54', '2972.00', '2964.89', '198.62', '229.49', '225.69', '226.20', '385.09', '384.66', '391.55');
INSERT INTO `power_realtime` VALUES ('538', '1', '1641423900', '2919.28', '1013.97', '957.58', '947.72', '825.00', '283.57', '274.63', '266.80', '0.9198', '0.9607', '0.9831', '0.9965', '2990.54', '2983.29', '2951.53', '199.37', '227.38', '224.14', '221.55', '384.89', '388.04', '391.56');
INSERT INTO `power_realtime` VALUES ('539', '1', '1641424200', '1505.72', '520.31', '473.33', '512.08', '693.54', '235.57', '227.18', '230.79', '0.9953', '0.9753', '0.9470', '0.9844', '2980.23', '2996.60', '2995.38', '198.14', '227.31', '223.44', '227.30', '397.20', '390.07', '397.06');
INSERT INTO `power_realtime` VALUES ('540', '1', '1641424500', '2163.78', '763.26', '687.75', '712.77', '671.25', '237.70', '213.93', '219.62', '0.9484', '0.9387', '0.9803', '0.9929', '2958.27', '2957.55', '2955.61', '199.11', '221.38', '220.75', '227.29', '390.83', '381.25', '387.03');
INSERT INTO `power_realtime` VALUES ('541', '1', '1641424800', '2442.16', '856.78', '768.82', '816.56', '887.05', '298.07', '279.95', '309.02', '0.9919', '0.9668', '0.9459', '0.9690', '2977.90', '2999.56', '2970.86', '196.69', '222.58', '221.25', '228.85', '391.80', '383.38', '392.66');
INSERT INTO `power_realtime` VALUES ('542', '1', '1641425100', '2706.20', '915.84', '870.98', '919.38', '690.39', '247.87', '215.33', '227.19', '0.9095', '0.9027', '0.9010', '0.9550', '2991.16', '2987.55', '2968.13', '198.38', '221.08', '221.81', '225.59', '383.09', '390.92', '387.04');
INSERT INTO `power_realtime` VALUES ('543', '1', '1641425400', '2018.21', '697.00', '671.44', '649.76', '830.16', '291.10', '259.96', '279.10', '0.9372', '0.9499', '0.9074', '0.9458', '2974.52', '2958.03', '2954.10', '197.09', '225.14', '227.12', '224.02', '392.60', '396.86', '399.55');
INSERT INTO `power_realtime` VALUES ('544', '1', '1641425700', '1949.61', '680.90', '616.42', '652.29', '779.55', '266.05', '251.20', '262.30', '0.9632', '0.9855', '0.9118', '0.9102', '2956.33', '2965.48', '2989.24', '197.03', '220.07', '227.68', '227.49', '390.72', '381.04', '387.73');
INSERT INTO `power_realtime` VALUES ('545', '1', '1641426000', '2560.26', '885.77', '845.12', '829.38', '771.92', '264.73', '248.04', '259.15', '0.9316', '0.9214', '0.9996', '0.9271', '2989.12', '2993.19', '2950.70', '199.73', '226.03', '221.02', '220.72', '383.05', '382.84', '381.21');
INSERT INTO `power_realtime` VALUES ('546', '1', '1641426300', '2649.27', '906.10', '869.13', '874.03', '585.64', '211.35', '186.57', '187.72', '0.9967', '0.9852', '0.9137', '0.9522', '2964.39', '2989.79', '2987.99', '197.76', '224.04', '226.96', '223.97', '395.59', '385.45', '390.65');
INSERT INTO `power_realtime` VALUES ('547', '1', '1641426600', '2859.64', '961.45', '952.43', '945.75', '667.23', '223.25', '208.55', '235.44', '0.9475', '0.9798', '0.9743', '0.9251', '2989.67', '2950.69', '2965.90', '199.85', '228.59', '226.39', '227.70', '387.58', '386.80', '390.41');
INSERT INTO `power_realtime` VALUES ('548', '1', '1641426900', '1806.26', '616.72', '562.72', '626.82', '811.57', '274.60', '265.19', '271.78', '0.9007', '0.9498', '0.9385', '0.9647', '2987.54', '2975.74', '2971.01', '199.62', '226.11', '229.64', '226.15', '392.72', '381.15', '395.65');
INSERT INTO `power_realtime` VALUES ('549', '1', '1641427200', '2093.81', '698.33', '648.07', '747.41', '825.21', '293.53', '271.22', '260.46', '0.9545', '0.9401', '0.9059', '0.9598', '2982.26', '2952.02', '2983.17', '196.84', '229.12', '225.91', '221.82', '381.14', '387.00', '383.97');
INSERT INTO `power_realtime` VALUES ('550', '1', '1641427500', '2897.06', '979.02', '933.86', '984.17', '884.92', '295.25', '276.99', '312.67', '0.9918', '0.9711', '0.9962', '0.9683', '2963.83', '2981.91', '2979.74', '199.21', '228.72', '228.73', '222.40', '393.55', '389.73', '397.84');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `root` int(11) NOT NULL COMMENT '0用户1系统管理员',
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '1');
INSERT INTO `user` VALUES ('2', 'user', '111111', '0');

-- ----------------------------
-- Table structure for util
-- ----------------------------
DROP TABLE IF EXISTS `util`;
CREATE TABLE `util` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `variableAttributeName` varchar(255) DEFAULT NULL,
  `variableAttributeNum` varchar(255) DEFAULT NULL,
  `state` int(255) DEFAULT NULL COMMENT '0正在使用1弃用',
  `dataTime` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of util
-- ----------------------------
INSERT INTO `util` VALUES ('1', 'highPowerRate', '0.9389', '1', '1641225600');
INSERT INTO `util` VALUES ('2', 'lowPowerRate', '	\r\n0.6198', '1', '1641225600');
INSERT INTO `util` VALUES ('3', 'midPowerRate', '	\r\n0.3716', '1', '1641225600');
