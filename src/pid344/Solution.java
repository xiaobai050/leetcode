package pid344;

public class Solution {
	public static String reverseString(String s) {
		String rtn = "";
		int len = s.length();
		char[] ch = new char[len];
		int i = 0;
		while (len > 0) {
			ch[i] = s.charAt(--len);
			i++;
		}
		rtn = new String(ch);	

		return rtn;
	}

	public static void main(String[] args) {
		String test = "123456";
		String rtn = "";

		long start = System.currentTimeMillis();
		rtn =reverseString(test);
		long end = System.currentTimeMillis();
		
		System.out.println(rtn);
		System.out.println("time=" + (end - start) + "ms");

	}
}
