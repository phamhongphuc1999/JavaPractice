package com.code;

public class Main {
	public static void main(String[] args) {
		int[] result = Simple.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 2, 3, 4 });
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}