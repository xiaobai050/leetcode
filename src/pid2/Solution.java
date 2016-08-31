package pid2;

public class Solution {

	public static void main(String args[]) {

		ListNode l1 = null;
		ListNode l2 = null;

		l1 = new ListNode(5);
		ListNode l10 = l1;
		l1.next = new ListNode(9);
		l1 = l1.next;
		l1.next = null;

		l2 = new ListNode(5);
		ListNode l20 = l2;
		l2.next = null;

		ListNode l3 = addTwoNumbers(l10, l20);

		ListNode temp = l3;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int g = l1.val + l2.val;
		int s = 0;

		if (g > 9) {
			g -= 10;
			s = 1;
		}
		ListNode rtn = new ListNode(g);
		ListNode re = rtn;
		while ((l1.next != null) && (l2.next != null)) {
			l1 = l1.next;
			l2 = l2.next;
			g = l1.val + l2.val + s;
			if (g > 9) {
				g -= 10;
				s = 1;
			} else {
				s = 0;
			}
			rtn.next = new ListNode(g);
			rtn = rtn.next;
		}

		while (l1.next != null) {
			l1 = l1.next;
			g = l1.val + s;
			if (g > 9) {
				g -= 10;
				s = 1;
			} else {
				s = 0;
			}
			rtn.next = new ListNode(g);
			rtn = rtn.next;
		}
		while (l2.next != null) {
			l2 = l2.next;
			g = l2.val + s;
			if (g > 9) {
				g -= 10;
				s = 1;
			} else {
				s = 0;
			}
			rtn.next = new ListNode(g);
			rtn = rtn.next;
		}

		if (s == 1) {
			rtn.next = new ListNode(1);
			rtn = rtn.next;
		}

		rtn.next = null;
		return re;
	}

}
