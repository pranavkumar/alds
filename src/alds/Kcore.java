package alds;

import java.util.ArrayList;
import java.util.Stack;

public class Kcore {
    public static void kcore(int[][] g, int n, int c) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Integer> removable = new ArrayList<>();
        st.add(0);
        v.add(0);


        while (!st.isEmpty()) {
            int curr = st.peek();
            int cores = 0;
            int nb = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (g[curr][i] == 1) {
                    cores++;
                    if (!v.contains(i)) {
                        nb = i;
                    }
                }
            }
            if (nb != Integer.MIN_VALUE) {
                st.push(nb);
                v.add(nb);
            } else {
                int last = st.pop();
                if (cores < c) {
                    removable.add(last);
                }
            }
        }

        for (int i : removable) {
            System.out.println(i);
        }


    }
}
