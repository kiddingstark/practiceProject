package com.ahong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	public static void main(String[] args) throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//mysql5版本以上使用
        }catch (ClassNotFoundException cne){
            cne.printStackTrace();
        }
        //mysql5版本以上使用需要加上时区:serverTimezone=UTC
        String dburl = "jdbc:mysql://localhost:3306/raymon-mmm";
        try(    
        	Connection conn = DriverManager.getConnection(dburl,"root","Raymon_123");
        )
        {
        }catch (SQLException se){
            se.printStackTrace();
        }finally{
        	System.out.println("链接成功！");
        }
    }
}
