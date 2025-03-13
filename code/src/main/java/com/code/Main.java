package com.code;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<List<Integer>> result = BackTracing.permute(new int[] { 1, 1, 2 });
		for (List<Integer> list : result) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}