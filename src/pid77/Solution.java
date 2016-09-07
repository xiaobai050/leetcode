package pid77;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<Integer> temp = new ArrayList<Integer>();
	
    List<List<Integer>> rtn = new ArrayList<List<Integer>>();;
	
    public List<List<Integer>> combine(int n, int k) {
    	temp.add(0);
    	temp.add(0);
    	solve(0,k,n,1);
		return rtn;        
    }
    
    public void solve (int index,int k,int n,int start){
    	if(index==k){
    		rtn.add(temp);
    		//System.out.println(rtn);
    		return;
    	}
    	for(int i=start;i<=n;i++){
    		temp.set(index,i);
    		//System.out.println("i="+i+" index="+index);
    		solve(index+1,k,n,i+1);    		
    	}
    }
}