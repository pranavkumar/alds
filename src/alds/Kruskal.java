package alds;

import java.util.ArrayList;

import alds.Graph.Edge;

public class Kruskal {

	public Kruskal(Graph g) {
		g.sortEdges(false);
		ArrayList<Edge> edges = g.getAllEdges(false);
		DisjointSets ds = new DisjointSets();
		ds.makesets(g.getVertexCount());
		ArrayList<Edge> res = new ArrayList<Edge>();

		for (Edge e : edges) {
			if (ds.findset(e.src) != ds.findset(e.dest)) {
				res.add(e);
				ds.union(ds.findset(e.src), ds.findset(e.dest));
			}
		}

		for (Edge e : res) {
			System.out.println(e.src + " -> " + e.dest + " = " + e.weight);
		}

	}

}
