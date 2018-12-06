package me.bai.LeetCode.pid22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<String> rtn = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {
		StringBuffer sb = new StringBuffer("");
		loop(sb, n, n);
		return rtn;
	}

	private void loop(StringBuffer sb, int leftNum, int rightNum) {
		if (leftNum + rightNum == 0) {
			rtn.add(sb.toString());
		}
		if (leftNum > 0) {
			loop(sb.append('('), leftNum - 1, rightNum);
		}

		if (rightNum > leftNum && rightNum > 0) {
			loop(sb.append(')'), leftNum, rightNum - 1);
		}
		if (sb.length() - 1 < 0) {
			return;
		}
		sb.deleteCharAt(sb.length() - 1);
	}

	private void test() {
		List<String> list = generateParenthesis(3);
		System.out.println(list);
	}

	public static void main(String[] args) {
		new Solution().test();
	}
}