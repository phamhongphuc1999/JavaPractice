package com.code;

public class Main {
	public static void main(String[] args) {
		String source = "ADOBECODEBANC";
		String target = "ABC";

		String _result = WindowSliding.minWindow(source, target);
		System.out.println("result: " + _result + ", len: " + _result.length());
	}
}