package pid12;


public class Solution {
	String[] table = { 
			"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", 		//	��λ	0-9
			"","X", "XX", "XXX", "XL", "L", "LX","LXX", "LXXX", "XC",		//	ʮλ	00-90
			"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",		//	��λ	000-900
			"","M","MM","MMM", 												//	ǧλ	0000-3000
			};

	public String intToRoman(int num) {
		String rtn = "";
		
		int value3,value2,value1,value0;
		
		value3=num/1000;
		value2=num%1000/100;
		value1=num%100/10;	
		value0=num%10;	
		
		rtn=table[30+value3]+		
		table[20+value2]+	
		table[10+value1]+		
		table[value0];
		
		return rtn;

	}
}