package alds;

//create a graph from adj mat or list

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Graph {

	List<Edge> edges = new ArrayList<Edge>();
	HashSet<Integer> vertices = new HashSet<Integer>();

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

	public Graph() {

	}

	public void addEdge(int src, int dest) {
		Edge edge = new Edge(src, dest, 1);
		edges.add(edge);
		vertices.add(src);
		vertices.add(dest);
	}

	public void addEdge(int src, int dest, int weight) {
		Edge edge = new Edge(src, dest, weight);
		edges.add(edge);
		vertices.add(src);
		vertices.add(dest);
	}

	public void printVertices() {
		for (Integer v : vertices) {
			System.out.println(v);

		}

	}

	public int getVertexCount() {
		int max = Integer.MIN_VALUE;
		for (Integer v : vertices) {
			if (v > max) {
				max = v;
			}
		}
		return max + 1;
	}

	public void printEdges() {
		for (Edge e : edges) {
			System.out.println(e.src + " -> " + e.dest + " = " + e.weight);

		}

	}

	public void sortEdges(final boolean order) {
		Collections.sort(edges, new Comparator<Edge>() {
			public int compare(Edge a, Edge b) {
				if (order) {
					return b.weight - a.weight;
				} else {
					return a.weight - b.weight;
				}
			}
		});
	}

	public ArrayList<Edge> getAllEdges(final boolean order) {

		return (ArrayList<Edge>) edges;
	}

}
