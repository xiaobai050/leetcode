package pid409;

public class Solution {
    public int longestPalindrome(String s) {
    	
    	boolean[] table=new boolean[100];
    	char[] arr=s.toCharArray();
    	
    	int len= s.length();
    	int sum=0;
    	
    	for (int i=0;i<len;i++){
    		int ch = arr[i]-'A';
    		if(table[ch]==false)table[ch]=true;
    		else{
    			sum+=2;
    			table[ch]=false;
    		}
    	}
    	
    	if(sum<len)sum++;
		return sum;
        
    }
}