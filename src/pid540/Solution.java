package me.bai.LeetCode.pid540;

public class Solution {
	int[] nums;
	int len;

	public int singleNonDuplicate(int[] nums) {
		this.nums = nums;
		this.len = nums.length;

		return searchIn(0, len - 1);
	}

	private int searchIn(int i, int j) {
		int middle = (i + j) / 2;
		if (isSingle(middle)) {
			return nums[middle];
		}
		if (eachIsEven(i, j)) {
			if (sameToAfter(middle))
				return searchIn(middle, j);
			else
				return searchIn(i, middle);
		} else {
			if (sameToBefore(middle))
				return searchIn(middle + 1, j);
			else
				return searchIn(i, middle - 1);
		}
	}

	private boolean isSingle(int middle) {
		return (!sameToBefore(middle)) && (!sameToAfter(middle));
	}

	private boolean sameToBefore(int pos) {
		if (pos == 0)
			return false;
		return nums[pos] == nums[pos - 1];
	}

	private boolean sameToAfter(int pos) {
		if (pos == len - 1)
			return false;
		return nums[pos] == nums[pos + 1];
	}

	private boolean eachIsEven(int i, int j) {
		return (j - i) % 4 == 0;
	}

	public static void main(String[] args) {
		 int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
//		int[] nums = { 3, 3, 4, 4, 5 };
		Solution solution = new Solution();
		int rtn = solution.singleNonDuplicate(nums);
		System.out.println(rtn);
	}
}
