//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yzw.timer.util;

import com.yzw.timer.util.CommonConstrants;
import com.yzw.timer.util.DateUtil;
import com.yzw.timer.vo.CarInfoVO;
import com.yzw.timer.vo.HistroyVO;
import java.util.ArrayList;
import java.util.List;

public class ProcessSqlUtil {
    public ProcessSqlUtil() {
    }

    public static String getNewCount() {
        String remark = DateUtil.getCurrentMonth() + "��ʷ��";
        return "insert into " + CommonConstrants.leibo_history_table + " (history_table,remark) values (\'" + CommonConstrants.osa_history + DateUtil.getCurrentMonth() + "\',\'" + remark + "\')";
    }

    public static String getHistorySql(List<HistroyVO> voList) {
        StringBuffer bf = new StringBuffer();
        if(voList.size() <= 0) {
            return "";
        } else {
            new HistroyVO();
            HistroyVO i = (HistroyVO)voList.get(0);
            bf.append(i.toTHead());

            for(int var3 = voList.size() - 1; var3 >= 0; --var3) {
                bf.append(((HistroyVO)voList.get(var3)).toSql()).append(",");
            }

            return bf.toString().substring(0, bf.toString().length() - 1);
        }
    }

    public static String getCarInfoSql(List<CarInfoVO> voList) {
        StringBuffer bf = new StringBuffer();
        if(voList.size() <= 0) {
            return "";
        } else {
            CarInfoVO i = new CarInfoVO();
            bf.append(i.toTHead());

            for(int var3 = voList.size() - 1; var3 >= 0; --var3) {
                bf.append(((CarInfoVO)voList.get(var3)).toSql()).append(",");
            }

            return bf.toString().substring(0, bf.toString().length() - 1);
        }
    }

    public static String createTableByMonth() {
        String tableName = CommonConstrants.osa_history + DateUtil.getCurrentMonth();
        String sql = "CREATE TABLE " + tableName + " (\n" + "  `autoid` bigint(50) NOT NULL AUTO_INCREMENT COMMENT \'autoid\',\n" + "  `XID` bigint(50) DEFAULT NULL COMMENT \'�װ�ϵͳid\',\n" + "  `EV_ID` int(20) DEFAULT NULL COMMENT \'����ID\',\n" + "  `ERR_CODE` int(10) DEFAULT NULL COMMENT \'���ϴ��� \',\n" + "  `SPEED` double DEFAULT NULL COMMENT \'�ٶ�\',\n" + "  `VOLTAGE` double DEFAULT NULL COMMENT \'���ص�ѹ\',\n" + "  `VOLTAGEALL` double DEFAULT NULL COMMENT \'����ܵ�ѹ\',\n" + "  `CURRENTALL` double DEFAULT NULL COMMENT \'����ܵ���\',\n" + "  `GPS_LAT` decimal(10,6) DEFAULT NULL COMMENT \'����\',\n" + "  `GPS_LNG` decimal(10,6) DEFAULT NULL COMMENT \'ά��\',\n" + "  `SOC` double DEFAULT NULL COMMENT \'SOCֵ\',\n" + "  `RESISTANCE` double DEFAULT NULL COMMENT \'��Ե����ֵ\',\n" + "  `VOL_MAX` double DEFAULT NULL COMMENT \'�����ѹ���ֵ\',\n" + "  `VOL_MAX_POS` int(10) DEFAULT NULL COMMENT \'�����ѹ���ֵ�ں�\',\n" + "  `VOL_MAX_XIANG` int(10) DEFAULT NULL COMMENT \'�����ѹ���ֵ���\',\n" + "  `VOL_MIN` double DEFAULT NULL COMMENT \'�����ѹ���ֵ\',\n" + "  `VOL_MIN_POS` int(10) DEFAULT NULL COMMENT \'�����ѹ���ֵ�ں�\',\n" + "  `VOL_MIN_XIANG` int(10) DEFAULT NULL COMMENT \'�����ѹ���ֵ���\',\n" + "  `TEMPE_MAX` double DEFAULT NULL COMMENT \'�����¶����\',\n" + "  `TEMPE_MAX_POS` int(10) DEFAULT NULL COMMENT \'�����¶���߽ں�\',\n" + "  `TEMPE_MAX_XIANG` int(10) DEFAULT NULL COMMENT \'�����¶�������\',\n" + "  `TEMPE_MIN` double DEFAULT NULL COMMENT \'�����¶����double\',\n" + "  `TEMPE_MIN_POS` int(10) DEFAULT NULL COMMENT \'�����¶���ͽں�\',\n" + "  `TEMPE_MIN_XIANG` int(10) DEFAULT NULL COMMENT \'�����¶�������\',\n" + "  `LAST_TIME` timestamp NULL DEFAULT NULL COMMENT \'����¼ʱ��\',\n" + "  `DASH_ERR_CODE` int(10) DEFAULT NULL COMMENT \'�Ǳ�������1\',\n" + "  `DASH_ERR_CODE2` int(10) DEFAULT NULL COMMENT \'�Ǳ�������2\',\n" + "  `DASH_ERR_CODE3` int(10) DEFAULT NULL COMMENT \'����\',\n" + "  `DASH_ERR_CODE4` int(10) DEFAULT NULL COMMENT \'����\',\n" + "  `CREATETIME` varchar(20) DEFAULT NULL COMMENT \'�Ǽ�����\',\n" + "  `VINCODE` varchar(30) DEFAULT NULL COMMENT \'VINCODE\',\n" + "  `QIYEVIN` varchar(30) DEFAULT NULL COMMENT \'��ҵvin\',\n" + "  PRIMARY KEY (`autoid`),\n" + "  KEY `EV_ID` (`EV_ID`),\n" + "  KEY `XID` (`XID`),\n" + "  KEY `LAST_TIME` (`LAST_TIME`)\n" + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";
        return sql;
    }

    public static String delRealTimeInfo() {
        return "delete from " + CommonConstrants.leibo_realtime_info;
    }

    public static List<HistroyVO> handelVOS(List<HistroyVO> infoVOS, List<HistroyVO> infoVOS2) {
        ArrayList vos = new ArrayList();

        for(int i = 0; i < infoVOS.size(); ++i) {
            new HistroyVO();
            HistroyVO vo = (HistroyVO)infoVOS.get(i);
            vo.setCREATETIME(((HistroyVO)infoVOS2.get(i)).getLAST_TIME().replaceAll(":", "").replaceAll("-", "").replaceAll(" ", "").substring(0, 14));
            vos.add(vo);
        }

        return infoVOS;
    }
}
