package pid403;

import java.util.HashMap;

public class SolutionOldChange {
	HashMap<Integer, Boolean> mapTable = new HashMap<Integer, Boolean>();
	int[] stones;

	public boolean canCross(int[] stones) {

		int len = stones.length;
		if (len < 2)
			return true;
		if (stones[1] != 1)
			return false;
		if (len == 2)
			return true;
		
		this.stones = stones;		
		
		mapTable.put(0|1<<11, true);
		mapTable.put(1|1<<11, true);

		return solve(len);
	}

	private boolean solve(int endPos) {
		// 枚举前面所有点，看是否能到这里，如果能，记录跨度k
		for (int nowPos = 2; nowPos < endPos; nowPos++) 
			for (int j = 1; j < nowPos; j++) {				
				int k = canArriveByK(j, nowPos);
				if (k != 0){
					// 在当前位置，记录当前跨度k					
					if(nowPos==endPos-1)return true;
					mapTable.put(nowPos| k<<11,true);
				}
			}	
		return false;
	}

	private int canArriveByK(int j, int nowPos) {
		int begin = stones[j];
		int end = stones[nowPos];
		int k = end - begin;

		if (mapTable.get(j | k << 11) != null)
			return k;
		if (mapTable.get(j | (k + 1) << 11) != null)
			return k;
		if (mapTable.get(j | (k - 1) << 11) != null)
			return k;
		return 0;
	}

}
