package pid179;

public class Solution {

	int[] nums;

	public String largestNumber(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return "";
		this.nums = nums;

		for (int i = 0; i < len - 1; i++)
			for (int j = 0; j < len - i - 1; j++)
				if (needSwap(j, j + 1))
					swap(j, j + 1);

		String rtn = "";
		for (int i = 0; i < len; i++)
			rtn += String.valueOf(this.nums[i]);
		int begin = 0;
		while (rtn.charAt(0) == '0' && begin < len - 1)
			begin++;
		return rtn.substring(begin);

	}

	private void swap(int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	private boolean needSwap(int num1, int num2) {

		String str1 = String.valueOf(nums[num1]);
		String str2 = String.valueOf(nums[num2]);
		String zheng = str1 + str2;
		String fan = str2 + str1;
		if (zheng.compareTo(fan) < 0)
			return true;
		else
			return false;

	}

}
