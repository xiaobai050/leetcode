package pid438;

import java.util.Arrays;

/**
 * Find All Anagrams in a String Given a string s and a non-empty string p, find
 * all the start indices of p's anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc". Example 2:
 * 
 * Input: s: "abab" p: "ab"
 * 
 * Output: [0, 1, 2]
 * 
 * Explanation: The substring with start index = 0 is "ab", which is an anagram
 * of "ab". The substring with start index = 1 is "ba", which is an anagram of
 * "ab". The substring with start index = 2 is "ab", which is an anagram of
 * "ab".
 * 
 * @author ��
 *
 */
public class main {
	public static void main(String[] args) {

		String[][] testTable = { 
				{"ababa","ab"},
				{"cbaebabacd" , "abc"}
				};

		for (String[] ito: testTable) {
			test(ito);
		}

	}

	private static void test(String[] ito) {

		System.out.print(">> ");
		System.out.print(Arrays.toString(ito));
		System.out.println();
		String s = ito[0];
		String p = ito[1];

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		Object rtn = solution.findAnagrams(s, p);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println("                              << " + rtn);
		System.out.println("--------------------------------------��ʱ��" + (end - begin) + "ms");

	}
}
