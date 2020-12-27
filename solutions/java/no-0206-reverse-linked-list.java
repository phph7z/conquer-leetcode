// @desc-start
// Reverse a singly linked list.
// Example:
// 
// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
// 
// Follow up:
// A linked list can be reversed either iteratively or recursively. Could you implement both?
// 
// @desc-end


// @code-start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
		if(head == null)
			return head;
		return reverse(head);
    }

	private ListNode reverse(ListNode n) {
		// base case
		if(n.next == null) return n;
		ListNode last = reverse(n.next);
		n.next.next = n;
		n.next = null;
		return last;
	}
}
// @code-end
