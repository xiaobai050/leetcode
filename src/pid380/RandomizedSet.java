package pid380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandomizedSet {

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	List<Integer> arr = new ArrayList<Integer>();
	
	int end=-1;
	
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(map.get(val)!=null)return false;
    	map.put(val, ++end);
    	arr.add(val);
//    	System.out.println("哈希表:"+map);
//    	System.out.println("数组:"+arr);
//    	System.out.println("end="+end);
    	return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(map.get(val)==null)return false;
    	if(end==-1)return false;
    	int valPos=map.get(val);
    	int endNum=arr.get(end);
    	swapVal(valPos,end);
    	map.put(endNum, valPos);
    	map.remove(val);    	
    	
    	arr.remove(end--);
    	
//    	System.out.println("哈希表:"+map);
//    	System.out.println("数组:"+arr);
//    	System.out.println("end="+end);
		return true;
		
        
    }
  

	private void swapVal(Integer integer, int i) {
//    	System.out.println("****************交换"+integer+","+i);
		int t=arr.get(integer);
		arr.set(integer, arr.get(i));
		arr.set(i,t);
		
	}

	/** Get a random element from the set. */
    public int getRandom() {

		return arr.get((int)(10000*Math.random())&end);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */