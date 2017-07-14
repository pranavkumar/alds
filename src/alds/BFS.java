package alds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	int mVcount;
	int mTarget = Integer.MAX_VALUE;
	int[][] mGraph;
	HashSet<Integer> visited = new HashSet<Integer>();
	Queue<Integer> q = new LinkedList<Integer>();

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

	public BFS(int vcount, int[][] graph) {
		mGraph = graph;
		mVcount = vcount;
		visited.add(0);
		q.add(0);
		execute();

	}

	// bfs from a src
	public BFS(int vcount, int[][] graph, int src) {
		mGraph = graph;
		mVcount = vcount;
		visited.add(src);
		q.add(src);
		execute();

	}
	
	
	public BFS(int vcount, int[][] graph, int src, int target) {
		mGraph = graph;
		mVcount = vcount;
		mTarget = target;
		visited.add(src);
		q.add(src);
		execute();

	}

	public void execute() {
		while (!q.isEmpty()) {
			int curr = q.peek();
			
			
			
			/*
			if (curr == mTarget) {
				while (!q.isEmpty()) {
					System.out.print(q.poll() + " ");
				}
				break;
			}
			*/
			if (getUnvisited(curr) != Integer.MIN_VALUE) {
				int next = getUnvisited(curr);
				visited.add(next);
				q.add(next);
			} else {
				System.out.print(q.poll() + " ");
			}
		}
	}

}
