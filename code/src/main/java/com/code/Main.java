package com.code;

import com.code.utilities.TreeNode;
import com.code.utilities.TreeNodeUtility;

public class Main {
	public static void main(String[] args) {
		TreeNode p = TreeNodeUtility.convertArrayToTree(new Integer[] { 1, null, 2 });
		int result = DeepFirstSearch.maxDepth(p);
		System.err.println(result);
	}
}