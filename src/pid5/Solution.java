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
		for (int i = 1; i <= len - 1; i++) { // �����ַ���
			tempStr = "";
			beginPos = 0;
			endPos = 0;
			if (stringArr[i - 1] == stringArr[i]) { // ż����ת
				beginPos = i - 1;
				endPos = i;
				solve();
			}
			if (i < len - 1) {
				if (stringArr[i - 1] == stringArr[i + 1]) { // ������ת
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
			if (stringArr[beginPos] == stringArr[endPos]) { // �������
				// System.out.println("�������");
				// System.out.println("stringArr[" + beginPos + "]=" +
				// stringArr[beginPos]);
				// System.out.println("stringArr[" + endPos + "]=" +
				// stringArr[endPos]);
				if (((beginPos >= 1) && endPos < len - 1)) {
					beginPos--;
					endPos++;
				} else { // ��ͷ��
					break;
				}
			} else { // ����жϣ���ʼ���㳤��
				// System.out.println("���ֲ�����ַ���");
				beginPos++;
				endPos--;
				break;
			}
		}

		// System.out.println("��ʼ���㳤��,��ǰ�ַ�������Ϊ��" + (endPos - beginPos + 1));
		// System.out.println("beginPos =" + beginPos);
		// System.out.println("endPos =" + endPos);
		// System.out.println("��ǰ�ַ���tempStrΪ��" + tempStr);
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