package alds;

import java.util.*;
import java.util.Map.Entry;

public class Prims {
	public class HeapMap {
		HashMap<Character, Integer> map;

		public HeapMap() {
			map = new HashMap<Character, Integer>();
		}

		public void set(char c, int v) {
			map.put(c, v);

		}

		public int get(char c) {
			if (map.containsKey(c)) {
				return map.get(c);
			} else {
				return Integer.MIN_VALUE;
			}

		}

		public char extractMin() {
			int min = Integer.MAX_VALUE;
			char c = 'z';
			Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) it
						.next();
				if (pair.getValue() < min) {
					min = pair.getValue();
					c = pair.getKey();
				}
			}
			map.remove(c);
			return c;
		}

		public boolean isEmpty() {
			return map.isEmpty();
		}

	}

	public Prims(int vcount, int[][] graph) {
		HashMap<Character, String> edgeMap = new HashMap<Character, String>();
		HeapMap heapMap = new HeapMap();
		for (int i = 0; i < vcount; i++) {
			if (i == 0) {
				heapMap.set('a', 0);
			} else {
				heapMap.set((char) ((int) 'a' + i), Integer.MAX_VALUE);
			}
		}

		while (!heapMap.isEmpty()) {
			char current = heapMap.extractMin();
			if (edgeMap.containsKey(current)) {
				System.out.print(edgeMap.get(current) + " ");
			}
			int index = (int) current - (char) 'a';
			for (int i = 0; i < vcount; i++) {
				char next = (char) (i + (char) 'a');
				if (graph[index][i] > 0
						&& heapMap.get(next) != Integer.MIN_VALUE) {

					if (heapMap.get(next) > graph[index][i]) {
						heapMap.set(next, graph[index][i]);
						edgeMap.put(next,
								String.valueOf(current) + String.valueOf(next));
					}
				}
			}

		}

	}

}
