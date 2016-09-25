package pid179;

import java.util.Arrays;

public class Solution {

	char[][] numArray;
	int[] nums;

	public String largestNumber(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return "";
		this.nums = nums;
		numArray = new char[len][];
		for (int i = 0; i < len; i++)
			numArray[i] = String.valueOf(nums[i]).toCharArray();

		for (int i = 0; i < len; i++)
			System.out.println(numArray[i]);

		for (int i = 0; i < len - 1; i++)
			for (int j = i; j < len - 1; j++) {
				if (needSwap(j, j + 1)) {
					swap(j, j + 1);
					System.out.println(Arrays.toString(nums));
				}

			}

		return null;

	}

	private void swap(int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	private boolean needSwap(int num1, int num2) {

		char[] ch1 = numArray[num1];
		char[] ch2 = numArray[num2];
		int len1 = ch1.length;
		int len2 = ch2.length;
		// System.out.print(" ch1="+Arrays.toString(ch1));
		// System.out.print(" ch2="+Arrays.toString(ch2));
		// System.out.print(" len1="+len1);
		// System.out.println(" len2="+len2);
		int len = min(len1, len2);
		for (int i = 0; i < len; i++) {
			if (ch1[i] < ch2[i]){
				System.out.println(ch1[i]);
				System.out.println(ch2[i]);
				System.out.println("true");
				return true;
				}
		}

		return false;
	}

	private int min(int len1, int len2) {
		return len1 < len2 ? len1 : len2;
	}

}
