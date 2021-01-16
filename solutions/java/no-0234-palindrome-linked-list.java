// @desc-start
// Given a singly linked list, determine if it is a palindrome.
// Example 1:
// 
// Input: 1->2
// Output: false
// Example 2:
// 
// Input: 1->2->2->1
// Output: true
// Follow up:
// Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) return true;
		int len = 1;
		ListNode tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
			len++;
		}
		tmp = head;
		int step = len/2;

		while(step >0) {
			tmp = tmp.next;
			step --;
		}
		boolean ans = true;
		ListNode rightPart = reverse(tmp);
		ListNode right = rightPart;
		ListNode left = head;
		step = len/2;
		while(step > 0) {
			if(left.val != right.val) {
				ans = false;
				break;
			}
			left = left.next;
			right = right.next;
			step --;
		}
		return ans;
    }

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
// @code-end
