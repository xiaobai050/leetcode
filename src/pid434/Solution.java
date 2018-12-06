package me.bai.LeetCode.pid434;

public class Solution {
	String s;
	int len;
	int count;

	public int countSegments(String s) {
		this.s = s;
		len = s.length();
		count = 0;
		for (int i = 0; i < len; i++)
			visit(i);
		return count;
//		return ("x " + s).split(" +").length - 1;
	}

	private void visit(int pos) {
		if (isNewBegin(pos))
			count++;
	}

	private boolean isNewBegin(int pos) {
		return isChar(pos) && !isChar(pos - 1);
	}

	private boolean isChar(int pos) {
		if (pos < 0)
			return false; 
		char ch = s.charAt(pos);
		return ch != ' ';
	}
}