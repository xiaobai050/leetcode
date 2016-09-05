package pid8;

public class Solution {
	public int myAtoi(String str) {
		int rtn = 0;
		int begin = 0;
		int end = 0;
		int len = str.length();
		boolean negFlag=false;

		if (len == 0)
			return 0;
		char[] strArray = str.toCharArray();
		for (char ito : strArray) {
			if (ito == ' ') { // 空格，继续
				begin++;
				continue;

			}
			else if (ito == '+'){
				begin++;
				break;
			}
			else if (ito == '-'){
				begin++;
				negFlag=true;
				break;
			}
			else if (ito >= '0' && ito <= '9') { // 出现数字
				break;
			}
			else			//出现非法字符
				return 0;
		}
		if(begin>=len)return 0;
		if (strArray[begin] < '0' || strArray[begin] > '9') { // 出现非法字符
			return 0;
		}

		for (end = begin; end < len; end++) {
			if (strArray[end] >= '0' && strArray[end] <= '9') { // 出现数字
				continue;
			} else
				break;
		}

		String temp = String.valueOf(strArray, begin, end - begin);
//		 System.out.println("temp= "+temp);
		if (temp.length() > 10)
			if(negFlag)rtn = Integer.MIN_VALUE;
			else rtn=Integer.MAX_VALUE;
		
		else if (temp.length() < 10)
			if(negFlag)rtn = -Integer.valueOf(temp);
			else rtn = Integer.valueOf(temp);
		
		else 
			if(negFlag){
				if (temp.compareTo("2147483648") >= 0)
					rtn = Integer.MIN_VALUE;
				else
					rtn = -Integer.valueOf(temp);					
			}
			else{
				if (temp.compareTo("2147483647") >= 0)
					rtn=Integer.MAX_VALUE;
				else rtn = Integer.valueOf(temp);
			}

		return rtn;
	}
	
}
