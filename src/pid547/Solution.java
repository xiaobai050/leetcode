package me.bai.LeetCode.pid547;

public class Solution {
	boolean[] hasVisited;
	int totle;
	int[][] M;

	public int findCircleNum(int[][] M) {
		this.M = M;
		totle = M.length;
		hasVisited = new boolean[totle];
		int circleSum = 0;
		for (int i = 0; i < totle; i++) {
			if (hasVisited[i])
				continue;
			dfs(i);
			circleSum++;
		}
		return circleSum;
	}

	/**
	 * 深度优先搜索，输入搜索起点，遍历所有朋友，遇到朋友继续找朋友
	 * 
	 * @param i:
	 */
	private void dfs(int self) {
		if (hasVisited[self])
			return;
		hasVisited[self] = true;

		for (int i = 0; i < totle; i++) {
			if (i == self)
				continue;
			if (isFriend(self, i))
				dfs(i);
		}
	}

	private boolean isFriend(int self, int i) {
		return M[self][i] == 1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] M = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		int rtn = solution.findCircleNum(M);
		System.out.println(rtn);
	}
}