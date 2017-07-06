package alds;

/*
 * multi source shortest path. edges can have negative weight but no negative cycle allowed.  
 */

public class FloydWarshall {
	
	final static int inf = 9999;

	public FloydWarshall(int vcount, int[][] adjMat) {
		
		// initialize distance from self to 0 and from others to infinity;
		int[][] dist = new int[vcount][vcount];
		for (int i = 0; i < vcount; i++) {
			for (int j = 0; j < vcount; j++) {
				if (i == j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = inf;
				}
			}
		}

		// initialize distance using adjacency matrix;
		for (int i = 0; i < vcount; i++) {
			for (int j = 0; j < vcount; j++) {
				dist[i][j] = adjMat[i][j];

			}
		}

		for (int k = 0; k < vcount; k++) {
			for (int i = 0; i < vcount; i++) {
				for (int j = 0; j < vcount; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		Util.printMatrix(vcount, vcount, dist);

	}

}
