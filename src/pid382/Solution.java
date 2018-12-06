package me.bai.LeetCode.pid382;

/**
 * Hello world!
 *
 */
public class Solution {

	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	ListNode head;
	int size = 0;

	public Solution(ListNode head) {
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {

		if (size == 0) {
			figureSize();
		}

		int offset = (int) (Math.random() * size);
		return getNode(head, offset);
	}

	private int getNode(ListNode node, int offset) {
		for (int i = 0; i < offset; i++) {
			node = node.next;
		}
		return node.val;
	}

	private void figureSize() {
		size = 1;
		ListNode node = head;
		while (true) {
			node = node.next;
			if (node == null)
				break;
			size++;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		Solution obj = new Solution(head);
		for (int i = 0; i < 10; i++) {
			int param_1 = obj.getRandom();
			System.out.println(param_1);
		}
	}

}
