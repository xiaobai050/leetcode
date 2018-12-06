package me.bai.LeetCode.pid673;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the number of longest increasing
 * subsequence.
 * 
 * Example 1: Input: [1,3,5,4,7] Output: 2 Explanation: The two longest
 * increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7]. Example 2: Input:
 * [2,2,2,2,2] Output: 5 Explanation: The length of longest continuous
 * increasing subsequence is 1, and there are 5 subsequences' length is 1, so
 * output 5. Note: Length of the given array will be not exceed 2000 and the
 * answer is guaranteed to be fit in 32-bit signed int.
 * 
 * 
 */
public class Solution {
	int[] len;
	int maxLen = 1;
	int maxCount = 1;
	int[] nums;

	int count = 1;

	public int findNumberOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		this.nums = nums;
		len = new int[nums.length];

		len[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (len[j] + 1 > len[i])//
						len[i] += len[j];
					if (len[j] + 1 == len[i]) {//s
						count++;
					}
				}
			}
		}
		System.out.println("nums:	" + Arrays.toString(nums));
		System.out.println("len:	" + Arrays.toString(len));
		return count;
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		int[] input = new int[] { 1, 3, 5, 4, 7 };
		// int[] input = new int[] { 2, 2, 2, 2 };
		int rtn = findNumberOfLIS(input);
		System.out.println(rtn);
	}
}
