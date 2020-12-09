// @desc-start
// Given a binary tree, flatten it to a linked list in-place.
// For example, given the following tree:
// 
//     1
//    / \
//   2   5
//  / \   \
// 3   4   6
// 
// The flattened tree should look like:
// 
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6
// 
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
    public void flatten(TreeNode root) {
		if(root == null) {
			return;
		}
		flatten(root.left);
		flatten(root.right);

		TreeNode t = root.right;
		root.right = root.left;
		root.left = null;

		TreeNode p = root;
		while(p.right != null) {
			p = p.right;
		}
		p.right = t;
    }
}
// @code-end
