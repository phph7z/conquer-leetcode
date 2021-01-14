// @desc-start
// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
// 
// For example:
// Given binary tree [3,9,20,null,null,15,7],
// 
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 
// 
// 
// return its level order traversal as:
// 
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if(root == null)
			return ret;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new ArrayList<>();
			for(int i = 0; i < size; i++) {
				TreeNode n = q.poll();
				level.add(n.val);
				if(n.left != null) 
					q.offer(n.left);
				if(n.right != null) 
					q.offer(n.right);
			}
			ret.add(level);
		}
		return ret;
    }
}
// @code-end
