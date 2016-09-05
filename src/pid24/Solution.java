package pid24;

public class Solution {
	public ListNode swapPairs(ListNode head) {

//		ListNode it = head;
//		if (it == null)
//			return null;
//
//		while (it != null && it.next != null) {
//			int t = it.val;
//			it.val = it.next.val;
//			it.next.val = t;
//			it = it.next.next;
//		}
//
//		return head;
		
		
		  if (head == null) return null;
	        
	        if (head.next == null) return head;
	        
	        ListNode newhead = head.next;
	        head.next = swapPairs(head.next.next);
	        
	        newhead.next = head;
	        
	        return newhead;
	        
	        
	}
}
