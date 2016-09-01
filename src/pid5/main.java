package pid5;

public class main {
	public static void main(String[] args) {
		test("");
		test("ab");

		test("");
		test("aa");
		test("aab");
		test("1aa");

		test("");
		test("aaa");
		test("aba");

		test("");
		test("abcbaabcba");
	}

	private static void test(String s) {
		int len = s.length();
		Solution solution = new Solution();
		String rtn = solution.longestPalindrome(s);
		System.out.print(s+":	");
		System.out.println(rtn);

	}

}
