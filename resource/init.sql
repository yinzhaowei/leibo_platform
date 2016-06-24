/******��ʷ��¼��*********/
DROP TABLE IF EXISTS `leibo_history_table`;

CREATE TABLE `leibo_history_table` (
  `autoid` int(20) NOT NULL AUTO_INCREMENT,
  `history_table` varchar(50) DEFAULT NULL COMMENT '��ʷ��',
  `remark` varchar(255) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`autoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/******������Ϣ��*********/
DROP TABLE IF EXISTS `leibo_carinfo`;

CREATE TABLE `leibo_carinfo` (
  `autoid` int(20) NOT NULL AUTO_INCREMENT COMMENT 'autoid',
  `EV_ID` int(20) DEFAULT NULL COMMENT '����ID',
  `EV_NAME` varchar(255) DEFAULT NULL COMMENT '��������',
  `ERP_ID` varchar(255) DEFAULT NULL COMMENT 'ERP���',
  `EV_TYPE` int(8) DEFAULT NULL COMMENT '��������',
  `EV_NUM` varchar(20) DEFAULT NULL COMMENT '���ƺ�',
  `BT_ID` varchar(20) DEFAULT NULL COMMENT '��ر�־',
  `COMP_ID` varchar(255) DEFAULT NULL COMMENT '��˾ID',
  `MANUFCTUR` varchar(255) DEFAULT NULL COMMENT '��Ӧ��',
  `COMMENT` varchar(255) DEFAULT NULL COMMENT '��·����',
  `BATT_TYPE` varchar(255) DEFAULT NULL COMMENT '�������',
  `AC_TYPE` varchar(255) DEFAULT NULL COMMENT '�յ�Ʒ��',
  `MOBILE_NUM` varchar(12) DEFAULT NULL COMMENT '�ֻ���',
  `NSC` int(4) DEFAULT NULL COMMENT '�����ã�',
  `FIRST_USE` varchar(20) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`autoid`),
  KEY `EV_ID` (`EV_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/******ʵʱ��Ϣ��*********/
DROP TABLE IF EXISTS `leibo_realtime_info`;

CREATE TABLE `leibo_realtime_info` (
  `autoid` bigint(50) NOT NULL AUTO_INCREMENT COMMENT 'autoid',
  `XID` bigint(50) DEFAULT NULL COMMENT '�װ�ϵͳid',
  `EV_ID` int(20) DEFAULT NULL COMMENT '����ID',
  `ERR_CODE` int(10) DEFAULT NULL COMMENT '���ϴ��� ',
  `SPEED` double DEFAULT NULL COMMENT '�ٶ�',
  `VOLTAGE` double DEFAULT NULL COMMENT '���ص�ѹ',
  `VOLTAGEALL` double DEFAULT NULL COMMENT '����ܵ�ѹ',
  `CURRENTALL` double DEFAULT NULL COMMENT '����ܵ���',
  `GPS_LAT` decimal(10,6) DEFAULT NULL COMMENT '����',
  `GPS_LNG` decimal(10,6) DEFAULT NULL COMMENT 'ά��',
  `SOC` double DEFAULT NULL COMMENT 'SOCֵ',
  `RESISTANCE` double DEFAULT NULL COMMENT '��Ե����ֵ',
  `VOL_MAX` double DEFAULT NULL COMMENT '�����ѹ���ֵ',
  `VOL_MAX_POS` int(10) DEFAULT NULL COMMENT '�����ѹ���ֵ�ں�',
  `VOL_MAX_XIANG` int(10) DEFAULT NULL COMMENT '�����ѹ���ֵ���',
  `VOL_MIN` double DEFAULT NULL COMMENT '�����ѹ���ֵ',
  `VOL_MIN_POS` int(10) DEFAULT NULL COMMENT '�����ѹ���ֵ�ں�',
  `VOL_MIN_XIANG` int(10) DEFAULT NULL COMMENT '�����ѹ���ֵ���',
  `TEMPE_MAX` double DEFAULT NULL COMMENT '�����¶����',
  `TEMPE_MAX_POS` int(10) DEFAULT NULL COMMENT '�����¶���߽ں�',
  `TEMPE_MAX_XIANG` int(10) DEFAULT NULL COMMENT '�����¶�������',
  `TEMPE_MIN` double DEFAULT NULL COMMENT '�����¶����double',
  `TEMPE_MIN_POS` int(10) DEFAULT NULL COMMENT '�����¶���ͽں�',
  `TEMPE_MIN_XIANG` int(10) DEFAULT NULL COMMENT '�����¶�������',
  `LAST_TIME` timestamp NULL DEFAULT NULL COMMENT '����¼ʱ��',
  `DASH_ERR_CODE` int(10) DEFAULT NULL COMMENT '�Ǳ�������1',
  `DASH_ERR_CODE2` int(10) DEFAULT NULL COMMENT '�Ǳ�������2',
  `DASH_ERR_CODE3` int(10) DEFAULT NULL COMMENT '����',
  `DASH_ERR_CODE4` int(10) DEFAULT NULL COMMENT '����',
  `CREATETIME` datetime DEFAULT NULL COMMENT '�Ǽ�����',
  `VINCODE` varchar(30) DEFAULT NULL COMMENT 'VINCODE',
  `QIYEVIN` varchar(30) DEFAULT NULL COMMENT '��ҵvin',
  PRIMARY KEY (`autoid`),
  KEY `EV_ID` (`EV_ID`),
  KEY `XID` (`XID`),
  KEY `LAST_TIME` (`LAST_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `leibo_car_register`;

CREATE TABLE `leibo_car_register` (
  `autoid` int(8) NOT NULL AUTO_INCREMENT,
  `EV_ID` varchar(30) DEFAULT NULL COMMENT '��������ID',
  `flag` varchar(2) DEFAULT NULL COMMENT '��־',
  `remark` varchar(255) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`autoid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;