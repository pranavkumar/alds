package alds;

import java.util.*;

public class FordFulkerson {
    public FordFulkerson(int s, int t, int[][] g, int n) {

        int max_flow = 0;


        while (true) {
            ArrayList<Integer> v = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            HashMap<Integer, Integer> points = new HashMap<>();
            v.add(s);
            q.add(s);


            while (!q.isEmpty()) {
                int curr = q.peek();
                int nb = Integer.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    if (g[curr][i] != 0 && !v.contains(i)) {
                        nb = i;
                        break;
                    }
                }
                if (nb != Integer.MIN_VALUE) {

                    q.add(nb);
                    v.add(nb);

                    points.put(nb, curr);
                } else {
                    int last = q.poll();

                }
            }

            HashMap<Integer, Integer> path = new HashMap<>();

            int dest = t;
            while (true) {
                if (dest == s) break;
                if (points.get(dest) != null) {
                    int src = points.get(dest);
                    path.put(src, dest);
                    dest = src;
                } else {
                    System.out.println(max_flow);
                    return;
                }
                ;
            }

            Iterator it = path.entrySet().iterator();
            ArrayList<Integer> flows = new ArrayList<>();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) it.next();
                flows.add(g[pair.getKey()][pair.getValue()]);
            }
            Collections.sort(flows);
            int min_flow = flows.get(0);
            max_flow += min_flow;
            Iterator _it = path.entrySet().iterator();
            while (_it.hasNext()) {
                Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) _it.next();
                int a = pair.getKey();
                int b = pair.getValue();
                g[a][b] -= min_flow;
                g[b][a] += min_flow;
            }


        }


    }


}
