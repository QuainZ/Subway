package com.zz.graph;
//����·����

/*
 * �༭�ˣ���˼��
 * ʱ��:2017-3-25
 * ���ܣ�subwayline�����ݽṹʵ��
 */

public class Subwayline {
	int id;//��ʶID
	String name;//����·��·����
	String information;//����·��·��Ϣ
	
	public Subwayline(int id, String name, String information) {
        this.id = id; 
        this.name = name;
        this.information = information;
	}
	
    public int getid() {
    	return id;
    }
    
    public String getname() {
    	return name;
    }
    
    public String getinformation() {
    	return information;
    }
}
