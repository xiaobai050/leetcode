package pid409;

/**
 * Longest Palindrome Given a string which consists of lowercase or uppercase
 * letters, find the length of the longest palindromes that can be built with
 * those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {

		String[] testTable = { "abccccdd","AAAAAA" };

		for (String ito : testTable) {
			test(ito);
		}

	}

	private static void test(String ito) {

		System.out.print(">> ");
		System.out.print(ito);
		System.out.println();

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		Object rtn = solution.longestPalindrome(ito);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println("                              << " + rtn);
		System.out.println("--------------------------------------ºÄÊ±£º" + (end - begin) + "ms");

	}
}
