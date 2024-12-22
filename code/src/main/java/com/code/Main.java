package com.code;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> result = Simple.getRow(4);
		for (int i : result) {
			System.out.println(i);
		}
	}
}