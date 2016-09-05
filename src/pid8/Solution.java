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
			if (ito > '0' && ito < '9') { // ��������
				break;
			}

			else if (ito == ' ') { // �ո񣬼���
				begin++;
				continue;
			} else
				if(ito!='+'&&ito!='-')
					return 0;
				else break;
		}
		if(strArray[begin]=='+')begin++;
		else if(strArray[begin]=='-'){negFlag=true;begin++;}

		for (end = begin; end < len; end++) {
			if (strArray[end] > '0' && strArray[end] < '9') { // ��������
				continue;
			} else
				break;
		}

		String temp = String.valueOf(strArray, begin, end - begin);
		// System.out.println("temp= "+temp);
		if (temp.length() > 10)
			if(negFlag)rtn = Integer.MIN_VALUE;
			else rtn=Integer.MAX_VALUE;
		
		else if (temp.length() < 10)
			if(negFlag)rtn = -Integer.valueOf(temp);
			else rtn = Integer.valueOf(temp);
		
		else 
			if(negFlag){
				if (temp.compareTo("2147483648") > 0)
					rtn = Integer.MIN_VALUE;
			}
			else{
				if (temp.compareTo("2147483647") > 0)
					rtn=Integer.MAX_VALUE;
			}

		return rtn;
	}
}
