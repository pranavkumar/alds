package alds;


import java.util.ArrayList;
import java.util.Stack;

public class TopSort {
    public TopSort(int[][] g, int n) {

        Stack<Integer> ost = new Stack<>();
        ArrayList<Integer> v = new ArrayList<>();

        while (ost.size() <= n) {

            Stack<Integer> tst = new Stack<>();
            int unvisited = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (!v.contains(i)) {
                    unvisited = i;
                    break;
                }
            }
            if (unvisited == Integer.MIN_VALUE) {
                while (!ost.isEmpty()) {
                    System.out.println(ost.pop());
                }
                break;
            } else {

                tst.add(unvisited);
                v.add(unvisited);
                while (!tst.isEmpty()) {
                    int curr = tst.peek();
                    int child = Integer.MIN_VALUE;
                    for (int i = 0; i < n; i++) {
                        if (g[curr][i] == 1 && !v.contains(i)) {
                            child = i;
                        }
                    }
                    if (child != Integer.MIN_VALUE) {
                        tst.add(child);
                        v.add(child);
                    } else {
                        int last = tst.pop();
                        ost.add(last);
                    }
                }
            }
        }

        for (int node : ost) {
            System.out.print(node + " ");
        }

    }
}
