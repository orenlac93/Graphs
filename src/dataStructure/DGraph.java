package dataStructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * This class represents a directional weighted graph.
 * 
 * @author orenl
 *
 */
public class DGraph implements graph{

	/**
	 * list of the graph nodes 
	 */
	public LinkedList<Node> nodes_list;

	/**
	 * graph constructor
	 */
	public DGraph() {
		this.nodes_list = new LinkedList<Node>();
	}


	@Override
	public node_data getNode(int key) {
		// TODO Auto-generated method stub

		while(this.nodes_list.iterator().hasNext()) {
			if(this.nodes_list.iterator().next().getKey() == key) {
				return this.nodes_list.iterator().next();
			}
		}
		return null;
	}



	/**
	 * return the edge by the parameters (src , dest).
	 * return null if there isn't an edge between (src to dest).
	 */
	@Override
	public edge_data getEdge(int src, int dest) {
		// TODO Auto-generated method stub

		try {
			Node n_temp = null;
			int i = 0;
			while(i < this.nodes_list.size()) {
				if(this.nodes_list.get(i).getKey() == src) {
					n_temp = this.nodes_list.get(i);
					Edge e_temp = null;
					int j = 0;
					while(j < n_temp.getEdgeList().size()) {
						if(n_temp.getEdgeList().get(j).getDest() == dest) {
							e_temp = n_temp.getEdgeList().get(j);
							return e_temp;
						}
						j++;
					}
					return null;
				}
				i++;
			}
			return null;
		}
		catch(NullPointerException e) {
			return null;
		}
	}

	@Override
	public void addNode(node_data n) {
		// TODO Auto-generated method stub
		this.nodes_list.addLast((Node)n);

	}

	@Override
	public void connect(int src, int dest, double w) {
		// TODO Auto-generated method stub
		Edge e = null;
		
		for(int i = 0 ; i < this.nodes_list.size() ; i++) {
			if(this.nodes_list.get(i).getKey() == src) {
				e = new Edge(src , dest , w , null , 0);
				this.nodes_list.get(i).addEdge(e);
				return;
			}
		}
		
	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		LinkedList<node_data> list = new LinkedList<node_data>();
		node_data temp = null;
		for(int i = 0; i < this.nodes_list.size() ; i++) {
			temp = this.nodes_list.get(i);
			list.add(temp);
		}
		return list;	
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		LinkedList<edge_data> list = new LinkedList<edge_data>();
		Node temp = null;
		for(int i = 0; i < this.nodes_list.size() ; i++) {
			if(this.nodes_list.get(i).getKey() == node_id) {
				temp = this.nodes_list.get(i);
			}
		}
		for(int i = 0; i < temp.edge_list.size() ; i++) {
			list.add(temp.getEdgeList().get(i));
		}
		
		return list;
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		node_data temp = null;
		for(int i = 0 ; i < this.nodes_list.size() ; i++) {
			if(this.nodes_list.get(i).getKey() == key) {
				temp = this.nodes_list.get(i);
				this.nodes_list.remove(i);
			}
		}
		return temp;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		edge_data temp = null;
		for(int i = 0 ; i < this.nodes_list.size() ; i++) {
			if(this.nodes_list.get(i).getKey() == src) {
				temp = this.getEdge(src, dest);
				this.nodes_list.get(i).edge_list.remove(temp);
			}
		}
		return temp;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		int count = 0;
		count = this.nodes_list.size();
		return count;
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 0 ; i < this.nodes_list.size() ; i++) {
			count = count + this.nodes_list.get(i).edge_list.size();
		}
		
		return count;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0; 
	}


	@Override
	public String toString() {
		String g_print = "DGraph : ";
		int i = 0;
		int size = this.nodes_list.size();
		while(i < size) {
			g_print = g_print + "\n" + this.nodes_list.get(i);
			i++;
		}

		return g_print;
	}



}
