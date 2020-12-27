// @desc-start
// Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
//  
// Example 1:
// 
// 
// Input: l1 = [1,2,4], l2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// 
// Example 2:
// 
// Input: l1 = [], l2 = []
// Output: []
// 
// Example 3:
// 
// Input: l1 = [], l2 = [0]
// Output: [0]
// 
//  
// Constraints:
// 
// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both l1 and l2 are sorted in non-decreasing order.
// 
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode head = new ListNode(-1);
		ListNode p = head;
		ListNode tmp = null;
		ListNode p1 = l1;
		ListNode p2 = l2;
		while(p1 != null && p2 != null) {
			ListNode n = null;
			if(p1.val <= p2.val) {
				n = p1;
				p1 = p1.next;
			} else {
				n = p2;
				p2 = p2.next;
			}
			p.next = n;
			p = p.next;
			if(p1 == null) tmp = p2;
			if(p2 == null) tmp = p1;
		}
		if(tmp != null) {
			p.next = tmp;
		}
		return head.next;
    }
}
// @code-end
