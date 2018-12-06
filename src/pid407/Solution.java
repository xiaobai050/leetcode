package me.bai.LeetCode.pid407;

import java.util.Arrays;

/**
 * Given an m x n matrix of positive integers representing the height of each
 * unit cell in a 2D elevation map, compute the volume of water it is able to
 * trap after raining.
 * 
 * Note: Both m and n are less than 110. The height of each unit cell is greater
 * than 0 and is less than 20,000.
 * 
 * Example:
 * 
 * Given the following 3x6 height map: [ [1,4,3,1,3,2], [3,2,1,3,2,4],
 * [2,3,3,2,3,1] ]
 * 
 * Return 4.
 * 
 * The above image represents the elevation map
 * [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
 * 
 * 
 * After the rain, water are trapped between the blocks. The total volume of
 * water trapped is 4.
 */
public class Solution {
	Dir[] dirs = { new Dir("上", -1, 0), new Dir("下", 1, 0), new Dir("左", 0, -1), new Dir("右", 0, 1) };
	boolean[][][] visited = null;
	int[][] heightMap = null;
	int collectedWater = 0;
	int row = 0;
	int column = 0;

	public int trapRainWater(int[][] heightMap) {
		if (heightMap.length == 0) {
			return 0;
		}
		row = heightMap.length;
		if (heightMap[0].length == 0) {
			return 0;
		}
		column = heightMap[0].length;
		this.heightMap = heightMap;
		this.visited = new boolean[row][column][20001];
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				fillToHeight(i, j, getLowestWall(i, j));
			}
		}

		return collectedWater;
	}

	private int fillToHeight(int x, int y, int aim) {
		int ground = heightMap[x][y];
		if (ground >= aim) {
			return aim;
		}
		if (isSide(x, y)) {
			return min(ground, aim);
		}
		aim = min(aim, getLowestWall(x, y));

		if (visited[x][y][aim]) {
			return aim;
		}
		visited[x][y][aim] = true;

		System.out.println("准备把" + x + "，" + y + "填充到" + aim + "高度");

		for (int i = 0; i < 4; i++) {
			Dir dir = dirs[i];
			int m = dir.xx;
			int n = dir.yy;
			int neighbor = h(x + m, y + n);
			if (neighbor >= aim) {// 遇到高墙
				System.out.println("遇到" + dir.name + "方高墙");
				continue;
			}
			if (neighbor > ground) {// 遇到矮墙
				int result = fillToHeight(x, y, neighbor);
				if (result == neighbor)
					System.out.println("遇到" + dir.name + "方矮墙，并把aim调低至" + aim);
				continue;
			}

			if (neighbor < ground) {// 遇到坑
				System.out.println("遇到" + dir.name + "方的坑" + neighbor);
				int result = fillToHeight(x + m, y + n, ground);
				if (result < aim) {// 没填满
					System.out.println(x + "," + y + dir.name + "方的坑没填满，只填到了" + result);
					return result;
				}
			}

			int result = fillToHeight(x + m, y + n, aim);
			if (result < aim) {// 没填满
				return result;
			}

		}
		collectedWater += (aim - heightMap[x][y]);
		heightMap[x][y] = aim;
		return aim;
	}

	private boolean isSide(int x, int y) {
		return x <= 0 || y <= 0 || x >= row - 1 || y >= column - 1;
	}

	private int getLowestWall(int x, int y) {
		int ground = h(x, y);
		int wall = ground;
		for (int i = 0; i < 4; i++) {
			Dir dir = dirs[i];
			int m = dir.xx;
			int n = dir.yy;
			int tmp = h(x + m, y + n);
			// if (tmp > ground) {
			// wall = min(wall, tmp);
			wall = max(wall, tmp);
			// }
		}
		return wall;
	}

	private int max(int i, int j) {
		return Integer.max(i, j);
	}

	private int min(int i, int j) {
		return Integer.min(i, j);
	}

	private int h(int x, int y) {
		return heightMap[x][y];
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		// int sum = trapRainWater(new int[][] { { 1, 4, 3, 1, 3, 2 }, { 3, 2,
		// 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } });
		int sum = trapRainWater(new int[][] { { 12, 13, 1, 12 }, { 13, 4, 13, 12 }, { 13, 8, 10, 12 },
				{ 12, 13, 12, 12 }, { 13, 13, 13, 13 } });
		System.out.println("一共流入了" + sum);
	}
}

class Dir {
	String name;
	int xx;
	int yy;

	public Dir(String name, int xx, int yy) {
		this.name = name;
		this.xx = xx;
		this.yy = yy;
	}

}
