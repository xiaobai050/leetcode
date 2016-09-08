package test.Recursion;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	List<Integer> tree = new ArrayList<Integer>();
	List<Integer> treePreorder = new ArrayList<Integer>();
	List<Integer> treeAfter = new ArrayList<Integer>();

	public void solve(int n) {

		set(1, 4, 1, 1);
		System.out.println("初始化:");
		System.out.println(tree);
		Preorder(1, 4, 1);
		System.out.println("先序遍历:");
		System.out.println(treePreorder);
		After(1, 4, 1);
		System.out.println("后序遍历:");
		System.out.println(treeAfter);
	}

	private void set(int line, int maxLine, int value, int volume) { // 建立一个二叉树，从左至右1~2^n
		if (line > maxLine) {
			return;
		}
		for (int i = 0; i < volume; i++, value++) {
			tree.add(value);
		}
		set(line + 1, maxLine, value, volume * 2);

	}

	private void Preorder(int line, int maxLine, int value) { // 先序遍历
		if (line > maxLine) {
			return;
		}
		treePreorder.add(value);
		Preorder(line + 1, maxLine, 2 * value);
		Preorder(line + 1, maxLine, 2 * value + 1);

	}

	private void After(int line, int maxLine, int value) { // 后序遍历
		if (line > maxLine) {
			return;
		}
		After(line + 1, maxLine, 2 * value);
		After(line + 1, maxLine, 2 * value + 1);
		treeAfter.add(value);
	}
}
