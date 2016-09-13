package pid109;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	int count = 0;
	int deepMax;
	int len = 0;
	int endCount = 0;
	int endMax;
	ListNode head;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		this.head = head;
		len = getListLongth(head, 1);
		deepMax = (int) (Math.log(len + 1) / Math.log(2));
		endMax = len - (int) Math.pow(2, deepMax) + 1;

		TreeNode headTree = new TreeNode(0);
		insert(headTree, 0);

		return headTree;

	}

	private int getListLongth(ListNode node, int len) {
		if (node.next == null)
			return len;
		return getListLongth(node.next, len + 1);
	}

	private void insert(TreeNode thisNode, int deep) {
		// System.out.println("deep="+deep);
		if (deep == deepMax) { // 超过了
			if (thisNode == null)
				return;
		} else if (deep == deepMax - 1) { // 最后一行
			if (endCount++ < endMax) {
				if (thisNode.left == null)
					thisNode.left = new TreeNode(0);
			}
			if (endCount++ < endMax) {
				if (thisNode.right == null)
					thisNode.right = new TreeNode(0);
			}
		} else { // 没到最后一行
			thisNode.left = new TreeNode(0);
			thisNode.right = new TreeNode(0);
		}

		if (thisNode.left != null)
			insert(thisNode.left, deep + 1);

		if (count < len) {
			thisNode.val = head.val;
			head = head.next;
			count++;
		}

		if (thisNode.right != null)
			insert(thisNode.right, deep + 1);

	}
}