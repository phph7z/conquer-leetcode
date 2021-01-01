// @desc-start
// Given inorder and postorder traversal of a tree, construct the binary tree.
// Note:
// You may assume that duplicates do not exist in the tree.
// For example, given
// 
// inorder = [9,3,15,20,7]
// postorder = [9,15,7,20,3]
// Return the following binary tree:
// 
//     3
//    / \
//   9  20
//     /  \
//    15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

	private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if(inStart > inEnd)
			return null;
		int root = postorder[postEnd];
		int rootIndex = -1;
		for(int i = inStart; i <= inEnd; i ++) {
			if(inorder[i] == root) {
				rootIndex = i;
				break;
			}
		}
		int leftLen = rootIndex - inStart;

		TreeNode n = new TreeNode(root);
		n.left = build(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftLen - 1);
		n.right = build(inorder, rootIndex + 1, inEnd, postorder, postStart + leftLen, postEnd - 1);
		return n;
	}
}
// @code-end
