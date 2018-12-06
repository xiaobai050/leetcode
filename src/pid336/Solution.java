package me.bai.LeetCode.pid336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1: Given words = ["bat", "tab", "cat"] Return [[0, 1], [1, 0]] The
 * palindromes are ["battab", "tabbat"] Example 2: Given words = ["abcd",
 * "dcba", "lls", "s", "sssll"] Return [[0, 1], [1, 0], [3, 2], [2, 4]] The
 * palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class Solution {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		 
		int size = words.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					continue;
				}
				if (isOk(words[i], words[j])) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(i);
					list.add(j);
					lists.add(list);
				}
			}
		}
		return lists;
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		String[] in = {};
		List<List<Integer>> lists = palindromePairs(in);
		for (List<Integer> list : lists) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private boolean isOk(String s1, String s2) {
		if (!s1.equals("") && !s2.equals("")) {
			if (s1.charAt(0) != s2.charAt(s2.length() - 1))
				return false;
		}
		String s = s1 + s2;
		int size = s.length();
		for (int i = 0; i < size / 2; i++) {
			if (s.charAt(i) != s.charAt(size - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
