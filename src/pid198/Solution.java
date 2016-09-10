package pid198;

public class Solution {
    public int rob(int[] nums) {
    	int len=nums.length;
    	int []value= new int[len];
    	if(len==0)return 0;
    	value[0]=nums[0];
    	if(len==1){
    		return value[0];
    	}
    	value[1]=nums[1];
    	if(len==2){
    		return max(value[0],value[1]);
    	}
    	value[2]=nums[2]+value[0];
    	for(int i=3;i<len;i++){
//    		System.out.print("nums["+i+"]="+nums[i]);
    		value[i]=nums[i]+max(value[i-2],value[i-3]);
//    		System.out.println("	value["+i+"]="+value[i]);
    	}
    	
		return max(value[len-1],value[len-2]);
        
    }

	private int max(int i, int j) {
		
		return i>j?i:j;
	}
}