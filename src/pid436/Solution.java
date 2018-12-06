package me.bai.LeetCode.pid436;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of intervals, for each of the interval i, check if there exists
 * an interval j whose start point is bigger than or equal to the end point of
 * the interval i, which can be called that j is on the "right" of i.
 * 
 * For any interval i, you need to store the minimum interval j's index, which
 * means that the interval j has the minimum start point to build the "right"
 * relationship for interval i. If the interval j doesn't exist, store -1 for
 * the interval i. Finally, you need output the stored value of each interval as
 * an array.
 * 
 * Note: You may assume the interval's end point is always bigger than its start
 * point. You may assume none of these intervals have the same start point.
 * Example 1: Input: [ [1,2] ]
 * 
 * Output: [-1]
 * 
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * Example 2: Input: [ [3,4], [2,3], [1,2] ]
 * 
 * Output: [-1, 0, 1]
 * 
 * Explanation: There is no satisfied "right" interval for [3,4]. For [2,3], the
 * interval [3,4] has minimum-"right" start point; For [1,2], the interval [2,3]
 * has minimum-"right" start point. Example 3: Input: [ [1,4], [2,3], [3,4] ]
 * 
 * Output: [-1, 2, -1]
 * 
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4]. For
 * [2,3], the interval [3,4] has minimum-"right" start point.
 */
/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {

	int[] startTable = null;

	public int[] findRightInterval(Interval[] intervals) {
		int size = intervals.length;
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		startTable = new int[size];
		for (int i = 0; i < size; i++) {
			Interval interval = intervals[i];
			int start = interval.start;
			indexMap.put(start, i);
			startTable[i] = start;
		}
		Arrays.sort(startTable);

		int[] rtn = new int[size];
		for (int i = 0; i < size; i++) {
			rtn[i] = -1;

			int begin = 0;
			int end = size - 1;
			while (begin < end - 1) {
				int middle = (begin + end) / 2;
				if (in(intervals[i].end, begin, middle)) {
					end = middle;
				} else {
					begin = middle;
				}
			}
			if (intervals[i].end <= startTable[begin]) {
				rtn[i] = indexMap.get(startTable[begin]);
			} else if (intervals[i].end <= startTable[end]) {
				rtn[i] = indexMap.get(startTable[end]);
			}
		}
		return rtn;
	}

	private boolean in(int val, int m, int n) {
		return val > startTable[m] && val <= startTable[n];
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	/*
	 * [[3,4],[2,3],[1,2]]
	 */
	private void test() {
		Interval[] intervals = { new Interval(3, 4), new Interval(2, 3), new Interval(1, 2) };
		int[] rtn = findRightInterval(intervals);
		System.out.println();
	}
}
