package pid3;

public class main {
	public static void main(String[] args) {
		test("aab");
		test("cdd");
		test("abcabcbb");
		test("bbbbb");
		test("pwwkew");
	}

	private static void test(String s) {
		int len = s.length();
		for (int i = 0; i < len; i++) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println(s);

		Solution solution = new Solution();
		solution.lengthOfLongestSubstring(s);
	}
}
