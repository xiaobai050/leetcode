package pid13;

public class Solution {
    public int romanToInt(String s) {
        int len=s.length();
        String[] table = { 
			"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", 		//	个位	0-9
			"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",		//	十位	00-90
			"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",		//	百位	000-900
			"","M","MM","MMM", 												//	千位	0000-3000
			};
			
		// devide:
		int[] num = new int[4];
		String[] numStr = new String[4];
		int begin = 0;
		int end = 0;

		// 千位--M结尾
		if (end != len)
			while (s.charAt(end) == 'M') {
				end++;
				if (end == len)
					break;
			}
		numStr[3] = s.substring(begin, end);
		begin = end;

		// 百位--C,D,M结尾
		if (end != len)
			while (s.charAt(end) == 'C' || s.charAt(end) == 'D' || s.charAt(end) == 'M') {
				end++;
				if (end == len)
					break;
			}
		numStr[2] = s.substring(begin, end);
		begin = end;

		// 十位--X,L,C结尾
		if (end != len)
			while (s.charAt(end) == 'X' || s.charAt(end) == 'L' || s.charAt(end) == 'C') {
				end++;
				if (end == len)
					break;
			}
		numStr[1] = s.substring(begin, end);
		begin = end;

		// 个位--
		numStr[0] = s.substring(begin);

//		System.out.println(numStr[3]);
//		System.out.println(numStr[2]);
//		System.out.println(numStr[1]);
//		System.out.println(numStr[0]);

		for (int i = 3; i >= 0; i--) {
			for (int j = i * 10; j < i * 10 + 10; j++)
				if (table[j].equals(numStr[i])) {
					num[i] = j - i * 10;

					break;
				}
		}

		return 1000 * num[3] + 100 * num[2] + 10 * num[1] + num[0];
	}

}