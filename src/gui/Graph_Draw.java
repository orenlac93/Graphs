package gui;

import java.awt.color.*;
import java.awt.font.*;
import java.util.LinkedList;


import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;

/**
 * this class use to draw a graph
 * @author orenl
 *
 */
public class Graph_Draw {
	
	/**
	 * the graph
	 */
	public DGraph graph;
	
	/**
	 * constructor 
	 * @param g the given graph
	 */
	public Graph_Draw(DGraph g) {
		this.graph = g;
	}
	
	/**
	 * method use to draw the given graph
	 */
	public void draw() {
		
		/* draw the nodes */
		
		StdDraw.setCanvasSize(1000 , 1000);
		StdDraw.setPenRadius(0.03);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.setScale(-12 , 12);
		
		Point3D p = null;
		int i = 0;
		
		while(i < this.graph.nodes_list.size()) {
			p = this.graph.nodes_list.get(i).getLocation();
			StdDraw.point(p.x(),p.y());
			StdDraw.text(p.x(),p.y()+0.5,"" + this.graph.nodes_list.get(i).getKey());
			i++;
		}
		
		/* draw the edges */
		
		StdDraw.setPenRadius(0.005);
		StdDraw.setPenColor(StdDraw.RED);
		
		// the source of the edge
		Node temp = null;
		// the destination of the edge
		Node next = null;
		// use to sign the direction of the edge 
		double x,y;
		
		for(int j = 0 ; j < this.graph.nodes_list.size() ; j++) {
			temp = this.graph.nodes_list.get(j);
			for(int k = 0 ; k < this.graph.nodes_list.size() ; k++) {
				next = this.graph.nodes_list.get(k);
				if(temp.areConnected(next) == true) {
					StdDraw.line(temp.getLocation().x(),temp.getLocation().y(),next.getLocation().x(),next.getLocation().y());
					
					x = ((temp.getLocation().x() + next.getLocation().x())/2);
					y = ((temp.getLocation().y() + next.getLocation().y())/2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(x,y,"" + this.graph.getEdge(temp.getKey(),next.getKey()).getWeight());
					x = (x + next.getLocation().x())/2;
					y = (y + next.getLocation().y())/2;
					x = (x + next.getLocation().x())/2;
					y = (y + next.getLocation().y())/2;
					StdDraw.setPenRadius(0.03);
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.point(x,y);
				}
				StdDraw.setPenRadius(0.005);
				StdDraw.setPenColor(StdDraw.RED);
			}
		}
			
			
	}
	
	
	

	
	

}
