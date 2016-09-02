package pid17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	String[] table = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	List<String> lst= new ArrayList<>();

	int len = 0;
	char[] rtn, digChar;
	
	public List<String> letterCombinations(String digits) {
		
		if (digits.length() == 0)		//不能写为 if(digits==""),否则在leetcode提交无法通过 
			return lst;
		digChar = digits.toCharArray();
		len = digits.length();
		rtn = new char[len];
		stradd(0, rtn);
		return lst;
	}
	
	public void stradd(int count, char[] rtn) {
		if (count == len) {
			lst.add(String.valueOf(rtn));
		} else {
			for (int i = 0; i < 4; i++) {
				int theNum = digChar[count] - '0';
				if (i == 3)
					if (theNum != 7 && theNum != 9)
						break;
				rtn[count] = table[theNum].charAt(i);
				stradd(count + 1, rtn);
			}
		}
	}
}