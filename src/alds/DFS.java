package alds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class DFS {
	int mVcount;
	int mTarget = Integer.MAX_VALUE;
	int[][] mGraph;
	HashSet<Integer> visited = new HashSet<Integer>();
	Stack<Integer> st = new Stack<Integer>();

	public int getUnvisited(int v) {

		ArrayList<Integer> unvisited = new ArrayList<Integer>();

		for (int i = 0; i < mVcount; i++) {
			if (mGraph[v][i] != 0 && !visited.contains(i)) {
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
		visited.add(0);
		st.push(0);
		execute();

	}

	// dfs from src
	public DFS(int vcount, int[][] graph, int src) {
		mGraph = graph;
		mVcount = vcount;
		visited.add(src);
		st.push(src);
		execute();

	}

	// dfs from src to target
	public DFS(int vcount, int[][] graph, int src, int target) {
		mGraph = graph;
		mVcount = vcount;
		mTarget = target;
		visited.add(src);
		st.push(src);
		execute();

	}

	public void execute() {
		while (!st.isEmpty()) {
			int curr = st.peek();
			
			if (curr == mTarget) {
				while (!st.isEmpty()) {
					System.out.print(st.pop() + " ");
				}
				break;
			}
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
