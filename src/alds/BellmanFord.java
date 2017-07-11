package alds;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*
 * https://stackoverflow.com/questions/19482317/bellman-ford-vs-dijkstra-under-what-circumstances-is-bellman-ford-better
 * Bellman-Ford algorithm is a single-source shortest path algorithm, so when you have negative edge weight then it can detect negative cycles in a graph.
 * The only difference between two is that Bellman Ford is capable also to handle negative weights whereas Dijkstra Algorithm can only handle positives.
 * - Rahul Tripathi	
 */

public class BellmanFord {

	public static final int inf = 10000;

	public BellmanFord(int vcount, int[][] graph, int src) {
		HashMap<Integer, Integer> distmap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> srcmap = new HashMap<Integer, Integer>();

		for (int i = 0; i < vcount; i++) {
			if (i == src) {
				distmap.put(i, 0);
			} else {
				distmap.put(i, Integer.MAX_VALUE);
			}
		}

		for (int i = 0; i < vcount - 1; i++) {
			for (int u = 0; u < vcount; u++) {
				for (int v = 0; v < vcount; v++) {
					if (graph[u][v] != 0) {
						if (distmap.get(u) != Integer.MAX_VALUE
								&& distmap.get(v) > distmap.get(u)
										+ graph[u][v]) {
							distmap.put(v, distmap.get(u) + graph[u][v]);
							srcmap.put(v, u);
						}
					}

				}
			}
		}

		Iterator<Entry<Integer, Integer>> it = distmap.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, Integer> pair = it.next();
			System.out.println(src + " -> " + pair.getKey() + " = "
					+ pair.getValue());
		}

	}

}
