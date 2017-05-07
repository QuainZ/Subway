package com.zz.graph;
//地铁路线类

/*
 * 编辑人：诸思文
 * 时间:2017-3-25
 * 功能：subwayline的数据结构实现
 */

public class Subwayline {
	int id;//标识ID
	String name;//地铁路线路名字
	String information;//地铁路线路信息
	
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
