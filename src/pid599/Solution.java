package me.bai.LeetCode.pid599;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
 * have a list of favorite restaurants represented by strings.
 * 
 * You need to help them find out their common interest with the least list
 * index sum. If there is a choice tie between answers, output all of them with
 * no order requirement. You could assume there always exists an answer.
 * 
 * Example 1: Input: ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"] Explanation: The only restaurant they both like is
 * "Shogun". Example 2: Input: ["Shogun", "Tapioca Express", "Burger King",
 * "KFC"] ["KFC", "Shogun", "Burger King"] Output: ["Shogun"] Explanation: The
 * restaurant they both like and have the least index sum is "Shogun" with index
 * sum 1 (0+1). Note: The length of both lists will be in the range of [1,
 * 1000]. The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1. No duplicates in
 * both lists.
 */
public class Solution {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> like1 = new HashMap<String, Integer>();
		for (int i = 0; i < list1.length; i++) {
			like1.put(list1[i], i);
		}

		int minOffsetSum = list1.length + list2.length;

		List<String> common = new ArrayList<String>();
		for (int i = 0; i < list2.length; i++) {
			String like = list2[i];
			if (like1.containsKey(like)) {
				int sum = like1.get(like) + i;
				if (sum < minOffsetSum) {
					common.clear();
					common.add(like);
					minOffsetSum = sum;
				} else if (sum == minOffsetSum) {
					common.add(like);
				}
			}
		}

		return common.toArray(new String[common.size()]);

	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		String[] list1 = new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] list2 = new String[] { "KFC", "Shogun", "Burger King" };
		String[] rtn = findRestaurant(list1, list2);

		System.out.println(rtn);
	}
}
