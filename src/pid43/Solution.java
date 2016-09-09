package pid43;

import java.util.ArrayList;

public class Solution {
	public String multiply(String num1, String num2) {

		int len1 = num1.length();
		int len2 = num2.length();
		char[] num1Array = num1.toCharArray();
		char[] num2Array = num2.toCharArray();
		char[] finalResult = new char[len1 + len2];
		ArrayList<ArrayList<Character>> lines = new ArrayList<ArrayList<Character>>();

//		System.out.println("   " + num1);
//		System.out.println(" 〜 " + num2);
//		System.out.println("  ！！！！");

		int carry = 0;
		for (int ito2 = len2 - 1; ito2 >= 0; ito2--) {
			ArrayList<Character> line = new ArrayList<Character>();
			for (int ito1 = len1 - 1; ito1 >= 0; ito1--) {
				int temp = (num1Array[ito1] - '0') * (num2Array[ito2] - '0') + carry;
				carry = temp / 10;
				temp %= 10;
				// System.out.println(temp);
				line.add((char) (temp + '0'));
			}
			line.add((char) (carry + '0'));
			// System.out.println(line.toString());
			lines.add(line);
			carry = 0;
		}
		// System.out.println(lines);

		int beginLine = 0;
		int endLine = 1;
		int lineCount = 0;
		carry = 0;
		for (int wei = 0; wei <= len1 + len2 - 1; wei++) {
			lineCount = beginLine;

			int temp = 0;
			for (; lineCount < endLine; lineCount++) {
				if (wei - lineCount == lines.get(lineCount).size() - 1)
					beginLine++;
				temp += lines.get(lineCount).get(wei - lineCount) - '0';
				// System.out.println(lines.get(lineCount).get(wei -
				// lineCount));
				// System.out.println(finalResult[len1 + len2 - 1 - wei]);
			}
			temp += carry;
			carry = temp / 10;
			temp %= 10;
			finalResult[len1 + len2 - 1 - wei] = (char) (temp + '0');

			if (endLine < len2)
				endLine++;
			// System.out.println(finalResult[len1+len2-1-wei]);
		}

		int beginPos = 0;
		while (finalResult[beginPos++] == '0' && beginPos < len1 + len2);

		return String.valueOf(finalResult, beginPos - 1, len1 + len2 - beginPos + 1);

	}
}