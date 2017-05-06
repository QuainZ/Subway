package com.zz;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import com.zz.graph.*;
import com.zz.dao;

/*
 * 编辑人：诸思文
 * 时间:2017-5-1
 * 功能：主窗体框架
 */

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Graph g1;
	private ArrayList<Subwayline> sl1;
	
	public void drawgraph(){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Font font = new  Font("宋体",Font.BOLD, 20);
		Font font1 = new  Font("宋体",Font.PLAIN, 14);
		Font font2 = new  Font("宋体",Font.BOLD, 50);
		JFrame jf = new JFrame("地铁换乘软件");
		jf.setLayout(null);
		jf.setBounds(10, 10, 1710, 1000);
		Container c = jf.getContentPane();
		JScrollPane sp = new JScrollPane();
		sp.setBounds(0, 0, 1300, 700);
		c.add(sp);
		//查询功能1
		JLabel l11 = new JLabel("功能1：查询地铁线路信息");
		l11.setFont(font);
		l11.setBounds(1350, 30, 300, 30);
		JLabel l12 = new JLabel("输入地铁的线路名：");
		l12.setFont(font1);
		l12.setBounds(1350, 70, 200, 30);
		JTextField t1 = new JTextField();
		t1.setBounds(1350, 110, 200, 30);
		JButton b1= new JButton("查询");
		b1.setBounds(1350, 160, 150, 30);
		c.add(l11);
		c.add(l12);
		c.add(t1);
		c.add(b1);
		//查询功能2
		JLabel l21 = new JLabel("功能2：查询地铁站点间最有效线路");
		l21.setFont(font);
		l21.setBounds(1350, 220, 350, 30);
		JLabel l22 = new JLabel("输入起始点地铁站名：");
		l22.setFont(font1);
		l22.setBounds(1350, 260, 200, 30);
		JTextField t21 = new JTextField();
		t21.setBounds(1350, 300, 200, 30);
		JLabel l23 = new JLabel("输入终点地铁站名：");
		l23.setFont(font1);
		l23.setBounds(1350, 340, 200, 30);
		JTextField t22 = new JTextField();
		t22.setBounds(1350, 370, 200, 30);
		JButton b2= new JButton("查询");
		b2.setBounds(1350, 420, 150, 30);
		c.add(l21);
		c.add(l22);
		c.add(l23);
		c.add(t21);
		c.add(t22);
		c.add(b2);
		
		//查询功能3
		JLabel l31 = new JLabel("功能3：查询最快遍历地铁所有车站");
		l31.setFont(font);
		l31.setBounds(1350, 480, 350, 30);
		JLabel l32 = new JLabel("输入地铁站名：");
		l32.setFont(font1);
		l32.setBounds(1350, 520, 200, 30);
		JTextField t3 = new JTextField();
		t3.setBounds(1350, 560, 200, 30);
		JButton b3= new JButton("查询");
		b3.setBounds(1350, 610, 150, 30);
		c.add(l31);
		c.add(l32);
		c.add(t3);
		c.add(b3);
		
		//查询结果显示
		JLabel l41 = new JLabel("查询");
		l41.setFont(font2);
		l41.setBounds(50, 760, 150, 50);
		JLabel l42 = new JLabel("结果");
		l42.setFont(font2);
		l42.setBounds(50, 860, 150, 50);
		JTextArea jt = new JTextArea();
		jt.setLineWrap(true);
		jt.setWrapStyleWord(true);  
		jt.setEditable(false);
		JScrollPane sp1 = new JScrollPane(jt);
		sp1.setBounds(200, 730, 1640, 210);
		c.add(l41);
		c.add(l42);
		c.add(sp1);
		
		
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}
