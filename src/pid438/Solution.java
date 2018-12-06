package pid438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer>rtn = new ArrayList<Integer>();
    	int lenS=s.length();
    	int lenP=p.length();
    	HashMap<Character,Integer> mapP = new HashMap<Character,Integer>();
    	for(int j=0;j<lenP;j++){
			if(mapP.get(s.charAt(j))!=null)
				mapP.put(s.charAt(j), mapP.get(s.charAt(j))+1);
			else
				mapP.put(s.charAt(j),1);
			
		}
    	for(int i=0;i<lenS-lenP;i++){
    		HashMap<Character,Integer> mapI = new HashMap<Character,Integer>();
    	    	
    		for(int j=0;j<lenP;j++){
    			if(mapI.get(s.charAt(i+j))!=null)
    				mapI.put(s.charAt(i+j), mapI.get(s.charAt(i+j))+1);
    			else
    				mapI.put(s.charAt(i+j),1);
    			
    		}
    		if(mapI.equals(mapP))rtn.add(i);
    	}
		return rtn;
        
    }
}