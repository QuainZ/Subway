package com.zz.dao;
import java.sql.*;

/*
 * �༭�ˣ���˼��
 * ʱ��:2017-3-24
 * ���ܣ��������ݿ�
 */

public class Dao {
	 public static void main(String[] args) {
	        try
	        {
	         //����SQLite��JDBC
	         Class.forName("org.sqlite.JDBC");       
	         //����һ�����ݿ���lincj.db�����ӣ���������ھ��ڵ�ǰĿ¼�´���֮
	         Connection conn = DriverManager.getConnection("jdbc:sqlite:subway.db");  
	         conn.close(); //�������ݿ������ 
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	 }
}
