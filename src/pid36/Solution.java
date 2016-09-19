package pid36;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		// 检测一行
		for (int i = 0; i < 9; i++) {
			boolean[] check = new boolean[9];
			for (int j = 0; j < 9; j++) {
				int temp = board[i][j];
				if (temp != '.') {
					if (check[temp - '1'])
						return false;
					else
						check[temp - '1'] = true;
				}
			}
		}

		// 检测一列
		for (int i = 0; i < 9; i++) {
			boolean[] check = new boolean[9];
			for (int j = 0; j < 9; j++) {
				int temp = board[j][i];
				if (temp != '.') {
					if (check[temp - '1'])
						return false;
					else
						check[temp - '1'] = true;
				}
			}
		}

		// 检测一格
		for (int bigRow = 0; bigRow < 3; bigRow++) {
			for (int bigColumn = 0; bigColumn < 3; bigColumn++) {

				boolean[] check = new boolean[9];

				for (int smallRow = 0; smallRow < 3; smallRow++) {
					for (int smallColumn = 0; smallColumn < 3; smallColumn++) {

						int temp = board[bigRow * 3 + smallRow][bigColumn * 3 + smallColumn];

						if (temp != '.') {
							if (check[temp - '1'])
								return false;
							else
								check[temp - '1'] = true;
						}
					}
				}
			}
		}

		return true;

	}
}
