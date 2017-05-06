package com.zz.graph;
import java.util.ArrayList;
//ͼ��

/*
 * �༭�ˣ���˼��
 * ʱ��:2017-3-25
 * ���ܣ�ͼ�����ݽṹʵ��
 */


//ͼ��
public class Graph {
	public static final int MAX_VALUE = 2147483647;
	
	ArrayList<Vertex> vertex;// ��������  
    int[][] edge;// �ڽӾ���  
    int numOfEdges;// ��ǰͼ�бߵ�����
    
    //��ʼ��
    public Graph(int n) {
        edge = new int[n][n];  
        numOfEdges = 0;  
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < n; j++) {
            	if(i == j) edge[i][j] = 0;
            	else edge[i][j] =  MAX_VALUE;//MAX_VALUE��ʾ�����
            }
        }  
    }  
 
    //�õ����ĸ���
    public int getNumOfVertex() {
        return vertex.size();
    }

    //�õ��ߵ���Ŀ
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //���ؽ��
    public Vertex getValueByIndex(int i) {
        return vertex.get(i);
    }

    //����v1,v2��Ȩֵ
    public int getWeight(int v1,int v2) {
        return edge[v1][v2];
    }

    //������
    public void insertVertex(Vertex v) {
        vertex.add(v);
    }

    //�����
    public void insertEdge(int v1,int v2) {
        edge[v1][v2]=1;
        numOfEdges++;
    }

    //ɾ����
    public void deleteEdge(int v1,int v2) {
        edge[v1][v2]=0;
        numOfEdges--;
    }

    //�õ���һ���ڽӽ����±�
    public int getFirstVex(int index) {
        for(int i = 0; i < vertex.size(); i++) {
            if (edge[index][i] > 0 && edge[index][i] < MAX_VALUE)
            	return i;
            
        }
        return -1;
    }

    //����ǰһ���ڽӽ����±���ȡ����һ���ڽӽ��
    public int getNextVex(int v1, int v2) {
        for (int i = v2 + 1; i < vertex.size(); i++) {
            if (edge[v1][i]>0) 
                return i;
        }
        return -1;
    }

    //���·��
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
