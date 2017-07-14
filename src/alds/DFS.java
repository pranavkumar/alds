package alds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class DFS {
	int mVcount;
	int[][] mGraph;
	HashSet<Integer> visited = new HashSet<Integer>();

	public int getUnvisited(int v) {

		ArrayList<Integer> unvisited = new ArrayList<Integer>();

		for (int i = 0; i < mVcount; i++) {
			if (mGraph[v][i] !=0  && !visited.contains(i)) {
				unvisited.add(i);
			}
		}
		if (unvisited.isEmpty()) {
			return Integer.MIN_VALUE;
		} else {
			Collections.sort(unvisited);
			return unvisited.get(unvisited.size() - 1);
		}

	}

	public DFS(int vcount, int[][] graph) {
		mGraph = graph;
		mVcount = vcount;

		Stack<Integer> st = new Stack<Integer>();
		visited.add(0);
		st.push(0);

		while (!st.isEmpty()) {
			int curr = st.peek();
			if (getUnvisited(curr) != Integer.MIN_VALUE) {
				int next = getUnvisited(curr);
				visited.add(next);
				st.push(next);
			} else {
				System.out.print(st.pop() + " ");
			}
		}

	}

}
