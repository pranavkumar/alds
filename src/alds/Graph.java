package alds;

//create a graph from adj mat or list

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Graph {

	List<Edge> edges = new ArrayList<Edge>();

	public static class Edge {
		int src;
		int dest;
		int weight;

		public Edge(int s, int d, int w) {
			this.src = s;
			this.dest = d;
			this.weight = w;
		}

	}

	public Graph(int vcount, int[][] graph) {
		for (int i = 0; i < vcount; i++) {
			for (int j = 0; j < vcount; j++) {
				if (graph[i][j] != 0) {
					Edge edge = new Edge(i, j, graph[i][j]);
					edges.add(edge);
				}
			}
		}
	}

	public ArrayList<Edge> getAllEdges(final boolean order) {
		Collections.sort(edges, new Comparator<Edge>() {
			public int compare(Edge a, Edge b) {
				if (order) {
					return b.weight - a.weight;
				} else {
					return a.weight - b.weight;
				}
			}
		});
		return (ArrayList) edges;
	}

}
