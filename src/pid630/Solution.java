package me.bai.LeetCode.pid630;

/**
 * 630. Course Schedule III My SubmissionsBack To Contest User Accepted: 9 User
 * Tried: 394 Total Accepted: 9 Total Submissions: 831 Difficulty: Medium There
 * are n different online courses numbered from 1 to n. Each course has some
 * duration(course length) t and closed on dth day. A course should be taken
 * continuously for t days and must be finished before or on the dth day. You
 * will start at the 1st day.
 * 
 * Given n online courses represented by pairs (t,d), your task is to find the
 * maximal number of courses that can be taken.
 * 
 * Example: Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]] Output:
 * 3 Explanation: There're totally 4 courses, but you can take 3 courses at
 * most: First, take the 1st course, it costs 100 days so you will finish it on
 * the 100th day, and ready to take the next course on the 101st day. Second,
 * take the 3rd course, it costs 1000 days so you will finish it on the 1100th
 * day, and ready to take the next course on the 1101st day. (If you take the
 * 2nd course here, you will end at 300th day and find that no more courses you
 * could take.) Third, take the 2nd course, it costs 200 days so you will finish
 * it on the 1300th day. The 4th course cannot be taken now, since you will
 * finish it on the 3300th day, which exceeds the closed date. Note: The integer
 * 1 <= d, t, n <= 10,000. You can't take two courses simultaneously.
 */
public class Solution {
//	int heap= 
	public int scheduleCourse(int[][] courses) {
		
		int i = getMaxIndexBelow(1100);
		return 0;

	}
	

	private int getMaxIndexBelow(int i) {
		// TODO Auto-generated method stub
		return 0;
	}


	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {

	}
}
