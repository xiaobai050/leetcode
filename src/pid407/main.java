package pid407;

import java.util.Arrays;

/**
 * 407. Trapping Rain Water II
 * 
 * Given an m x n matrix of positive integers representing the height of each
 * unit cell in a 2D elevation map, compute the volume of water it is able to
 * trap after raining.
 * 
 * Note: Both m and n are less than 110. The height of each unit cell is greater
 * than 0 and is less than 20,000.
 * 
 * Example:
 * 
 * Given the following 3x6 height map:[ 
 * 
 * [1,4,3,1,3,2], 
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]] 
 * 
 * Return 4.
 * 
 * The above image represents the elevation map[
 * 
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]] 
 * 
 * before the rain.
 * 
 * After the rain, water are trapped between the blocks. The total volume of
 * water trapped is 4.
 * 
 * @author °×
 *
 */

public class main {
	public static void main(String[] args) {

		int[][][] testTable = {
				{
					{1,4,3,1,3,2},
					{3,2,1,3,2,4},
					{2,3,3,2,3,1}
				},
				{
					{1,4,3,1,3,2},
					{3,0,2,3,2,4},
					{2,3,3,2,3,1}
				},
				{
					{1,4,1,1,3,2},
					{3,2,1,3,2,4},
					{2,3,1,2,3,1},
					{2,3,3,2,3,1}
				},
			};

		for (int [][]ito : testTable) {
			test(ito);
		}

	}

	private static void test(int[][] ito) {
		System.out.println(">> ");
		for(int[]itoo:ito)
			System.out.println(Arrays.toString(itoo));
		System.out.println();

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		Object rtn = solution.trapRainWater(ito);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println("                              << " + rtn);
		System.out.println("--------------------------------------ºÄÊ±£º" + (end - begin) + "ms");

	}
}
