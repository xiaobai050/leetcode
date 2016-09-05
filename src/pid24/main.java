package pid24;

public class main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		ListNode head = new ListNode(0);
		int[] table = { 1, 2, 3, 4, 5, 6, 7, };
		head = tab2lst(table, head);
		head = solution.swapPairs(head);

		printlst(head);

		
		

	}


	public static ListNode tab2lst(int[] table, ListNode head) {
		if (table == null)
			return null;
		ListNode it = head;
		it.val = table[0];
		int len = table.length;
		for (int i = 1; i < len; i++) {
			it.next = new ListNode(table[i]);
			it = it.next;
		}

		return head;
	}

	public static void printlst(ListNode head) {
		ListNode it = head;
		while (it != null) {
			System.out.println(it.val);
			it = it.next;
		}
	}
}
