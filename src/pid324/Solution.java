package me.bai.LeetCode.pid324;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 * 
 * Example: (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4,
 * 1, 5, 1, 6]. (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2,
 * 3, 1, 3, 1, 2].
 * 
 * Note: You may assume all input has valid answer.
 * 
 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class Solution {
	int[] nums = null;

	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);

		this.nums = nums;
		int n = nums.length;
		int m;
		if (n % 2 == 0) {
			m = (nums[n / 2 - 1] + nums[n / 2]) / 2;
		} else {
			m = nums[n / 2];
		}
		int[] rtn = new int[n];
		for (int i = 0; i < n; i++) {
			rtn[i] = A(i);
		}

		for (int num : rtn) {
			System.out.println(num);
		}

		for (int i = 0; i < n; i++) {
			nums[i] = rtn[i];
		}

	}

	private int A(int n) { 
		if (n % 2 == 0) {
			return nums[n / 2];
		} else {
			return nums[(nums.length+1) / 2+n / 2];
		}
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		int[] nums = new int[] { 1, 1, 2, 1, 2, 2, 1};
		wiggleSort(nums);
		
	}
}
