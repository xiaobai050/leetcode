package me.bai.LeetCode.pid352;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, ...,
 * summarize the numbers seen so far as a list of disjoint intervals.
 * 
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6,
 * ..., then the summary will be:
 * 
 * [1, 1] [1, 1], [3, 3] [1, 1], [3, 3], [7, 7] [1, 3], [7, 7] [1, 3], [6, 7]
 * Follow up: What if there are lots of merges and the number of disjoint
 * intervals are small compared to the data stream's size?
 */
public class SummaryRanges {

	LinkedList<Interval> list = new LinkedList<Interval>();

	/** Initialize your data structure here. */
	public SummaryRanges() {

	}

	public void addNum(int val) {

		Interval left = null;
		Interval right = null;
		for (Interval interval : list) {
			if (inTheInterval(val, interval)) {
				return;
			}
			if (right != null) {
				break;
			}
			if (isRightInterval(val, interval)) {
				right = interval;
			} else if (isLeftInterval(val, interval)) {
				left = interval;
			}
		}
		boolean inserted = false;
		if (canCombine(val, left)) {
			left.end++;
			inserted = true;
		}
		if (canCombine(val, right)) {
			right.start--;
			inserted = true;
		}
		if (canCombine(left, right)) {
			left.end = right.end;
			list.remove(right);
		}
		if (!inserted) {
			int index = 0;
			if (left != null)
				index = list.indexOf(left) + 1;
			else if (right != null)
				index = list.indexOf(right);
			list.add(index, new Interval(val, val));
		}

	}

	private boolean canCombine(Interval left, Interval right) {
		if (left == null || right == null)
			return false;
		return left.end == right.start;
	}

	private boolean canCombine(int val, Interval interval) {
		if (interval == null)
			return false;
		return val == interval.start - 1 || val == interval.end + 1;
	}

	private boolean isRightInterval(int val, Interval interval) {
		return val < interval.start;
	}

	private boolean isLeftInterval(int val, Interval interval) {
		return val > interval.end;
	}

	private boolean inTheInterval(int val, Interval interval) {
		return val >= interval.start && val <= interval.end;
	}

	public List<Interval> getIntervals() {
		return list;
	}

	public static void main(String[] args) {
		SummaryRanges obj = new SummaryRanges();
		obj.addNum(1);
		System.out.println(obj.getIntervals());
		obj.addNum(3);
		System.out.println(obj.getIntervals());
		obj.addNum(7);
		System.out.println(obj.getIntervals());
		obj.addNum(2);
		System.out.println(obj.getIntervals());
		obj.addNum(6);
		System.out.println(obj.getIntervals());
	}
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges(); obj.addNum(val); List<Interval>
 * param_2 = obj.getIntervals();
 */