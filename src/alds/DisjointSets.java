package alds;

import java.util.ArrayList;
import java.util.List;

public class DisjointSets {

	List<Node> sets = new ArrayList<Node>();

	public class Node {
		int value;
		Node parent;
		int rank;

		public void init(int value, Node node) {
			this.value = value;
			this.parent = node;
			this.rank = 0;
		}

	}

	public Node get(int value) {
		for (Node n : sets) {
			if (n.value == value) {
				return n;
			}

		}
		return null;
	}

	public void makesets(int vcount) {
		for (int i = 0; i < vcount; i++) {
			Node node = new Node();
			node.init(i, node);
			sets.add(node);
		}
	}

	public int findset(int a) {
		for (Node set : sets) {
			if (set.value == a) {
				if (set.parent.value == a) {
					return a;
				} else {
					return findset(set.parent.value);
				}
			}
		}
		return Integer.MIN_VALUE;
	}

	public void union(int a, int b) {
		a = findset(a);
		b = findset(b);
		Node A = get(a);
		Node B = get(b);

		if (A.rank > B.rank) {
			B.parent = A;
			A.rank = A.rank + 1;
		} else if (B.rank > A.rank) {
			A.parent = B;
			B.rank = B.rank + 1;
		} else {
			if (A.value < B.value) {
				B.parent = A;
				A.rank = A.rank + 1;
			} else if (B.value < A.value) {
				A.parent = B;
				B.rank = B.rank + 1;
			} else {
				throw new SameNodeUnionException("Can not union same nodes.");
			}
		}

	}

	public class SameNodeUnionException extends RuntimeException {
		SameNodeUnionException(String msg) {
			super(msg);
		}
	}

}
