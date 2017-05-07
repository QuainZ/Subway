package com.zz.dao;
import java.sql.*;
import com.zz.graph.*;
import java.util.ArrayList;
//import java.io.*;

/*
 * �༭�ˣ���˼��
 * ʱ��:2017-3-24
 * ���ܣ��������ݿ�
 */

public class Dao {
	private ArrayList<Subwayline> s1;//������·��Ϣ
	private Graph g1;//����ͼ
	private ArrayList<Vertex> v1;//����վ����Ϣ
	
	public ArrayList<Subwayline> getSubwayline() {
		return s1;
	}
	
	public Graph getGraph() {
		return g1;
	}
		
	public Dao() {
		try {
			//����SQLite��JDBC
			Class.forName("org.sqlite.JDBC");       
			//����һ�����ݿ���subway.db������
			Connection con = DriverManager.getConnection("jdbc:sqlite:db_subway.db");
			Statement sql = con.createStatement();
			
			this.s1 = new ArrayList<Subwayline>();
			this.v1 = new ArrayList<Vertex>();
			
			//ִ����sql��䣬���ؽ����
			ResultSet res = sql.executeQuery("select * from tb_bj_subwaylines");
			while (res.next()) {
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
				this.s1.add(s);
			}
			res = sql.executeQuery("select * from tb_bj_points");
			while (res.next()) {
				int id = 0;
				int X = 0;
				int Y = 0;
				ArrayList<Integer> sid = new ArrayList<Integer>();
				try {
					id = Integer.valueOf(res.getString("ID")).intValue();
					X = Integer.valueOf(res.getString("X")).intValue();
					Y = Integer.valueOf(res.getString("Y")).intValue();
					String str = res.getString("subwaylines_ID");
			        String[] str1 = str.split(",");
			        for (int i = 0; i < str1.length; i++) {
			        	sid.add(Integer.valueOf(str1[i]));
			        }
				} 
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				String name = res.getString("name");
				boolean ischange = res.getInt("ischange") > 0;
				Vertex v = new Vertex(id, name, sid, ischange, X, Y);
				v1.add(v);
			}
			this.g1 = new Graph(v1.size());
			for (int i = 0; i < v1.size(); i++)
			{
				this.g1.insertVertex(v1.get(i));
			}
			res = sql.executeQuery("select * from tb_bj_edges");
			while (res.next()) {
				int id1 = 0;
				int id2 = 0;
				try {
					id1 = Integer.valueOf(res.getString("frompoint_ID")).intValue();
					id2 = Integer.valueOf(res.getString("topoint_ID")).intValue();
				} 
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				this.g1.insertEdge(id1-1, id2-1);
				this.g1.insertEdge(id2-1, id1-1);
			}
			con.close(); //�������ݿ������ 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
/*	public static void main(String[] args) {
		try {
			//����SQLite��JDBC
			Class.forName("org.sqlite.JDBC");       
			//����һ�����ݿ���subway.db������
			Connection con = DriverManager.getConnection("jdbc:sqlite:db_subway.db");
			//���ı��ж�ȡ����Ϣ
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
			//���ı��ж�ȡ������Ϣ
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
			con.close(); //�������ݿ������ 
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
	}*/
}
