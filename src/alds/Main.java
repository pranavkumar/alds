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

		
		
		int x = 1024;
		int c = 0;
		
		while (x != 1) {
			x = x >> 1;
			c++;
		}
		System.out.println(c);

	}

}
