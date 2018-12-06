package me.bai.LeetCode.pid503;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 * 
 * Example 1: Input: [1,2,1] Output: [2,-1,2] Explanation: The first 1's next
 * greater number is 2; The number 2 can't find next greater number; The second
 * 1's next greater number needs to search circularly, which is also 2. Note:
 * The length of given array won't exceed 10000.
 * 
 * 
 */
public class Solution {

	public int[] nextGreaterElements(int[] nums) {
		int size = nums.length;
		int[] res = new int[size];

		Stack<Integer> s = new Stack<Integer>();

		for (int i = size * 2; i > 0; i--) {
			while (true) {
				if (s.isEmpty()) {
					s.push(nums[i % size]);
					res[i % size] = -1;
					break;
				} else {
					int top = s.peek();
					if (top > nums[i % size]) {
						s.push(nums[i % size]);
						res[i % size] = top;
						break;
					} else {
						s.pop();
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		new Solution().test();

	}

	private void test() {
		int[] input = new int[] { 3, 8, 4, 1, 2 };
		int[] output = nextGreaterElements(input);
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(output));
	}
}
