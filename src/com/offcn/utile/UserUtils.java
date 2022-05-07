package com.offcn.utile;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UserUtils {
    private static DataSource ds;
    //获取数据源
    public static DataSource getDataSource() {
        Properties properties=new Properties();
        //通过当前类的class对象获取资源文件 返回一个读取指定资源的输入流
        InputStream is= UserUtils.class.getResourceAsStream("/druid.properties");
        try {
            //从输入流中读取属性列表
            properties.load(is);
            //返回的是DataSource，不是DruidDataSource
            ds= DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    //数据库连接
    public static Connection getConnection(){
        Connection conn=null;
        try {
            //DataSource ds=getDataSource();
            conn=ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn, Statement st, ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
