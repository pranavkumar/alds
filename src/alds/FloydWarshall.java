package alds;

public class FloydWarshall {
	int[][] mAdjMat;
	int[][] dist;

	final static int inf = 9999;

	public FloydWarshall(int vcount, int[][] adjMat) {
		mAdjMat = adjMat;
		// initialize distance from self to 0 and from others to infinity;
		dist = new int[vcount][vcount];
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
				dist[i][j] = mAdjMat[i][j];

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
