package pid403;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
    List <HashMap<Integer,Boolean>>mapTable= new ArrayList <HashMap<Integer,Boolean>>();
	int [] stones;
    public boolean canCross(int[] stones) {
    	

    	int len=stones.length;
    	if(len<2)
    		return true;
    	if(stones[1]!=1)return false;
    	
    	this.stones = stones;
    	
    	for(int i=0;i<len;i++){
    		map.put(stones[i], i);
    		mapTable.add(new HashMap<Integer,Boolean>());
    	}
    	
    	
    	mapTable.get(0).put(1,true);
    	mapTable.get(1).put(1,true);
    	
    	int endPos=len;
    	solve(endPos);
    	
    	if(mapTable.get(endPos-1).isEmpty())return false;
    	return true;
        
    }

	private boolean solve(int endPos) {
					
		//ö��ǰ�����е㣬���Ƿ��ܵ��������ܣ���¼���k
		
		for(int nowPos=2;nowPos<endPos;nowPos++){
			for(int j=1;j<nowPos;j++){
				
				int k=canArriveByK(j,nowPos);
				if(k!=0)
					mapTable.get(nowPos).put(k,true);//�ڵ�ǰλ�ã���¼��ǰ���k
			}		
		}
		return false;
		
	}

	
	private int canArriveByK(int j, int nowPos) {
		int begin = stones[j];
		int end = stones[nowPos];
		int k =end- begin;

		if(mapTable.get(j).get(k)==null)
		if(mapTable.get(j).get(k+1)==null)
		if(mapTable.get(j).get(k-1)==null)return 0;
		
		return k;
	}

    
}
