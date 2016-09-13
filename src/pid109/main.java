package pid109;

/**
 * Convert Sorted List to Binary Search Tree Given a singly linked list where
 * elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int[][] numsTable = {

				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, };
		ListNode head = new ListNode(1);
		ListNode headBegin = head;

		head.next = new ListNode(2);
		head = head.next;
		head.next = new ListNode(3);
		head = head.next;
		head.next = new ListNode(4);
		head = head.next;
		head.next = new ListNode(5);
		head = head.next;
		head.next = new ListNode(6);
		head = head.next;
		head.next = new ListNode(7);
		head = head.next;
		head.next = new ListNode(8);
		head = head.next;
		head.next = new ListNode(9);
		head = head.next;

		test(headBegin);
	}

	private static void test(ListNode head) {
		Solution solution = new Solution();
		long begin = System.currentTimeMillis();

		TreeNode rtn = solution.sortedListToBST(head);

		long end = System.currentTimeMillis();
		rtn.display();
		System.out.println("ºÄÊ±" + (end - begin) + "ms");
		System.out.println("-----------------");
	}
}
