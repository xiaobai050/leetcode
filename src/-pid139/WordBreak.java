package me.bai.study.leetcode;

import java.util.*;

class WordBreak {
	public static void main(String[] args) {
		boolean ok = new WordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", null);
		System.out.println(ok);
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set set1 = new HashSet<Character>();
		Set set2 = new HashSet<Character>();

		for (int i = 0; i < s.length(); i++) {
			set1.add(s.charAt(i));
		}

		Map<Character, Set<String>> map = new HashMap<>();
		for (String str : wordDict) {
			for (int i = 0; i < str.length(); i++) {
				set2.add(str.charAt(i));
			}
			char c = str.charAt(0);
			Set set = map.get(c);
			if (set == null) {
				set = new HashSet<String>();
				map.put(c, set);
			}
			set.add(str);
		}
		if (!set2.containsAll(set1)) return false;

		return fit(s, 0, map);

	}

	private boolean fit(String s, int index, Map<Character, Set<String>> map) {
		if (index == s.length()) return true;

		char need = s.charAt(index);
		Set<String> set = map.get(need);
		if (set == null) return false;
		for (String str : set) {
			if (str.length() + index > s.length()) {
				continue;
			}
			boolean error = false;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != s.charAt(index + i)) {
					error = true;
					break;
				}
			}
			if (error) continue;
			if (fit(s, index + str.length(), map)) return true;
		}
		return false;
	}

}
