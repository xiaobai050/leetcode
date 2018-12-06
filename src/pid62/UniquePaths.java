package me.bai.study.leetcode;

class UniquePaths {
	public static void main(String[] args) {
		int r = new UniquePaths().uniquePaths(1, 2);
		System.out.println(r);
	}

	public int uniquePaths(int m, int n) {
		int[][] arr = new int[m][n];
		arr[0][0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(i+j==0)continue;
				arr[i][j] = f(arr, i - 1, j) + f(arr, i, j - 1);
			}
		}
		return arr[m - 1][n - 1];
	}

	private int f(int[][] arr, int i, int j) {
		if (i < 0 || j < 0) return 0;
		return arr[i][j];
	}
}