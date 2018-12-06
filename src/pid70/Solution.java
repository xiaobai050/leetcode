package me.bai.LeetCode.pid70;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 *
 */
public class Solution {
	public int climbStairs(int n) {
		int last = 1;
		int sum = 1;
		for (int i = 1; i < n; i++) {
			int t = sum;
			sum += last;
			last = t;
		}
		return sum;
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		for (int i = 0; i < 7; i++) {
			System.out.println(climbStairs(i));
		}
	}
}
