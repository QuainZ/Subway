package com.zz;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import com.zz.graph.*;
import com.zz.dao;

/*
 * �༭�ˣ���˼��
 * ʱ��:2017-5-1
 * ���ܣ���������
 */

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Graph g1;
	private ArrayList<Subwayline> sl1;
	
	public void drawgraph(){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Font font = new  Font("����",Font.BOLD, 20);
		Font font1 = new  Font("����",Font.PLAIN, 14);
		Font font2 = new  Font("����",Font.BOLD, 50);
		JFrame jf = new JFrame("�����������");
		jf.setLayout(null);
		jf.setBounds(10, 10, 1710, 1000);
		Container c = jf.getContentPane();
		JScrollPane sp = new JScrollPane();
		sp.setBounds(0, 0, 1300, 700);
		c.add(sp);
		//��ѯ����1
		JLabel l11 = new JLabel("����1����ѯ������·��Ϣ");
		l11.setFont(font);
		l11.setBounds(1350, 30, 300, 30);
		JLabel l12 = new JLabel("�����������·����");
		l12.setFont(font1);
		l12.setBounds(1350, 70, 200, 30);
		JTextField t1 = new JTextField();
		t1.setBounds(1350, 110, 200, 30);
		JButton b1= new JButton("��ѯ");
		b1.setBounds(1350, 160, 150, 30);
		c.add(l11);
		c.add(l12);
		c.add(t1);
		c.add(b1);
		//��ѯ����2
		JLabel l21 = new JLabel("����2����ѯ����վ�������Ч��·");
		l21.setFont(font);
		l21.setBounds(1350, 220, 350, 30);
		JLabel l22 = new JLabel("������ʼ�����վ����");
		l22.setFont(font1);
		l22.setBounds(1350, 260, 200, 30);
		JTextField t21 = new JTextField();
		t21.setBounds(1350, 300, 200, 30);
		JLabel l23 = new JLabel("�����յ����վ����");
		l23.setFont(font1);
		l23.setBounds(1350, 340, 200, 30);
		JTextField t22 = new JTextField();
		t22.setBounds(1350, 370, 200, 30);
		JButton b2= new JButton("��ѯ");
		b2.setBounds(1350, 420, 150, 30);
		c.add(l21);
		c.add(l22);
		c.add(l23);
		c.add(t21);
		c.add(t22);
		c.add(b2);
		
		//��ѯ����3
		JLabel l31 = new JLabel("����3����ѯ�������������г�վ");
		l31.setFont(font);
		l31.setBounds(1350, 480, 350, 30);
		JLabel l32 = new JLabel("�������վ����");
		l32.setFont(font1);
		l32.setBounds(1350, 520, 200, 30);
		JTextField t3 = new JTextField();
		t3.setBounds(1350, 560, 200, 30);
		JButton b3= new JButton("��ѯ");
		b3.setBounds(1350, 610, 150, 30);
		c.add(l31);
		c.add(l32);
		c.add(t3);
		c.add(b3);
		
		//��ѯ�����ʾ
		JLabel l41 = new JLabel("��ѯ");
		l41.setFont(font2);
		l41.setBounds(50, 760, 150, 50);
		JLabel l42 = new JLabel("���");
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
