package pid403;

import java.util.HashMap;

public class SolutionFirst {

	int[] stones;

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	HashMap<Integer, Boolean> mapKey = new HashMap<Integer, Boolean>();

	public boolean canCross(int[] stones) {

		int len = stones.length;
		this.stones = stones;

		for (int i = 0; i < len; i++)
			map.put(stones[i], i);

		mapKey.put(0, true);

		return solve(1, stones[len - 1], 1);
	}

	private boolean solve(int pos, int endPos, int k) {

		if (k == 0)
			return false;

		
		int keyChar = pos<< 11 | k ;

		if (pos == endPos)
			return true;

		if (mapKey.get(keyChar) != null)
			return false;

		if ((pos > endPos) || (map.get(pos) == null)) {
			mapKey.put(keyChar, false);
			return false;
		}

		if (solve(pos + k - 1, endPos, k - 1))
			return true;
		if (solve(pos + k, endPos, k))
			return true;
		if (solve(pos + k + 1, endPos, k + 1))
			return true;

		mapKey.put(keyChar, false);
		return false;

	}

}
