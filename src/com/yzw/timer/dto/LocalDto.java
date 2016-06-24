//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yzw.timer.dto;

import com.yzw.timer.parse.Parse;
import com.yzw.timer.util.CommonConstrants;
import com.yzw.timer.util.DateUtil;
import com.yzw.timer.util.JdbcLocalUtil;
import com.yzw.timer.util.LogUtil;
import com.yzw.timer.vo.HistroyVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocalDto {
    public LocalDto() {
    }

    public static String getCarName(String EV_ID) {
        Connection conn = null;
        PreparedStatement state = null;
        String result = "";
        String sql = "select t1.MANUFCTUR from " + CommonConstrants.osa_carInfo + " t1  where  t1.EV_ID=\'" + EV_ID + "\' order by t1.autoid desc limit 1 ";
        LogUtil.info("getRealRegisterData sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcLocalUtil.getConnection();
            state = conn.prepareStatement(sql);

            for(rs = state.executeQuery(); rs.next(); result = rs.getString("MANUFCTUR")) {
                ;
            }

            LogUtil.info("调用getCarName查询数据库成功！");
        } catch (Exception var10) {
            LogUtil.debug("调用getCarName异常" + var10.getMessage());
        } finally {
            JdbcLocalUtil.release(rs, state, conn);
        }

        return result;
    }

    public static List<HistroyVO> getRealRegisterData() {
        Connection conn = null;
        PreparedStatement state = null;
        ArrayList result = new ArrayList();
        String sql = "select t1.* from " + CommonConstrants.leibo_realtime_info + " t1 LEFT JOIN leibo_car_register t2 ON t1.EV_ID=t2.EV_ID  where  t2.EV_ID is null limit 1 ";
        LogUtil.info("getRealRegisterData sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcLocalUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                new HistroyVO();
                HistroyVO e = Parse.parse_HistroyVO(rs);
                e.setTableName(CommonConstrants.leibo_realtime_info);
                result.add(e);
            }

            LogUtil.info("调用getRealRegisterData查询数据库成功！");
        } catch (Exception var9) {
            LogUtil.debug("调用getRealRegisterData异常" + var9.getMessage());
        } finally {
            JdbcLocalUtil.release(rs, state, conn);
        }

        return result;
    }

    public static List<HistroyVO> getRealTimeData1() {
        Connection conn = null;
        PreparedStatement state = null;
        ArrayList result = new ArrayList();
        String currDate = DateUtil.getDate(0) + " 00:00:00";
        String sql = "select * from  (select t1.*,t2.MOBILE_NUM as phone from " + CommonConstrants.curTable + " t1," + CommonConstrants.osa_carInfo + " t2 where t1.EV_ID=t2.EV_ID and t2.MANUFCTUR like\'%" + CommonConstrants.whereV + "%\' and t1.LAST_TIME >=\'" + currDate + "\' ORDER BY t1.autoid ASC ) a GROUP BY a.EV_ID  ";
        LogUtil.info("getRealTimeData sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcLocalUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                new HistroyVO();
                HistroyVO e = Parse.parse_HistroyVO(rs);
                e.setTableName(CommonConstrants.leibo_realtime_info);
                result.add(e);
            }

            LogUtil.info("调用getRealTimeData查询数据库成功！");
        } catch (Exception var10) {
            LogUtil.debug("调用getRealTimeData异常" + var10.getMessage());
        } finally {
            JdbcLocalUtil.release(rs, state, conn);
        }

        return result;
    }

    public static List<HistroyVO> getRealTimeData() {
        Connection conn = null;
        PreparedStatement state = null;
        ArrayList result = new ArrayList();
        String currDate = DateUtil.getDate(0) + " 00:00:00";
        String sql = "select * from  (select t1.* from " + CommonConstrants.curTable + " t1," + CommonConstrants.osa_carInfo + " t2 where t1.EV_ID=t2.EV_ID and t2.MANUFCTUR like\'%" + CommonConstrants.whereV + "%\' and t1.LAST_TIME >=\'" + currDate + "\' ORDER BY t1.autoid DESC ) a GROUP BY a.EV_ID  ";
        LogUtil.info("getRealTimeData sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcLocalUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                new HistroyVO();
                HistroyVO e = Parse.parse_HistroyVO(rs);
                e.setTableName(CommonConstrants.leibo_realtime_info);
                result.add(e);
            }

            LogUtil.info("调用getRealTimeData查询数据库成功！");
        } catch (Exception var10) {
            LogUtil.debug("调用getRealTimeData异常" + var10.getMessage());
        } finally {
            JdbcLocalUtil.release(rs, state, conn);
        }

        return result;
    }

    public static boolean isExistCurMonth(String table) {
        int total = 0;
        Connection conn = null;
        PreparedStatement state = null;
        String sql = "select COUNT(*) as total   from " + CommonConstrants.leibo_history_table + "  where history_table=\'" + table + "\'";
        LogUtil.info("isExistCurMonth sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcLocalUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                total = rs.getInt("total");
                LogUtil.info("isExistCurMonth total=" + total);
            }

            LogUtil.info("调用isExistCurMonth查询数据库成功！");
        } catch (Exception var10) {
            LogUtil.debug("调用isExistCurMonth异常" + var10.getMessage());
        } finally {
            JdbcLocalUtil.release(rs, state, conn);
        }

        return total > 0;
    }

    public static void addHistory(String sql) {
        boolean code = false;
        Connection conn = null;
        PreparedStatement state = null;
        LogUtil.info("addHistory sql=" + sql);
        sql = DateUtil.utf8(sql);
        Object rs = null;

        try {
            conn = JdbcLocalUtil.getConnection();
            state = conn.prepareStatement(sql);
            int code1 = state.executeUpdate();
            if(code1 > 0) {
                LogUtil.info("调用addHistory查询数据库成功！");
            }
        } catch (Exception var9) {
            LogUtil.debug("调用addHistory异常" + var9.getMessage());
        } finally {
            JdbcLocalUtil.release((ResultSet)rs, state, conn);
        }

    }

    public static void addCarInfo(String sql) {
        boolean code = false;
        Connection conn = null;
        PreparedStatement state = null;
        LogUtil.info("addCarInfo sql=" + sql);
        sql = DateUtil.utf8(sql);
        Object rs = null;

        try {
            conn = JdbcLocalUtil.getConnection();
            state = conn.prepareStatement(sql);
            int code1 = state.executeUpdate();
            if(code1 > 0) {
                LogUtil.info("调用addCarInfo查询数据库成功！");
            }
        } catch (Exception var9) {
            LogUtil.debug("调用addCarInfo异常" + var9.getMessage());
        } finally {
            JdbcLocalUtil.release((ResultSet)rs, state, conn);
        }

    }

    public static int getCarInfoIndex() {
        int total = 0;
        Connection conn = null;
        PreparedStatement state = null;
        String sql = "select EV_ID   from " + CommonConstrants.osa_carInfo + "  order by EV_ID desc limit 1 ";
        ResultSet rs = null;

        try {
            conn = JdbcLocalUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                total = rs.getInt("EV_ID");
                LogUtil.info("车辆信息库 EV_ID=" + total);
            }

            LogUtil.info("调用getCarInfoIndex查询数据库成功！");
        } catch (Exception var9) {
            LogUtil.debug("调用getCarInfoIndex异常" + var9.getMessage());
        } finally {
            JdbcLocalUtil.release(rs, state, conn);
        }

        return total;
    }

    public static int getHistroyIndex() {
        int total = 0;
        Connection conn = null;
        PreparedStatement state = null;
        String sql = "select XID   from " + CommonConstrants.curTable + "  order by XID desc limit 1 ";
        LogUtil.info("getHistroyIndex sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcLocalUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                total = rs.getInt("XID");
                LogUtil.info("车辆信息库 XID=" + total);
            }

            LogUtil.info("调用getHistroyIndex查询数据库成功！");
        } catch (Exception var9) {
            LogUtil.debug("调用getHistroyIndex异常" + var9.getMessage());
        } finally {
            JdbcLocalUtil.release(rs, state, conn);
        }

        return total;
    }

    public static boolean getCarRegister(String EV_ID) {
        int total = 0;
        Connection conn = null;
        PreparedStatement state = null;
        String sql = "select count(*) as total  from leibo_car_register t where t.EV_ID=\'" + EV_ID + "\'  limit 1 ";
        LogUtil.info("getCarRegister sql=" + sql);
        ResultSet rs = null;

        try {
            conn = JdbcLocalUtil.getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();

            while(rs.next()) {
                total = rs.getInt("total");
                LogUtil.info("车辆注册信息记录【" + total + "】");
            }

            LogUtil.info("调用getCarRegister查询数据库成功！");
        } catch (Exception var10) {
            LogUtil.debug("调用getCarRegister异常" + var10.getMessage());
        } finally {
            JdbcLocalUtil.release(rs, state, conn);
        }

        return total > 0;
    }
}
