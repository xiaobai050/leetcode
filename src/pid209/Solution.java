package pid209;

public class Solution {

	public int minSubArrayLen(int s, int[] nums) {

		int len = nums.length;
		int lenMin = Integer.MAX_VALUE;
		if (len == 0)
			return 0;

		int begin = 0;
		int end = 0;
		int sum = nums[0];

		while (true) {

			if (sum < s) {
				if (end < len - 1) {
					end++;
					sum += nums[end];
				} else {
					return lenMin > len ? 0 : lenMin;
				}

			} else {
				lenMin = min(end - begin + 1, lenMin);
				sum -= nums[begin];
				begin++;
			}
		}

	}

	private int min(int i, int j) {
		return i < j ? i : j;
	}

}