package me.bai.LeetCode.pid134;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 */
public class Solution {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int size = gas.length;
		int start = 0;
		int needRamain = 0;
		int have = 0;
		for (int i = 0; i < size; i++) {
			have += gas[i];
			have -= cost[i];
			if (have < 0) {
				needRamain += -have;
				if (i == size - 1)
					return -1;
				start = i + 1;
				have = 0;
			}
		}
		if (have < needRamain)
			return -1;

		return start;
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		int[] gas = new int[] { 3, 4, 5, 6 };
		int[] cost = new int[] { 5, 5, 4, 4 };
		int index = canCompleteCircuit(gas, cost);
		System.out.println(index);
	}
}
