package com.code;

import com.code.utilities.TreeNode;
import com.code.utilities.TreeNodeUtility;

public class Main {
	public static void main(String[] args) {
		TreeNode p = TreeNodeUtility.convertArrayToTree(new Integer[] { 1, 2, 1 });
		TreeNode q = TreeNodeUtility.convertArrayToTree(new Integer[] { 1, 1, 2 });
		boolean result = DeepFirstSearch.isSameTree(p, q);
		System.err.println(result);
	}
}