package com.zz.graph;
import java.util.ArrayList;
//顶点类

/*
 * 编辑人：诸思文
 * 时间:2017-3-25
 * 功能：站点的数据结构实现
 */

public class Vertex {
	int id;//标识ID
	String name;//车站名字
	ArrayList<Integer> subwayline_id;
	boolean ischange;// 标识是否为换乘点
	
    int X;//在地铁图中的X坐标
    int Y;//在地铁图中的Y坐标
  
    public Vertex(int id, String name, ArrayList<Integer> subwayline_id, boolean ischange, int X, int Y) {  
        this.id = id; 
        this.name = name;
        this.subwayline_id = subwayline_id;
        this.ischange = ischange; 
        this.X = X;
        this.Y = Y; 
    }     
}
