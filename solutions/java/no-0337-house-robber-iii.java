// @desc-start
// The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
// Determine the maximum amount of money the thief can rob tonight without alerting the police.
// Example 1:
// 
// Input: [3,2,3,null,3,null,1]
// 
//      3
//     / \
//    2   3
//     \   \ 
//      3   1
// 
// Output: 7 
// Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
// Example 2:
// 
// Input: [3,4,5,1,3,null,1]
// 
//      3
//     / \
//    4   5
//   / \   \ 
//  1   3   1
// 
// Output: 9
// Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
// 
// @desc-end


// @code-start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
		if(n == null) return 0;
		// rob
		int v1 = n.val + 
			(n.left != null ? rob(n.left.left) + rob(n.left.right) : 0) + 
			(n.right != null ? rob(n.right.left) + rob(n.right.right) : 0);
		// not rob
		int v2 = Math.max(rob(n.left), rob(n.right));
		return Math.max(v1, v2);
    }
}
// @code-end
