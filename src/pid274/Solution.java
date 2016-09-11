package pid274;

import java.util.Arrays;

public class Solution {
	public int hIndex(int[] citations) {
		int len = citations.length;

		Arrays.sort(citations);
		for (int i = 0; i < len; i++) {
			// System.out.println("i+1=" + (i + 1) + " citations[len-i-1]=" + citations[len - i - 1]);
			if (citations[len - i - 1] < i + 1)
				return i;
		}
		return len;
	}
}