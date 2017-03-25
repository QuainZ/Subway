package com.zz.graph;
import java.util.ArrayList;

/*
 * 编辑人：诸思文
 * 时间:2017-3-25
 * 功能：图的数据结构实现
 */


//图类
public class Graph {
	public static final int MAX_VALUE = 2147483647;
	
	ArrayList<Vertex> vertex;// 顶点数组  
    int[][] edge;// 邻接矩阵  
    int numOfEdges;// 当前图中边的条数
    
    //初始化
    public Graph(int n) {
        edge = new int[n][n];  
        numOfEdges = 0;  
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < n; j++) {
            	if(i == j) edge[i][j] = 0;
            	else edge[i][j] =  MAX_VALUE;//MAX_VALUE表示无穷大
            }
        }  
    }  
 
    //得到结点的个数
    public int getNumOfVertex() {
        return vertex.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点
    public Vertex getValueByIndex(int i) {
        return vertex.get(i);
    }

    //返回v1,v2的权值
    public int getWeight(int v1,int v2) {
        return edge[v1][v2];
    }

    //插入结点
    public void insertVertex(Vertex v) {
        vertex.add(v);
    }

    //插入边
    public void insertEdge(int v1,int v2) {
        edge[v1][v2]=1;
        numOfEdges++;
    }

    //删除边
    public void deleteEdge(int v1,int v2) {
        edge[v1][v2]=0;
        numOfEdges--;
    }

    //得到第一个邻接结点的下标
    public int getFirstVex(int index) {
        for(int i = 0; i < vertex.size(); i++) {
            if (edge[index][i] > 0 && edge[index][i] < MAX_VALUE)
            	return i;
            
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public int getNextVex(int v1, int v2) {
        for (int i = v2 + 1; i < vertex.size(); i++) {
            if (edge[v1][i]>0) 
                return i;
        }
        return -1;
    }

    //最短路径
    public ArrayList<Vertex> getClosestPath(int v1, int v2) {
    	int n = vertex.size();
    	int[] s = new int[n];
    	int[] distance = new int[n];
    	int[] path = new int[n];
		ArrayList<Vertex> result = new ArrayList<Vertex>();
    	int minDis = 0, i = 0, j = 0, u = 0;
    	for(i = 0; i < n; i++) {
    		distance[i] = edge[v1][i];
    		s[i] = 0;
    		if(i != v1 && distance[i] < MAX_VALUE) path[i] = v1;
    		else path[i] = -1;
    	}
    	s[v1] = 1;
    	for(i = 1; i < n; i++) {
    		minDis = MAX_VALUE;
    		for(j = 0; j < n; j++) {
    			if(s[j] == 0 && distance[j] < minDis) {
    				u = j;
    				minDis = distance[j];
    			}
    		}
    	}

    	if(minDis == MAX_VALUE) return null;
    	s[u] = 1;
    	for(j = 0; j < n; j++) {
    		if(s[j] == 0 && edge[u][j] < MAX_VALUE && distance[u] + edge[u][j] < distance[j]){
    			distance[j] = distance[u] + edge[u][j];
    			path[j] = u;
    		}
    	}
    	
    	i = v2;
    	while(path[i] != -1) {
    		result.add(0,getValueByIndex(path[i]));
    	}
    	return result;
    }
}

//顶点类
class Vertex {  
	int id;//标识ID
    char name;//车站名字
    char subline_name;//多个用','号隔开
    boolean ischange;// 标识是否为换乘点
    boolean isopen;// 标识是否开通
    
    double X;//在地铁图中的X坐标
    double Y;//在地铁图中的Y坐标
  
    public Vertex(int id, char name, char subline_name, boolean ischange, boolean isopen,
    		double X, double Y,boolean isvisited) {  
        this.id = id; 
        this.name = name;
        this.subline_name = subline_name;
        this.ischange = ischange; 
        this.isopen = isopen;
        this.X = X;
        this.Y = Y; 
    }  
} 
