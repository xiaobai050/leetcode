package pid174;

import java.util.Arrays;

public class Solution {
	int[][] totleLoss; // 总共‘掉’血，注意正负号！
	int[][] dungeon;
	int rowMax;
	int columnMax;

	public int calculateMinimumHP(int[][] dungeon) {
		rowMax = dungeon.length;
		if (rowMax == 0)
			return 1;
		this.dungeon = dungeon;
		columnMax = dungeon[0].length;

		totleLoss=dungeon;

		for (int row = rowMax - 1; row >= 0; row--)
			for (int column = columnMax - 1; column >= 0; column--) {
				totleLoss[row][column] += minNeighbor(row, column);
				if (totleLoss[row][column] > 0)
					totleLoss[row][column] = 0;
			}

//		 System.out.println();
//		 for(int i=0;i<rowMax;i++)
//		 System.out.println(Arrays.toString(totleLoss[i]));

		return 1 - totleLoss[0][0];

	}

	private int max(int i, int j) {
		return i > j ? i : j;
	}
	
	private int minNeighbor(int row, int column) {
		if (row < rowMax - 1) {
			if (column < columnMax - 1)
				return max(totleLoss[row][column + 1], totleLoss[row + 1][column]);
			else
				return totleLoss[row + 1][column];
		} else {
			if (column < columnMax - 1)
				return totleLoss[row][column + 1];
			else
				return 0;
		}
	}
}