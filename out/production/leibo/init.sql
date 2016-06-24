/******历史记录表*********/
DROP TABLE IF EXISTS `leibo_history_table`;

CREATE TABLE `leibo_history_table` (
  `autoid` int(20) NOT NULL AUTO_INCREMENT,
  `history_table` varchar(50) DEFAULT NULL COMMENT '历史表',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`autoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/******车辆信息表*********/
DROP TABLE IF EXISTS `leibo_carinfo`;

CREATE TABLE `leibo_carinfo` (
  `autoid` int(20) NOT NULL AUTO_INCREMENT COMMENT 'autoid',
  `EV_ID` int(20) DEFAULT NULL COMMENT '车辆ID',
  `EV_NAME` varchar(255) DEFAULT NULL COMMENT '车辆名称',
  `ERP_ID` varchar(255) DEFAULT NULL COMMENT 'ERP编号',
  `EV_TYPE` int(8) DEFAULT NULL COMMENT '车辆类型',
  `EV_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `BT_ID` varchar(20) DEFAULT NULL COMMENT '电池标志',
  `COMP_ID` varchar(255) DEFAULT NULL COMMENT '公司ID',
  `MANUFCTUR` varchar(255) DEFAULT NULL COMMENT '供应商',
  `COMMENT` varchar(255) DEFAULT NULL COMMENT '几路公交',
  `BATT_TYPE` varchar(255) DEFAULT NULL COMMENT '电池类型',
  `AC_TYPE` varchar(255) DEFAULT NULL COMMENT '空调品牌',
  `MOBILE_NUM` varchar(12) DEFAULT NULL COMMENT '手机号',
  `NSC` int(4) DEFAULT NULL COMMENT '（不用）',
  `FIRST_USE` varchar(20) DEFAULT NULL COMMENT '上线时间',
  PRIMARY KEY (`autoid`),
  KEY `EV_ID` (`EV_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/******实时信息表*********/
DROP TABLE IF EXISTS `leibo_realtime_info`;

CREATE TABLE `leibo_realtime_info` (
  `autoid` bigint(50) NOT NULL AUTO_INCREMENT COMMENT 'autoid',
  `XID` bigint(50) DEFAULT NULL COMMENT '雷柏系统id',
  `EV_ID` int(20) DEFAULT NULL COMMENT '车辆ID',
  `ERR_CODE` int(10) DEFAULT NULL COMMENT '故障代码 ',
  `SPEED` double DEFAULT NULL COMMENT '速度',
  `VOLTAGE` double DEFAULT NULL COMMENT '蓄电池电压',
  `VOLTAGEALL` double DEFAULT NULL COMMENT '电池总电压',
  `CURRENTALL` double DEFAULT NULL COMMENT '电池总电流',
  `GPS_LAT` decimal(10,6) DEFAULT NULL COMMENT '经度',
  `GPS_LNG` decimal(10,6) DEFAULT NULL COMMENT '维度',
  `SOC` double DEFAULT NULL COMMENT 'SOC值',
  `RESISTANCE` double DEFAULT NULL COMMENT '绝缘电阻值',
  `VOL_MAX` double DEFAULT NULL COMMENT '单体电压最高值',
  `VOL_MAX_POS` int(10) DEFAULT NULL COMMENT '单体电压最高值节号',
  `VOL_MAX_XIANG` int(10) DEFAULT NULL COMMENT '单体电压最高值箱号',
  `VOL_MIN` double DEFAULT NULL COMMENT '单体电压最低值',
  `VOL_MIN_POS` int(10) DEFAULT NULL COMMENT '单体电压最低值节号',
  `VOL_MIN_XIANG` int(10) DEFAULT NULL COMMENT '单体电压最低值箱号',
  `TEMPE_MAX` double DEFAULT NULL COMMENT '单体温度最高',
  `TEMPE_MAX_POS` int(10) DEFAULT NULL COMMENT '单体温度最高节号',
  `TEMPE_MAX_XIANG` int(10) DEFAULT NULL COMMENT '单体温度最高箱号',
  `TEMPE_MIN` double DEFAULT NULL COMMENT '单体温度最低double',
  `TEMPE_MIN_POS` int(10) DEFAULT NULL COMMENT '单体温度最低节号',
  `TEMPE_MIN_XIANG` int(10) DEFAULT NULL COMMENT '单体温度最低箱号',
  `LAST_TIME` timestamp NULL DEFAULT NULL COMMENT '最后记录时间',
  `DASH_ERR_CODE` int(10) DEFAULT NULL COMMENT '仪表错误代码1',
  `DASH_ERR_CODE2` int(10) DEFAULT NULL COMMENT '仪表错误代码2',
  `DASH_ERR_CODE3` int(10) DEFAULT NULL COMMENT '保留',
  `DASH_ERR_CODE4` int(10) DEFAULT NULL COMMENT '保留',
  `CREATETIME` datetime DEFAULT NULL COMMENT '登记日期',
  `VINCODE` varchar(30) DEFAULT NULL COMMENT 'VINCODE',
  `QIYEVIN` varchar(30) DEFAULT NULL COMMENT '企业vin',
  PRIMARY KEY (`autoid`),
  KEY `EV_ID` (`EV_ID`),
  KEY `XID` (`XID`),
  KEY `LAST_TIME` (`LAST_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `leibo_car_register`;

CREATE TABLE `leibo_car_register` (
  `autoid` int(8) NOT NULL AUTO_INCREMENT,
  `EV_ID` varchar(30) DEFAULT NULL COMMENT '车辆类型ID',
  `flag` varchar(2) DEFAULT NULL COMMENT '标志',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`autoid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;