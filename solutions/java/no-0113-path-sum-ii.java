// @desc-start
// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
// Note: A leaf is a node with no children.
// Example:
// Given the below binary tree and sum = 22,
// 
//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \    / \
// 7    2  5   1
// 
// Return:
// 
// [
//    [5,4,11,2],
//    [5,8,4,5]
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
	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
		dfs(root, sum, new ArrayList<>());
		return ans;
    }

	private void dfs(TreeNode root, int sum, List<Integer> path) {
		if(root == null) return;
		path.add(root.val);
		sum -= root.val;
		if(root.left == null && root.right == null && sum == 0) {
			ans.add(new ArrayList<>(path));
		}
		dfs(root.left, sum, path);
		dfs(root.right, sum, path);
		path.remove(path.size()-1);
	}
}
// @code-end
