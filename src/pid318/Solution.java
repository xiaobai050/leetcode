package me.bai.LeetCode.pid318;

/**
 * Hello world!
 *
 */
public class Solution {

	public int maxProduct(String[] words) {
		int size = words.length;
		int[] keyTable = new int[size];
		for (int i = 0; i < size; i++) {
			int key = string2Key(words[i]);
			keyTable[i] = key;
		}
		int max = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (diff(keyTable[i], keyTable[j])) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}

		return max;
	}

	private boolean diff(int i, int j) {
		if ((i & j) == 0)
			return true;
		else
			return false;
	}

	private int string2Key(String string) {
		int len = string.length();
		int key = 0;
		for (int i = 0; i < len; i++) {
			char ch = string.charAt(i);
			key |= 1 << (ch - 'a');
		}
		return key;
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		int rtn = maxProduct(new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" });
		System.out.println(rtn);
		rtn = maxProduct(new String[] { "a", "ab", "abc", "d", "cd", "bcd", "abcd" });
		System.out.println(rtn);
		rtn = maxProduct(new String[] { "a", "aa", "aaa", "aaaa" });
		System.out.println(rtn);
	}

}
