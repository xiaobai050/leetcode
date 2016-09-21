package pid56;

import java.util.List;

public class Solution {
	List<Interval> intervals;

	public List<Interval> merge(List<Interval> intervals) {

		this.intervals = intervals;
		if (intervals.size() <= 1)
			return intervals;

		for (int i = 0; i < intervals.size() - 1; i++)
			for (int j = i + 1; j < intervals.size();) {

				Interval i1 = intervals.get(i);
				Interval i2 = intervals.get(j);
				// System.out.println();
				// System.out.println(intervals);
				if (i1.start > i2.end || i1.end < i2.start) {
					// System.out.println(i+"和"+j+"不能融合");
					j++;
					continue;
				}

				Interval temp = new Interval(min(i1.start, i2.start), max(i1.end, i2.end));

				// System.out.println(i+"和"+j+"融合为"+temp);
				intervals.set(i, temp);
				intervals.remove(j);
				j = i + 1;
			}

		return intervals;

	}

	private int min(int i, int j) {
		return i < j ? i : j;
	}

	private int max(int i, int j) {
		return i > j ? i : j;
	}

}