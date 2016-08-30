package pid1;

import java.util.HashMap;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {

		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			m.put(target - numbers[i], i);
		}

		for (int i = 0; i < numbers.length; i++) {

			Integer v = m.get(numbers[i]);

			if (v != null && v != i) {
				return new int[] { i, v };
			}
		}

		throw new RuntimeException();
	}
}