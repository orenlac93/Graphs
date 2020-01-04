package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Edge;
import dataStructure.Node;
import utils.Point3D;

class Graph_AlgoTest {

	@Test
	void test() {
		
		/* create nodes */
		Node n1 = new Node(11);
		Node n2 = new Node(13);
		Node n3 = new Node(4);
		Node n4 = new Node(14);
		
		/* create points */
		Point3D p1 = new Point3D(-7,7,0);
		Point3D p2 = new Point3D(-10,-2,0);
		Point3D p3 = new Point3D(0,0,0);
		Point3D p4 = new Point3D(2,8,0);
		
		/* set the nodes location by the points */
		n1.setLocation(p1);
		n2.setLocation(p2);
		n3.setLocation(p3);
		n4.setLocation(p4);
						
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
		
		/* print the structure of g */
		System.out.println(g);
		
		/* execute algorithms on g */ 
		Graph_Algo algo = new Graph_Algo(null);
		algo.init(g);
		
		// g is not connected
		assertEquals(algo.isConnected() , false);
		
		// the path length is 45
		assertEquals(algo.shortestPathDist(11,14) , 45);
		
	}

}
