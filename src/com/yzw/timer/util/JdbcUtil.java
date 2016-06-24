package com.yzw.timer.util;

/**
 * Created by BoYang on 2015/10/30.
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public final class JdbcUtil {
    private static DataSource ds ;

    static {
        ds = new ComboPooledDataSource();// Ĭ�ϵ�ȱʡ������
    }

    // ��ȡ��ָ�����ݵ�����

    public static DataSource getSource(){
        return ds ;
    }

    // �����ָ�����ݿ������

    public static Connection getConnection() throws SQLException {
        // �����ӳط���һ������
        return ds.getConnection();
    }

    // �ͷ���Դ

    public static void release(ResultSet rs,Statement stmt,Connection conn) {
        if (rs!= null ){
            try {
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            rs = null ;
        }
        if (stmt!= null ){
            try {
                stmt.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            stmt= null ;
        }
        if (conn!= null ){
            try {
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            conn = null ;
        }
    }

}