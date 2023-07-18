package com.youyouxing.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * Description:
 * Author:LiuKaiqQiang
 * Date:2023-07-18
 * Time:11:23
 */
public class GetConn {
        // 通过数据库连接池获取通道
        public static Connection getDruidConn() throws Exception {
            DruidDataSource ds;
            InputStreamReader is = new InputStreamReader
                    (GetConn.class.getClassLoader().getResourceAsStream("db.properties"));
            Properties properties = new Properties();
            properties.load(is);
            ds = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
            return ds.getConnection();
        }

    public static void CloseDB(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
        if(rs!=null){
            rs.close();
        }
        if(stmt!=null){
            stmt.close();
        }
        if(conn!=null){
            conn.close();
        }

    }


}
