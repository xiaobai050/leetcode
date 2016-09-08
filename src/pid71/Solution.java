package pid71;

import java.util.Stack;

public class Solution {

	public String simplifyPath(String path) {

		Stack<String> dirTable = new Stack<String>();
		String strRtn = "";
		int len = path.length();

		for (int i = 0; i < len; i++) {
			String s = "";
			while (i < len && path.charAt(i) == '/')
				i++;
			while (i < len && path.charAt(i) != '/') {
				s += path.charAt(i);
				i++;
			}
			if (s.equals(".."))
				if (!dirTable.empty())
					dirTable.pop();
			if (!s.equals("") && !s.equals(".") && !s.equals(".."))
				dirTable.push(s);
		}

		while (!dirTable.empty()) {
			strRtn = '/' + dirTable.pop() + strRtn;
		}
		if (strRtn.length() == 0)
			return "/";
		return strRtn;
	}

}