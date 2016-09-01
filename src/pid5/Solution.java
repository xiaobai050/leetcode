package pid5;

public class Solution {
	LongestStr longestStr;
	char[] stringArr = null;
	int len = 0;
	int beginPos = 0;
	int endPos = 0;
	String tempStr = "";

	public String longestPalindrome(String s) {
		if (s == "")
			return "";
		longestStr = new LongestStr(s);
		stringArr = s.toCharArray();
		len = s.length();
		for (int i = 1; i <= len - 1; i++) { // 遍历字符串
			tempStr = "";
			beginPos = 0;
			endPos = 0;
			if (stringArr[i - 1] == stringArr[i]) { // 偶数翻转
				beginPos = i - 1;
				endPos = i;
				solve();
			}
			if (i < len - 1) {
				if (stringArr[i - 1] == stringArr[i + 1]) { // 奇数翻转
					beginPos = i - 1;
					endPos = i + 1;
				}
				solve();
			}
		}
		return longestStr.getString();
	}

	private void solve() {
		while (true) {
			if (stringArr[beginPos] == stringArr[endPos]) { // 持续相等
				// System.out.println("持续相等");
				// System.out.println("stringArr[" + beginPos + "]=" +
				// stringArr[beginPos]);
				// System.out.println("stringArr[" + endPos + "]=" +
				// stringArr[endPos]);
				if (((beginPos >= 1) && endPos < len - 1)) {
					beginPos--;
					endPos++;
				} else { // 到头了
					break;
				}
			} else { // 相等中断，开始计算长度
				// System.out.println("出现不相等字符，");
				beginPos++;
				endPos--;
				break;
			}
		}

		// System.out.println("开始计算长度,当前字符串长度为：" + (endPos - beginPos + 1));
		// System.out.println("beginPos =" + beginPos);
		// System.out.println("endPos =" + endPos);
		// System.out.println("当前字符串tempStr为：" + tempStr);
		// System.out.println();

		tempStr = String.valueOf(stringArr, beginPos, endPos - beginPos + 1);
		longestStr.update(tempStr);

	}

	public class LongestStr {
		int length = 1;
		String string = null;

		public LongestStr(String s) {
			setString(String.valueOf(s.charAt(0)));
		}

		private void update(String tempStr) {
			int length = tempStr.length();
			if (length > getLength()) {
				setString(tempStr);
				setLength(length);
			}
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public String getString() {
			return string;
		}

		public void setString(String string) {
			this.string = string;
		}

	}
}