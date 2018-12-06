package me.bai.LeetCode.pid90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,2], a solution is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class Solution {

	List<List<Integer>> lists = new ArrayList<List<Integer>>();

	int[] numTable;
	int[] numCountTable;
	int totalOffset = 0;

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		Arrays.sort(nums);
		numTable = new int[nums.length];
		numCountTable = new int[nums.length];
		numTable[0] = nums[0];
		for (int num : nums) {
			if (num != numTable[totalOffset]) {
				totalOffset++;
				numTable[totalOffset] = num;
			}
			numCountTable[totalOffset]++;
		}

		// System.out.println(Arrays.toString(numTable));
		// System.out.println(Arrays.toString(numCountTable));

		assemble(new ArrayList<Integer>(), 0);

		return lists;

	}

	private void assemble(ArrayList<Integer> base, int offset) {
		if (offset > totalOffset) {
			lists.add(base);
			return;
		}
		int num = numTable[offset];
		int times = numCountTable[offset];
		assemble((ArrayList<Integer>) base.clone(), offset + 1);
		for (int i = 0; i < times; i++) {
			base.add(num);
			assemble((ArrayList<Integer>) base.clone(), offset + 1);
		}

	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		int[] nums = new int[] { 1, 2, 2 };
		System.out.println((subsetsWithDup(nums)));
	}
}