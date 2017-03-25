package com.zz.dao;
import java.sql.*;

/*
 * 编辑人：诸思文
 * 时间:2017-3-24
 * 功能：连接数据库
 */

public class Dao {
	 public static void main(String[] args) {
	        try
	        {
	         //连接SQLite的JDBC
	         Class.forName("org.sqlite.JDBC");       
	         //建立一个数据库名lincj.db的连接，如果不存在就在当前目录下创建之
	         Connection conn = DriverManager.getConnection("jdbc:sqlite:subway.db");  
	         conn.close(); //结束数据库的连接 
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	 }
}
