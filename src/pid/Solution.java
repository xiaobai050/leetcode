package pid;

public class Solution {
    public int romanToInt(String s) {
        int len=s.length();
        String[] table = { 
			"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", 		//	��λ	0-9
			"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",		//	ʮλ	00-90
			"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",		//	��λ	000-900
			"","M","MM","MMM", 												//	ǧλ	0000-3000
			};
			
		// devide:
		int[] num = new int[4];
		String[] numStr = new String[4];
		int begin = 0;
		int end = 0;

		// ǧλ--M��β
		if (end != len)
			while (s.charAt(end) == 'M') {
				end++;
				if (end == len)
					break;
			}
		numStr[3] = s.substring(begin, end);
		begin = end;

		// ��λ--C,D,M��β
		if (end != len)
			while (s.charAt(end) == 'C' || s.charAt(end) == 'D' || s.charAt(end) == 'M') {
				end++;
				if (end == len)
					break;
			}
		numStr[2] = s.substring(begin, end);
		begin = end;

		// ʮλ--X,L,C��β
		if (end != len)
			while (s.charAt(end) == 'X' || s.charAt(end) == 'L' || s.charAt(end) == 'C') {
				end++;
				if (end == len)
					break;
			}
		numStr[1] = s.substring(begin, end);
		begin = end;

		// ��λ--
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