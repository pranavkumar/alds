package alds;

import java.util.Scanner;

public class Util {
	public static void printMatrix(int m, int n, int[][] mat) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] readMatrix(int vcount) {
		Scanner in = new Scanner(System.in);
		int[][] mat = new int[vcount][vcount];
		for (int i = 0; i < vcount; i++) {
			for (int j = 0; j < vcount; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		in.close();
		return mat;
	}

}
