package alds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph();
		g.addEdge(0, 1, 2);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 4, 3);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 3);
		g.addEdge(2, 1, 1);

		int[][] adj = g.getAdjMat();
		int vcount = g.getVertexCount();
		Util.printMatrix(vcount, vcount, adj);

		DFS dfs = new DFS(vcount, adj, 0);
		
		
		

	}

}
