package pid66;

public class Solution {
	public int[] plusOne(int[] digits) {

		int len = digits.length;
		for (int i = 0; i < len; i++) {

			if (digits[i] != 9) {

				int[] rtn = digits;
				rtn[len - 1]++;

				while (len > 0) {
					if (rtn[len - 1] != 10) {
						break;
					} else {
						rtn[len - 1] = 0;
						rtn[len - 2]++;
					}
					len--;
				}
				return rtn;
			}

		}

		int[] rtn = new int[len + 1];
		rtn[0] = 1;
		return rtn;

	}
}