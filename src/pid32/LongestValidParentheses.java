package me.bai.study.leetcode;

class LongestValidParentheses {
	public static void main(String[] args) {
		int n = new LongestValidParentheses().longestValidParentheses(")()())()()(");
		System.out.println(n);
	}

	public int longestValidParentheses(String s) {
		int[] arr = new int[s.length()];
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ')') {
				int b = i - 1;
				while (b >= 0) {
					if (s.charAt(b) == '(') {
						break;
					} else {
						b -= arr[b] > 0 ? arr[b] : 1;
					}
				}
				if (b >= 0) {
					arr[i] = i - b + 1;
					arr[i] += preNeighborLen(arr, b);
					if (arr[i] > max) max = arr[i];
				}
			}
		}
		return max;
	}

	private int preNeighborLen(int[] arr, int index) {
		return index > 0 ? arr[index - 1] : 0;
	}

}