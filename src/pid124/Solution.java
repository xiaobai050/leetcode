package me.bai.LeetCode.pid124;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 * 
 * For example: Given the below binary tree,
 * 
 * 1 / \ 2 3 Return 6.
 */

public class Solution {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		getMaxPathSum(root);
		return max;
	}

	private int getMaxPathSum(TreeNode node) {
		if (node == null)
			return 0;
		int leftSum = Integer.max(getMaxPathSum(node.left), 0);
		int rightSum = Integer.max(getMaxPathSum(node.right), 0);
		max = Integer.max(max, node.val + leftSum + rightSum);
		return node.val + Integer.max(leftSum, rightSum);
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(6);
		root.right = new TreeNode(-3);
		root.right.left = new TreeNode(-6);
		root.right.right = new TreeNode(2);
		root.right.right.right = new TreeNode(2);
		root.right.right.right.left = new TreeNode(-6);
		root.right.right.right.right = new TreeNode(-6);
		int sum = maxPathSum(root);
		System.out.println("sum=" + sum);
	}
}
