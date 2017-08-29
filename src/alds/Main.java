package alds;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] g = new int[n][n];

        for (int i = 0; i < k; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            g[a][b] = in.nextInt();
        }

        FordFulkerson fordFulkerson = new FordFulkerson(0, 4, g, n);


    }

}
