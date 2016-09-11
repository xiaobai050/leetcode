package pid275;

public class Solution {
	public int hIndex(int[] citations) {
		int len = citations.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return citations[0] == 0 ? 0 : 1;

		int begin = 0;
		int end = len - 1;

		while (begin < end - 1) {
			int mid = (begin + end) / 2;
			if (citations[len - 1 - mid] < mid + 1)
				end = mid;
			else
				begin = mid;
		}
		if (citations[len - 1 - end] >= end + 1)
			return end + 1;
		if (citations[len - 1 - begin] == 0)
			return 0;
		return begin + 1;
	}

}