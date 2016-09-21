package pid14;

public class Solution {
	public String longestCommonPrefix(String[] strs) {

		int totle = strs.length;

		if (totle == 0)
			return "";
		if (totle == 1)
			return strs[0];

		String common = "";
		int lenMin = strs[0].length();

		for (int i = 1; i < totle; i++) {
			int len = strs[i].length();
			lenMin = lenMin < len ? lenMin : len;
		}

		for (int i = 0; i < lenMin; i++) {

			char ch = strs[0].charAt(i);

			for (int count = 1; count < totle; count++) {
				if (strs[count].charAt(i) != ch)
					return common;

			}
			common += ch;
		}

		return common;
	}
}