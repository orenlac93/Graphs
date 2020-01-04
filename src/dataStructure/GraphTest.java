package dataStructure;

import java.util.LinkedList;

import gui.Graph_Draw;

import utils.Point3D;

/**
 * this class use for testing the graph methods
 * and the creation of the graph
 * @author orenl
 *
 */
public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* create nodes */
		Node n1 = new Node(11);
		Node n2 = new Node(13);
		Node n3 = new Node(4);
		Node n4 = new Node(14);
		
		/* create points */
		Point3D p1 = new Point3D(3,7,0);
		Point3D p2 = new Point3D(7,8,0);
		Point3D p3 = new Point3D(1,2,0);
		Point3D p4 = new Point3D(5,5,0);
		
		/* set the nodes location by the points */
		n1.setLocation(p1);
		n2.setLocation(p2);
		n3.setLocation(p3);
		n4.setLocation(p4);
		
		/* create edges */
		Edge e1 = new Edge(11,13);
		Edge e2 = new Edge(11,4);
		Edge e3 = new Edge(4,13);
		Edge e4 = new Edge(4,14);
		
		/* add edges to the nodes */ 
		//n1.addEdge(e1);
		//n1.addEdge(e2);
		//n3.addEdge(e3);
		//n3.addEdge(e4);
		
		//System.out.println(n1);
		//System.out.println(e1);
		
		
		/* create graph and add the nodes */
		DGraph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		
		/* connect the graph nodes by edges */
		g.connect(11,13,10);
		g.connect(11,4,15);
		g.connect(4,13,20);
		g.connect(4,14,30);
		
		//System.out.println(g.getNode(11));
		//System.out.println(g.getEdge(4,13));
		
		
		
		/* test getV method */
		//LinkedList<node_data> g_nodes = new LinkedList<node_data>();
		//g_nodes = (LinkedList<node_data>) g.getV();
		//System.out.println(g_nodes);
		
		/* test getE method */
		//LinkedList<edge_data> g_edges = new LinkedList<edge_data>();
		//g_edges = (LinkedList<edge_data>) g.getE(11);
		//System.out.println(g_edges);
		
		/* test removeNode method */
		//node_data rem_n = g.removeNode(11);
		
		/* test removeEdge method */
		//edge_data rem_e = g.removeEdge(11,4);
		
		
		//int num_of_nodes = g.nodeSize();
		//System.out.println(num_of_nodes);
		
		//int num_of_edges = g.edgeSize();
		//System.out.println(num_of_edges);

		System.out.println(g);
		
		Graph_Draw gd = new Graph_Draw(g);
		gd.draw();
		

	}

}
