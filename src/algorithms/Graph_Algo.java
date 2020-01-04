package algorithms;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.LinkedList;
import java.util.List;

import dataStructure.DGraph;
import dataStructure.Edge;
import dataStructure.Node;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author orenl
 *
 */
public class Graph_Algo implements graph_algorithms , Serializable{

	/**
	 * the given graph
	 */
	public graph graph_algo;

	/**
	 * the graph represented as directed graph
	 */
	public DGraph d_graph;

	/**
	 * constructor
	 * @param g graph to use in this Graph_Algo
	 */
	public Graph_Algo(graph g) {
		init(g);
	}


	@Override
	public void init(graph g) {
		// TODO Auto-generated method stub
		this.graph_algo = g;

	}

	/**
	 * Initialize this Graph_Algo from a file witch contains graph object (Serializable)
	 * prints the graph that received from the file  
	 */
	@Override
	public void init(String file_name) {
		// TODO Auto-generated method stub

		try
		{    
			FileInputStream file = new FileInputStream(file_name); 
			ObjectInputStream in = new ObjectInputStream(file); 


			this.init((graph)in.readObject());

			in.close(); 
			file.close(); 

			System.out.println("Graph_Algo has been deserialized"); 
			System.out.println(this.graph_algo);

		} 

		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		} 

		catch(ClassNotFoundException ex) 
		{ 
			System.out.println("ClassNotFoundException is caught"); 
		}

	}

	/**
	 * serialized the graph object of this Graph_Algo into a file
	 */
	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub

		graph g = null;
		g = this.graph_algo;
		String filename = file_name; 

		try
		{    
			FileOutputStream file = new FileOutputStream(filename); 
			ObjectOutputStream out = new ObjectOutputStream(file); 

			out.writeObject(g); 

			out.close(); 
			file.close(); 

			System.out.println("Graph_Algo has been serialized"); 
		}   
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
			ex.printStackTrace();
		} 

	}


	/**
	 * assistance method to check if there is a path between node n
	 * to every other node in the graph
	 * @param n the node we interested to check
	 * @return true only if n is connected by a path to all the other nodes
	 * 
	 * this method also stored necessary data to calculate shortest path
	 */
	public boolean nodeConnected(Node n) {

		/* this directed graph */
		DGraph graph = (DGraph) this.graph_algo;

		boolean ans = false;

		// (use for shortest path)
		Edge e_ = null;


		/* list to sign witch node is already visited
		    if a node is visited we set his tag to 1
		    else his tag will be 0 */
		LinkedList<Node> visited = new LinkedList<Node>();

		for(int i = 0 ; i < graph.nodes_list.size() ; i++) {
			visited.add(i,graph.nodes_list.get(i));
		}

		// (use for shortest path)
		for(int i = 0; i < visited.size() ; i++) {
			visited.get(i).setWeight(Integer.MAX_VALUE);
		}


		/* set Node n to visited */
		int n_index = 0;
		n_index = visited.indexOf(n);
		visited.get(n_index).setTag(1);

		// (use for shortest path)
		visited.get(n_index).setWeight(0);
		visited.get(n_index).setInfo(null);


		/* set the nodes witch connected to n by edge(n neighbors) to 1 */
		for(int i = 0 ; i < graph.nodes_list.size() ; i++) {
			if(n.areConnected(graph.nodes_list.get(i))) {
				visited.get(i).setTag(1);

				//(use for shortest path)
				e_ = (Edge) graph.getEdge(n.getKey(),graph.nodes_list.get(i).getKey());
				if(e_.getWeight() < visited.get(i).getWeight()) {
					visited.get(i).setWeight(e_.getWeight());
				}
				visited.get(i).setInfo("" + n.getKey());

			}
		}

		/* check the paths of n neighbors */
		Node temp = null;
		Edge e_temp = null;

		for(int i = 0; i < visited.size() ; i++) {
			if((visited.get(i).getTag() == 1) && (i != n_index)) {
				temp = visited.get(i);
				for(int j = 0 ; j < temp.edge_list.size() ; j++) {
					e_temp = temp.edge_list.get(j);
					for(int k = 0 ; k < visited.size() ; k++) {
						if((visited.get(k).getTag() != 1) && (visited.get(k).getKey() == e_temp.getDest())) {
							visited.get(k).setTag(1);

							//(use for shortest path)
							e_ = (Edge) graph.getEdge(temp.getKey(),visited.get(k).getKey());
							if((temp.getWeight() + e_.getWeight()) < visited.get(k).getWeight()) {
								visited.get(k).setWeight(temp.getWeight() + e_.getWeight());
							}
							visited.get(k).setInfo("" + temp.getKey());
						}
					}

				}
			}
		}

		//(use for shortest path)
		this.d_graph = (DGraph) this.graph_algo;

		int count = 0;
		for(int i = 0; i < visited.size() ; i++) {

			//(use for shortest path)
			this.d_graph.nodes_list.get(i).setWeight(visited.get(i).getWeight());



			if(visited.get(i).getTag() == 1) {
				count++;

			}
		}
		if((count == visited.size()) && (visited.size() > 0)) {
			ans = true;
		}


		/* clear the list */
		for(int i = 0; i < visited.size() ; i++) {
			visited.get(i).setTag(0);
		}

		return ans;
	}




	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		DGraph graph = (DGraph) this.graph_algo;
		boolean ans = true;
		/* this array stores each node connection status */
		boolean nodes_connection[] = new boolean[graph.nodes_list.size()];

		for(int i = 0 ; i < nodes_connection.length ; i++) {
			nodes_connection[i] = nodeConnected(graph.nodes_list.get(i));
		}


		for(int i = 0 ; i < nodes_connection.length; i++) {
			if(nodes_connection[i] == false) {
				ans = false;
			}
		}

		return ans;
	}

	/**
	 * returns the length of the shortest path between src to dest
	 * by calling the nodeConnected method
	 * Notice (infinity represented as 2.147483647E9(Max Value))
	 * if there is not a path between src to dest the method
	 * returns 2.147483647E9(Max Value)
	 */
	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub

		DGraph temp = (DGraph) this.graph_algo;
		Node s = null;
		for(int i = 0 ; i < temp.nodeSize() ; i++) {
			if(temp.nodes_list.get(i).getKey() == src) {
				s = temp.nodes_list.get(i);
			}
		}

		Node d = null;

		nodeConnected(s);

		for(int i = 0 ; i < this.d_graph.nodeSize() ; i++) {
			if(this.d_graph.nodes_list.get(i).getKey() == dest) {
				d = this.d_graph.nodes_list.get(i);
				return d.getWeight();
			}

		}
		return Integer.MAX_VALUE;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub

		LinkedList<Node> path = new LinkedList<Node>();

		DGraph temp = (DGraph) this.graph_algo;
		Node s = null;
		for(int i = 0 ; i < temp.nodeSize() ; i++) {
			if(temp.nodes_list.get(i).getKey() == src) {
				s = temp.nodes_list.get(i);
			}
		}

		// dest
		Node d = null;
		// temps
		Node t = null;
		Node t2 = null;
		// use to parse the nodes info to int
		Integer I = null;

		nodeConnected(s);

		try {
			for(int i = 0 ; i < this.d_graph.nodeSize() ; i++) {
				if(this.d_graph.nodes_list.get(i).getKey() == dest) {
					d = this.d_graph.nodes_list.get(i);
					path.addFirst(d);
					t = d;
					while(t.getInfo() != null) {
						I = I.parseInt(t.getInfo());

						for(int j = 0 ; j < this.d_graph.nodeSize() ; j++) {
							if(this.d_graph.nodes_list.get(j).getKey() == I) {
								t2 = this.d_graph.nodes_list.get(j);

								path.addFirst(t2);
								t = t2;
							}			
						}		

					}

				}

			}

		}
		catch(Exception ex) {
			return (List)path;
		}
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub

		DGraph t = (DGraph) this.graph_algo;
		DGraph temp = new DGraph();
		for(int i = 0 ; i < t.nodes_list.size(); i++) {
			temp.nodes_list.add(i , t.nodes_list.get(i));
		}
		return temp;

	}

}
