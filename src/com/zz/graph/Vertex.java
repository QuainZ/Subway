package com.zz.graph;
import java.util.ArrayList;
//������

/*
 * �༭�ˣ���˼��
 * ʱ��:2017-3-25
 * ���ܣ�վ������ݽṹʵ��
 */

public class Vertex {
	int id;//��ʶID
	String name;//��վ����
	ArrayList<Integer> subwayline_id;
	boolean ischange;// ��ʶ�Ƿ�Ϊ���˵�
	
    int X;//�ڵ���ͼ�е�X����
    int Y;//�ڵ���ͼ�е�Y����
  
    public Vertex(int id, String name, ArrayList<Integer> subwayline_id, boolean ischange, int X, int Y) {  
        this.id = id; 
        this.name = name;
        this.subwayline_id = subwayline_id;
        this.ischange = ischange; 
        this.X = X;
        this.Y = Y; 
    }     
}
