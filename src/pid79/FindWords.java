package me.bai.study.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class FindWords {
	public static void main(String[] args) {
		char[][] board = new char[][]{
				{'o', 'a', 'a', 'n'},
				{'e', 't', 'a', 'e'},
				{'i', 'h', 'k', 'r'},
				{'i', 'f', 'l', 'v'}
		};
		String[] words = {"oath", "pea", "eat", "rain"};
		List<String> strings = new FindWords().findWords(board, words);
		System.out.println(strings);
	}

	public List<String> findWords(char[][] board, String[] words) {
		Set<String> strings = new HashSet<>();
		List<String> list = new LinkedList<>();
		for (String w : words) {
			strings.add(w);
		}
		for (String w : strings) {
			if (exist(board, w)) {
				list.add(w);
			}
		}
		return list;
	}


	private boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (find(board, i, j, word, 0)) return true;
			}
		}
		return false;
	}

	private boolean find(char[][] b, int r, int l, String s, int index) {
		if (index == s.length()) {
			return true;
		}
		if (r < 0 || l < 0 || r >= b.length || l >= b[0].length || b[r][l] != s.charAt(index)) {
			return false;
		}
		b[r][l] = '-';
		boolean find = false;
		if (find(b, r - 1, l, s, index + 1) ||
				find(b, r + 1, l, s, index + 1) ||
				find(b, r, l - 1, s, index + 1) ||
				find(b, r, l + 1, s, index + 1)) {
			find = true;
		}
		b[r][l] = s.charAt(index);
		return find;
	}
}