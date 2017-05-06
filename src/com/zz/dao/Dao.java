package com.zz.dao;
import java.sql.*;
import com.zz.graph.*;
import java.util.ArrayList;
//import java.io.*;

/*
 * 编辑人：诸思文
 * 时间:2017-3-24
 * 功能：连接数据库
 */

public class Dao {
	static Connection con;
	static Statement sql;
	static ResultSet res;
	private ArrayList<Subwayline> s1;
	public Connection getConnection() {
		try {
			if(con == null) {
				//连接SQLite的JDBC
				Class.forName("org.sqlite.JDBC");       
				//建立一个数据库名subway.db的连接
				Connection con = DriverManager.getConnection("jdbc:sqlite:db_subway.db");
			}
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
		
	public ArrayList<Subwayline> getSubwayline(Connection con) {
		s1 = null;
		try {
			sql = con.createStatement();
			//执行是sql语句，返回结果集
			res = sql.executeQuery("select * from tb_bj_subwaylines");
			while (res.next()){
				int id = 0;
				try {
					id = Integer.valueOf(res.getString("num")).intValue();
				} 
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				String name = res.getString("name");
				String information = res.getString("station_name");				
				Subwayline s = new Subwayline(id, name, information);
				s1.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
	
	public Graph getgraph(Connection con) {
		
	}
	
	
/*	public static void main(String[] args) {
		try {
			//连接SQLite的JDBC
			Class.forName("org.sqlite.JDBC");       
			//建立一个数据库名subway.db的连接
			Connection con = DriverManager.getConnection("jdbc:sqlite:db_subway.db");
			//从文本中读取边信息
			ArrayList<String> str = new ArrayList<String>();
			try{
				File file = new File("edges.txt");
			 	FileReader fr = new FileReader(file);
				BufferedReader bufr = new BufferedReader(fr);
				String s = null;
				while((s = bufr.readLine()) != null) {
					str.add(s);
				}
				bufr.close();
				fr.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			PreparedStatement sql;
	        for(int i = 0; i < str.size(); i++)	{
		        sql = con.prepareStatement("insert into tb_bj_edges values(?,?,?)");
		        String[] str1 = str.get(i).split(" ");
		        sql.setString(1, str1[0]);
	        	sql.setString(2, str1[1]);
	        	sql.setString(3, str1[2]);
		        sql.executeUpdate();
	        }
			//从文本中读取定点信息
			ArrayList<String> str = new ArrayList<String>();
			try{
				File file = new File("points.txt");
				FileReader fr = new FileReader(file);
				BufferedReader bufr = new BufferedReader(fr);
				String s = null;
				while((s = bufr.readLine()) != null) {
					str.add(s);
				}
			 	bufr.close();
				r.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			PreparedStatement sql;
	        for(int i = 0; i < str.size(); i++)	{
		        sql = con.prepareStatement("insert into tb_bj_points values(?,?,?,?,?,?)");
		        String[] str1 = str.get(i).split(" ");
		        sql.setString(1, str1[0]);
	        	sql.setString(2, str1[1]);
	        	sql.setString(3, str1[5]);
	        	sql.setString(4, str1[2]);
	        	sql.setString(5, str1[3]);
	        	if(str1[4].equals("0")){
		        	sql.setString(6, "false");
	        	}
	        	else{
	        		sql.setString(6, "true");
	        	}
		        sql.executeUpdate();
	        }
			con.close(); //结束数据库的连接 
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
	}*/
}
