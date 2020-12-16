// @desc-start
// Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Follow up: Could you do this in one pass?
//  
// Example 1:
// 
// 
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// 
// Example 2:
// 
// Input: head = [1], n = 1
// Output: []
// 
// Example 3:
// 
// Input: head = [1,2], n = 1
// Output: [1]
// 
//  
// Constraints:
// 
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) {
			return head;
		}
		ListNode p = new ListNode();
		p.next = head;
		List<ListNode> nodeList = new ArrayList<>();
		ListNode t = p;
		while(t != null) {
			nodeList.add(t);
			t = t.next;
		}
		ListNode prevNode = nodeList.get(nodeList.size() - n - 1);
		prevNode.next = prevNode.next.next;
		return p.next;
    }
}
// @code-end
