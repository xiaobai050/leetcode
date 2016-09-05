package pid58;

public class Solution {
	public int lengthOfLastWord(String s) {

		int len = 0;
		int Len = s.length();
		while (Len>0&&s.charAt(Len - 1) == ' ') {
			Len--;
		}
		for (len = 0; len < Len; len++) {
			if (s.charAt(Len - len - 1) == ' ') {
				break;
			}
		}
		return len;
	}
}