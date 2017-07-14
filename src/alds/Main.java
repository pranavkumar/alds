package alds;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph();
		g.addEdge(0, 1, 10);
		g.addEdge(0, 2, 6);
		g.addEdge(0, 3, 5);
		g.addEdge(1, 3, 15);
		g.addEdge(2, 3, 4);
		g.addEdge(3, 0,2);

		// Kruskal k = new Kruskal(g);
		int[][] adj = g.getAdjMat();
		int vcount = g.getVertexCount();
		Util.printMatrix(vcount, vcount, adj);
		
		DFS dfs = new DFS(vcount,adj, 2);
		
		
		
	}

}
