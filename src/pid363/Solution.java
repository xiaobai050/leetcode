package pid363;

public class Solution {

	public int maxSumSubmatrix(int[][] matrix, int k) {

		int columnMax = matrix[0].length;
		int rowMax = matrix.length;

		int rowBegin = 0, rowEnd = 0, columnBegin = 0, columnEnd = 0;
		int sumMax = -1000000000;

		int[][][] rowFragment = new int[rowMax][columnMax][columnMax];

		for (int row = 0; row < rowMax; row++)
			for (int begin = 0; begin < columnMax; begin++) {
				int value = 0;
				for (int end = begin; end < columnMax; end++) {
					value += matrix[row][end];
					rowFragment[row][begin][end] = value;
				}
			}

		for (columnBegin = 0; columnBegin < columnMax; columnBegin++) {
			int value1 = 0;
			for (columnEnd = columnBegin; columnEnd < columnMax; columnEnd++) {
				int value2 = value1;
				for (rowBegin = 0; rowBegin < rowMax; rowBegin++) {
					int value3 = value2;
					for (rowEnd = rowBegin; rowEnd < rowMax; rowEnd++) {
						value3 += rowFragment[rowEnd][columnBegin][columnEnd];
						if (value3 <= k)
							sumMax = sumMax > value3 ? sumMax : value3;
					}
				}
			}
		}

		return sumMax;
	}
	
}