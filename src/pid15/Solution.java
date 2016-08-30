package pid15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {

    	List<List<Integer>> rtn=new ArrayList<List<Integer>>();
    	int a,b,c;   
    	a=b=c=0;
    	int n=nums.length;
    	Arrays.sort(nums);
    	for(int i=0;i<n-2;i++){
			if(i>0)if(nums[i]==nums[i-1])continue;
    		for(int j=i+1;j<n-1;j++){
    			if(j>i+1)if(nums[j]==nums[j-1])continue;
    			for(int k=j+1;k<n;k++){
    				if(k>j+1)if(nums[k]==nums[k-1])continue;
    				a = nums[i];
    				b = nums[j];
    				c = nums[k];
    				if(a+b+c==0)
    				{
    			    	List<Integer> temp=new ArrayList<Integer>();
    			    	temp.add(a);
    					temp.add(b);
    					temp.add(c);
    					//System.out.println(temp);
    					//if(!rtn.contains(temp))    						
        				rtn.add(temp);					
    				}
    			}
    		}	
    	}
    	return rtn;
          
    	
    }

	public static void main(String[] args) {
    	
    	List<List<Integer>> rtn=new ArrayList<List<Integer>>();

    	int[]nums0= 
    		{-1, 0, 1, 2, -1, -4};
    	int[]nums=Nums();
    		
    	long start = System.currentTimeMillis();
    	rtn=threeSum(nums);
    	long end = System.currentTimeMillis();
    	
    	System.out.println(rtn);

    	System.out.println("time="+(end-start)+"ms");
    	
	}
	public static int[] Nums(){
		int[] n1={-1, 0, 1, 2, -1, -4};
		int[] n2={2,13,-2,-5,-1,10,6,-8,5,-5,7,-5,-14,-4,-5,10,-15,-2,-14,-6,10,6,-14,-14,-9,-11,8,-3,-2,12,-9,-14,3,5,-12,-13,-8,1,-14,12,12,0,14,5,4,-14,-8,4,-9,-7,14,-13,6,7,-12,5,12,11,-13,-5,0,-6,-12,-12,6,13,12,13,0,5,2,-11,13,1,9,2,2,-14,13,8,-14,4,2,8,-3,-3,-10,-14,-15,14,-12,1,-15,14,-4,6,12,-6,-4,-3,6,5};
    	
		return n2;
	}
}