package dataStructure;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import utils.Point3D;


/**
 * This Class represents a node (vertex) in a (directional) weighted graph.
 * @author orenl
 *
 */
public class Node implements node_data , Serializable{
	
	public LinkedList<Edge> edge_list;
	private int key;
	private Point3D location;
	private double weight;
	private String info;
	private int tag;
	
	public Node(int k) {
		this.edge_list = new LinkedList<Edge>();
		this.key = k;
		this.location = null;
		this.weight = 0;
		this.info = null;
		this.tag = 0;
	}
	
	public Node(int k , Point3D p , double w , String i , int t) {
		this.edge_list = new LinkedList<Edge>();
		this.key = k;
		this.location = p;
		this.weight = w;
		this.info = i + "";
		this.tag = t;
	}
		
	
	public LinkedList<Edge> getEdgeList() {
		LinkedList<Edge> temp = new LinkedList<Edge>();
		temp = this.edge_list;
		return temp;
	}
	
	public void addEdge(Edge e) {
		this.edge_list.add(e);
	}
	
	

	@Override
	public int getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public Point3D getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}

	@Override
	public void setLocation(Point3D p) {
		// TODO Auto-generated method stub
		Point3D p_temp = new Point3D(p);
		this.location = p_temp;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public void setWeight(double w) {
		// TODO Auto-generated method stub
		this.weight = w;
		
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
		String node_print =  "Node [key = " + key + "] ";
		node_print = node_print +": "+ this.edge_list.toString();

		return node_print;
	}
	
	public boolean areConnected(Node n) {
		boolean b = false;
		for(int i = 0 ; i < this.edge_list.size() ; i++) {
			if(this.edge_list.get(i).getDest() == n.getKey())
				b = true;
		}
		return b;
	}
	
	

}
