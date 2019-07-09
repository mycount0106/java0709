package com.woniu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
     static String driver;
     static String url;
     static String user;
     static String password;
     static{
    	 Properties pro=new Properties();
    	 try {
			pro.load(JdbcUtils.class.getResourceAsStream("db.properties"));
			driver=pro.getProperty("driver");
			url=pro.getProperty("url");
			user=pro.getProperty("user");
			password=pro.getProperty("password");
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
     }
     public static Connection getconn() throws SQLException{
    	 Connection conn=DriverManager.getConnection(url,user,password);
    	 return conn;
     }
     public static void getclose(ResultSet rs,Statement stat,Connection conn){
    	 try {
			if(rs!=null){
				 rs.close();
			 }
			 if(stat!=null){
				 stat.close();
			 }
			 if(conn!=null){
				 conn.close();
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
     }
}
