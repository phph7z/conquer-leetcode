// @desc-start
// Given preorder and inorder traversal of a tree, construct the binary tree.
// Note:
// You may assume that duplicates do not exist in the tree.
// For example, given
// 
// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
// Return the following binary tree:
// 
//     3
//    / \
//   9  20
//     /  \
//    15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

	private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if(preStart > preEnd) return null;

		int root = preorder[preStart];
		int rootIndex = -1;
		for(int i = inStart; i <= inEnd; i++) {
			if(inorder[i] == root) {
				rootIndex = i;
				break;
			}
		}
		int leftLen = rootIndex - inStart;

		TreeNode n = new TreeNode(root);
		n.left = build(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inStart + leftLen - 1);
		n.right = build(preorder, preStart + leftLen + 1, preEnd, inorder, rootIndex + 1, inEnd); 
		return n;
	}
}
// @code-end
