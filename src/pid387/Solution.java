package pid387;

import java.util.HashMap;

public class Solution {
	
	
	public static int firstUniqChar(String s) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		int len=s.length();
		for(int i=0;i<len;i++){
			if(map.get(s.charAt(i))==null)
			map.put(s.charAt(i), 1);
			else
				map.put(s.charAt(i),2);
		}
		//System.out.println(map);
		for(int i=0;i<len;i++)
			if(map.get(s.charAt(i)) == 1)
				return i;
		
		return -1;        
    }
	
	public static void main(String[] args) {
		test("hello");
		test("leetcode");
		test("loveleetcode");
		test("jjj");
	}

	private static void test(String s) {

		System.out.println(s+":  "+firstUniqChar(s));
	}
}
