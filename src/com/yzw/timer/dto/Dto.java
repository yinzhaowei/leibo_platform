//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yzw.timer.dto;

import com.yzw.timer.parse.Parse;
import com.yzw.timer.util.CommonConstrants;
import com.yzw.timer.util.DateUtil;
import com.yzw.timer.util.JdbcUtil;
import com.yzw.timer.util.LogUtil;
import com.yzw.timer.vo.CarInfoVO;
import com.yzw.timer.vo.HistroyVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dto {
    public Dto() {
    }

    public int getHistoryCount() {
        int total = 0;
        Connection conn = null;
        PreparedStatement state = null;
        new ArrayList();
        String sql = "select COUNT(*)as total from " + CommonConstrants.history_table + "  order by XID desc limit 1 ";
        LogUtil.info("getHistoryCount sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                total = rs.getInt("total");
                LogUtil.info("历史信息库 total=" + total);
            }

            LogUtil.info("调用getHistoryCount查询数据库成功！");
        } catch (Exception var11) {
            LogUtil.debug("调用getHistoryCount异常" + var11.getMessage());
        } finally {
            JdbcUtil.release(rs, state, conn);
        }

        return total;
    }

    public int getCarInfoCount() {
        int total = 0;
        Connection conn = null;
        PreparedStatement state = null;
        new ArrayList();
        String sql = "select COUNT(*)as total from " + CommonConstrants.info_table + "  order by EV_ID desc limit 1 ";
        LogUtil.info("getCarInfoCount sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                total = rs.getInt("total");
                LogUtil.info("车辆信息库 total=" + total);
            }

            LogUtil.info("调用getCarInfoCount查询数据库成功！");
        } catch (Exception var11) {
            LogUtil.debug("调用getCarInfoCount异常" + var11.getMessage());
        } finally {
            JdbcUtil.release(rs, state, conn);
        }

        return total;
    }

    public List<HistroyVO> getHistoryData(String xid) {
        Connection conn = null;
        PreparedStatement state = null;
        String lastDay = DateUtil.getDate(0) + " 00:00:00";
        ArrayList result = new ArrayList();
        String sql = "select t1.*,t2.MOBILE_NUM as phone from " + CommonConstrants.history_table + " t1," + CommonConstrants.info_table + " t2 where t1.LAST_TIME >= \'" + lastDay + "\' AND t1.XID> " + xid + " and t1.EV_ID = t2.EV_ID order by t1.XID desc limit  " + CommonConstrants.limit;
        LogUtil.info("getHistoryData sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                new HistroyVO();
                HistroyVO e = Parse.parse_HistroyVO(rs);
                e.setTableName(CommonConstrants.curTable);
                result.add(e);
            }

            LogUtil.info("调用getHistoryData查询数据库成功！");
        } catch (Exception var12) {
            LogUtil.debug("调用getHistoryData异常" + var12.getMessage());
        } finally {
            JdbcUtil.release(rs, state, conn);
        }

        return result;
    }

    public List<CarInfoVO> getCarInfoData(String evId) {
        Connection conn = null;
        PreparedStatement state = null;
        ArrayList result = new ArrayList();
        String sql = "select * from " + CommonConstrants.info_table + " where EV_ID>" + evId + "   order by EV_ID desc limit  " + CommonConstrants.limit;
        LogUtil.info("getCarInfoData sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                new CarInfoVO();
                CarInfoVO e = Parse.parse_CarInfoVO(rs);
                result.add(e);
            }

            LogUtil.info("调用getCarInfoData查询数据库成功！");
        } catch (Exception var11) {
            LogUtil.debug("调用getCarInfoData异常" + var11.getMessage());
        } finally {
            JdbcUtil.release(rs, state, conn);
        }

        return result;
    }
}
