package me.bai.LeetCode.pid120;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */

public class Solution {
	List<List<Integer>> triangle = null;

	public int minimumTotal(List<List<Integer>> triangle) {
		this.triangle = triangle;
		int size = triangle.size();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				set(i, j, Math.min(getLeft(i, j), getRight(i, j)) + get(i, j));
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			min = Math.min(min, triangle.get(size - 1).get(i));
		}
		return min;
	}

	private void set(int i, int j, int value) {
		triangle.get(i).set(j, value);
	}

	private int get(int i, int j) {
		if (i < 0) {
			return 0;
		}
		return triangle.get(i).get(j);
	}

	private int getLeft(int i, int j) {
		if (j == 0) {
			return get(i - 1, j);
		}
		return get(i - 1, j - 1);
	}

	private int getRight(int i, int j) {
		if (j == i) {
			return get(i - 1, j - 1);
		}
		return get(i - 1, j);
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		triangle.add(list1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		triangle.add(list2);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		triangle.add(list3);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		triangle.add(list4);

		System.out.println(minimumTotal(triangle));
	}
}
