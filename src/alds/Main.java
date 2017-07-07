package alds;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int vcount = in.nextInt();
		int[][] mat = new int[vcount][vcount];
		for (int i = 0; i < vcount; i++) {
			for (int j = 0; j < vcount; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		in.close();

		//DFS dfs = new DFS(vcount, mat);
		
		//BFS bfs = new BFS(vcount, mat);
		//Prims prims = new Prims(vcount, mat);
		
		Dijkstra d = new Dijkstra(vcount, mat, 0);

	}

}
