package pid172;

public class Solution {
    public int trailingZeroes(int n) {
	
    	if(n<5)return 0;
    	return trailingZeroes(n/5)+n/5;
    	
    	
//    	int sum=0;    	
//    	while(n>=5)
//    		sum+=n/=5;
//    	
//    	return sum;        	
    	
    
    }       
}