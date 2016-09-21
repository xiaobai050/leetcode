package pid383;

public class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] table = new int[26];

		for (int i = 0; i < magazine.length(); i++) {
			char ch = magazine.charAt(i);
			table[ch - 'a']++;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char ch = ransomNote.charAt(i);
			if (--table[ch - 'a'] < 0)
				return false;

		}
		return true;
	}
}