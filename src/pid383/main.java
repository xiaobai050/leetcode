package pid383;

import java.util.Arrays;

/**
 * Ransom Note
 * 
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		String[][] testTable = { 
				{"",""},
				{"aa","aab"},
				{"aab","aab"},
				{"aa","ab"},
		};
		for (String[] ito : testTable) {
			test(ito);
		}
	}

	private static void test(String[] ito) {
		System.out.println(Arrays.toString(ito));

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		boolean rtn = solution.canConstruct(ito[0], ito[1]);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println(rtn);
		System.out.println("ºÄÊ±£º" + (end - begin) + "ms");
		System.out.println("--------------");
	}
}
