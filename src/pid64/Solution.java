package me.bai.LeetCode.pid64;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */
public class Solution {
	int[][] grid;

	public int minPathSum(int[][] grid) {
		int rm = grid.length;
		int cm = grid[0].length;
		this.grid = grid;
		for (int r = 0; r < rm; r++) {
			for (int c = 0; c < cm; c++) {
				if (r + c == 0)
					continue;
				grid[r][c] += Integer.min(up(r, c), left(r, c));
			}
		}
		return grid[rm - 1][cm - 1];
	}

	private int left(int r, int c) {
		if (c == 0)
			return Integer.MAX_VALUE;
		return grid[r][c - 1];
	}

	private int up(int r, int c) {
		if (r == 0)
			return Integer.MAX_VALUE;
		return grid[r - 1][c];
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int s = minPathSum(grid);
		System.out.println(s);
	}
}
