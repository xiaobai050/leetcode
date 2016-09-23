package pid403;

import java.util.HashMap;

public class SolutionSimpleHash {

	HashMap<Integer, Boolean> dp = new HashMap<Integer, Boolean>();

	public boolean canCross(int[] stones) {

		return canCross(stones, 0, 0);

	}

	public boolean canCross(int[] stones, int pos, int k) {

		int key = pos | k << 11;
		
		if (dp.get(key) != null)
			return false;

		for (int i = pos + 1; i < stones.length; i++) {
			int gap = stones[i] - stones[pos];
			if (gap < k - 1)
				continue;
			if (gap > k + 1) {
				dp.put(key, false);
				return false;
			}
			if (canCross(stones, i, gap))
				return true;
		}
		boolean temp = (pos == stones.length - 1);
		dp.put(key, temp);
		return temp;
	}
}
