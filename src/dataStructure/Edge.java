package dataStructure;

import java.io.Serializable;

public class Edge implements edge_data , Serializable{
	
	private int src;
	private int dest;
	private double weight;
	private String info;
	private int tag;
	
	public Edge(int src , int dst) {
		this.src = src;
		this.dest = dst;
		this.weight = 0;
		this.info = null;
		this.tag = 0;
	}
	
	public Edge(int src , int dst , double w , String i , int t) {
		this.src = src;
		this.dest = dst;
		this.weight = w;
		this.info = i + "";
		this.tag = t;
	}
	

	@Override
	public int getSrc() {
		// TODO Auto-generated method stub
		return this.src;
	}

	@Override
	public int getDest() {
		// TODO Auto-generated method stub
		return this.dest;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.info;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub
		this.info = s + "";
		
	}

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub
		this.tag = t;
	}


	@Override 
	public String toString() {
		return "Edge " + "(" + src + ")" + "--" + weight + "-->" + "(" + dest + ") ";
	}
	
	
	
	

}
