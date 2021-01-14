// @desc-start
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
// return its zigzag level order traversal as:
// 
// [
//   [3],
//   [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if(root == null)
			return ret;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int levelNo = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new LinkedList<>();
			for(int i = 0; i < size; i ++) {
				TreeNode n = q.poll();
				if(levelNo % 2 == 1) {
					level.add(n.val);
				} else {
					level.add(0, n.val);
				}
				if(n.left != null)
					q.offer(n.left);
				if(n.right != null)
					q.offer(n.right);
			}
			ret.add(level);
			levelNo ++;
		}
		return ret;
    }
}
// @code-end
