package me.bai.LeetCode.pid628;

import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers My SubmissionsBack To Contest User
 * Accepted: 993 User Tried: 1210 Total Accepted: 1017 Total Submissions: 2204
 * Difficulty: Easy Given an integer array, find three numbers whose product is
 * maximum and output the maximum product.
 * 
 * Example 1: Input: [1,2,3] Output: 6 Example 2: Input: [1,2,3,4] Output: 24
 * Note: The length of the given array will be in range [3,104] and all elements
 * are in the range [-1000, 1000]. Multiplication of any three numbers in the
 * input won't exceed the range of 32-bit signed integer.
 */
public class Solution {
	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int size = nums.length;
		int m1 = nums[size - 1] * nums[size - 2] * nums[size - 3];
		int m2 = nums[size - 1] * nums[size - 2] * nums[0];
		int m3 = nums[size - 1] * nums[0] * nums[1];
		int m4 = nums[0] * nums[1] * nums[2];
		return max(max(m1, m2), max(m3, m4));

	}

	private int max(int m1, int m2) {
		return Integer.max(m1, m2);
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {

	}
}
