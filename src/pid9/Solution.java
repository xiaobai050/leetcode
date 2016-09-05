package pid9;

public class Solution {
    public static boolean isPalindrome(int x) {

    	if(x<0)return false;
    	
    	Integer num=x;
    	
    	String numStr=num.toString();
    	int len=numStr.length();

    	for(int i=0;i<len/2;i++){
    		if(numStr.charAt(i)==numStr.charAt(len-1-i))continue;
    		else
    			return false;
    	}
		return true;        
    }
    
    public static void main(String[] args) {

    	test(12321);
    	test(1231);
    	test(1);
    	test(Integer.MAX_VALUE);

	}
    public static void test (int x){
    	boolean isP=isPalindrome(x);   

    	System.out.println(x+"  "+isP);
    }
}