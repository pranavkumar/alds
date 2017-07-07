package alds;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Dijkstra {

	public class HeapMap {
		HashMap<Integer, Integer> map;

		public HeapMap() {
			map = new HashMap<Integer, Integer>();
		}

		public void set(int v, int w) {
			map.put(v, w);
		}

		public int get(int v) {
			if (map.containsKey(v)) {
				return map.get(v);
			} else {
				return Integer.MIN_VALUE;
			}
		}

		public int[] extractMin() {
			int min = Integer.MAX_VALUE;
			int key = Integer.MAX_VALUE;
			Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) it
						.next();
				if (pair.getValue() < min) {
					min = pair.getValue();
					key = pair.getKey();
				}
			}

			int[] ret = new int[2];
			ret[0] = key;
			ret[1] = min;
			map.remove(key);

			return ret;

		}

		public boolean isEmpty() {
			return map.isEmpty();
		}

	}

	public Dijkstra(int vcount, int[][] graph, int source) {
		HashMap<Integer, Integer> origin = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();

		HeapMap heapMap = new HeapMap();

		// initialize distance from self to 0, rest to infinity
		for (int i = 0; i < vcount; i++) {
			if (i == source) {
				heapMap.set(i, 0);
			} else {
				heapMap.set(i, Integer.MAX_VALUE);
			}
		}

		while (!heapMap.isEmpty()) {
			int[] pair = heapMap.extractMin();
			int current = pair[0];
			int value = pair[1];
			dist.put(current, value);
			for (int i = 0; i < vcount; i++) {
				if (graph[current][i] > 0
						&& heapMap.get(i) != Integer.MIN_VALUE) {
					if (value + graph[current][i] < heapMap.get(i)) {
						heapMap.set(i, value + graph[current][i]);
						origin.put(i, current);
					}
				}
			}
		}

		Iterator<Map.Entry<Integer, Integer>> it = dist.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) it
					.next();
			System.out.println(source + " -> " + pair.getKey() + " = "
					+ pair.getValue());
		}

	}
}
