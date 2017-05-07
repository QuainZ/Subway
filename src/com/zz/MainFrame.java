package com.zz;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import com.zz.graph.*;
import com.zz.dao.*;

/*
 * 编辑人：诸思文
 * 时间:2017-5-1
 * 功能：主窗体框架
 */

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static Graph g;//地铁图
	private static ArrayList<Subwayline> sl;//地铁线路信息
	
	private static JTextField t1 = new JTextField();
	private static JButton b1= new JButton("查询");
	private static JTextField t21 = new JTextField();
	private static JTextField t22 = new JTextField();
	private static JButton b2= new JButton("查询");
	private static JTextField t3 = new JTextField();
	private static JButton b3= new JButton("查询");
	private static JTextArea jt = new JTextArea();
		
	static class b1Action implements ActionListener {
		public void actionPerformed(ActionEvent arg0) { 
			String temp = t1.getText();
			int flag = 0;
			try {
				for (int i = 0; i < sl.size(); i++)
				{
					if(sl.get(i).getname().equals(temp)) {
						jt.setText(sl.get(i).getinformation());
						flag = 1;
					}
				}
				if(flag == 0) {
					throw new Exception("未查询到该地铁线路");
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "未查询到该地铁线路", "警告", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	static class b2Action implements ActionListener {
		public void actionPerformed(ActionEvent arg0) { 
			String temp1 = t21.getText();
			String temp2 = t22.getText();
			int n1 = -1;
			int n2 = -1;
			try {
				n1 = g.getIndexByName(temp1);
				if(n1 == -1) {
					throw new Exception("未查询到该地铁站");
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "未查询到起始点地铁站", "警告", JOptionPane.ERROR_MESSAGE);
			}
			try {
				n2 = g.getIndexByName(temp2);
				if(n2 == -1) {
					throw new Exception("未查询到该地铁站");
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "未查询到終点地铁站", "警告", JOptionPane.ERROR_MESSAGE);
			}
			try {
				if(n2 == n1) {
					throw new Exception("起始点地铁站与終点地铁站相同");
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "起始点地铁站与終点地铁站相同", "警告", JOptionPane.ERROR_MESSAGE);
			}
			ArrayList<Vertex> temp = g.getClosestPath(n1 ,n2);
			jt.setText("");
			for (int i = 0; i < temp.size(); i++)
			{
				jt.append(temp.get(i).getname()+"\r\n");
			}
		}
	}
	
	static class b3Action implements ActionListener {
		public void actionPerformed(ActionEvent arg0) { 
			JOptionPane.showMessageDialog(null, "此功能暂未实现", "警告", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao dao1 = new Dao();
		sl = dao1.getSubwayline();
		g = dao1.getGraph();
		
		Font font = new  Font("宋体",Font.BOLD, 20);
		Font font1 = new  Font("宋体",Font.PLAIN, 14);
		Font font2 = new  Font("宋体",Font.BOLD, 50);
		
		JFrame jf = new JFrame("地铁换乘软件");
		jf.setLayout(null);
		jf.setBounds(10, 10, 1710, 1000);
		Container c = jf.getContentPane();
		
		DrawPanel p1 = new DrawPanel(g);
		p1.setPreferredSize(new Dimension(2400, 1660));
		JScrollPane sp = new JScrollPane(p1);
		sp.setBounds(0, 0, 1300, 700);
		c.add(sp);
		
		//查询功能1界面
		JLabel l11 = new JLabel("功能1：查询地铁线路信息");
		l11.setFont(font);
		l11.setBounds(1350, 30, 300, 30);
		JLabel l12 = new JLabel("输入地铁的线路名：");
		l12.setFont(font1);
		l12.setBounds(1350, 70, 200, 30);
		t1.setBounds(1350, 110, 200, 30);
		b1.setBounds(1350, 160, 150, 30);
		b1.addActionListener(new b1Action());
		c.add(l11);
		c.add(l12);
		c.add(t1);
		c.add(b1);
		
		//查询功能2界面
		JLabel l21 = new JLabel("功能2：查询地铁站点间最有效线路");
		l21.setFont(font);
		l21.setBounds(1350, 220, 350, 30);
		JLabel l22 = new JLabel("输入起始点地铁站名：");
		l22.setFont(font1);
		l22.setBounds(1350, 260, 200, 30);
		t21.setBounds(1350, 300, 200, 30);
		JLabel l23 = new JLabel("输入终点地铁站名：");
		l23.setFont(font1);
		l23.setBounds(1350, 340, 200, 30);
		t22.setBounds(1350, 370, 200, 30);
		b2.setBounds(1350, 420, 150, 30);
		b2.addActionListener(new b2Action());
		c.add(l21);
		c.add(l22);
		c.add(l23);
		c.add(t21);
		c.add(t22);
		c.add(b2);
		
		//查询功能3界面
		JLabel l31 = new JLabel("功能3：查询最快遍历地铁所有车站");
		l31.setFont(font);
		l31.setBounds(1350, 480, 350, 30);
		JLabel l32 = new JLabel("输入地铁站名：");
		l32.setFont(font1);
		l32.setBounds(1350, 520, 200, 30);
		t3.setBounds(1350, 560, 200, 30);
		b3.setBounds(1350, 610, 150, 30);
		b3.addActionListener(new b3Action());
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
		jt.setLineWrap(true);
		jt.setWrapStyleWord(true);  
		jt.setEditable(false);
		JScrollPane sp1 = new JScrollPane(jt);
		sp1.setBounds(200, 730, 1440, 210);
		c.add(l41);
		c.add(l42);
		c.add(sp1);
		
		
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}

class DrawPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static final int MAX_VALUE = 2147483647;
	
	private static Graph g1;
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.YELLOW);
        for (int i = 0; i < g1.getNumOfVertex(); i++) {  
            for (int j = i + 1; j < g1.getNumOfVertex(); j++) {
            	if( ( 0 < g1.getWeight(i, j) ) && ( g1.getWeight(i, j) < MAX_VALUE)){//MAX_VALUE表示无穷大
                    Line2D line = new Line2D.Double( 2 * g1.getValueByIndex(i).getX(), 2 * g1.getValueByIndex(i).getY(),
                    		2 * g1.getValueByIndex(j).getX(), 2 * g1.getValueByIndex(j).getY());
                    g2.draw(line);
            	}
            }
        } 
		Font font = new  Font("宋体",Font.PLAIN,  11);
		g2.setFont(font);
		for(int i = 0; i < g1.getNumOfVertex(); i++) {
			g2.setColor(Color.BLACK);
			g2.fillOval( 2 * g1.getValueByIndex(i).getX() - 2, 2 * g1.getValueByIndex(i).getY() - 2, 5, 5);
			g2.setColor(Color.RED);
			g2.drawString(g1.getValueByIndex(i).getname(), 2 * g1.getValueByIndex(i).getX() + 5, 2 * g1.getValueByIndex(i).getY() + 10);
		}
		g2.setColor(Color.BLACK);
	}
	
	public DrawPanel(Graph g) {
		
		setBackground(Color.WHITE);
		g1 = g;
	}
}
