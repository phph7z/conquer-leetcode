// @desc-start
// Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
// Example:
// 
// Input: 3
// Output:
// [
//   [1,null,3,2],
//   [3,2,null,1],
//   [3,1,null,null,2],
//   [2,1,3],
//   [1,null,2,null,3]
// ]
// Explanation:
// The above output corresponds to the 5 unique BST's shown below:
// 
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
// 
//  
// Constraints:
// 
// 0 <= n <= 8
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
    public List<TreeNode> generateTrees(int n) {
		if(n==0) {
			return new ArrayList<>();
		}
		return generateTrees(1, n);
    }

	private List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> ret = new ArrayList<>();
		if(start > end) {
			ret.add(null);
			return ret;
		}
		for(int i = start; i <= end; i++) {
			List<TreeNode> leftTrees = generateTrees(start, i - 1);
			List<TreeNode> rightTrees = generateTrees(i + 1, end);
			for(int j = 0; j < leftTrees.size(); j++) {
				for(int k = 0; k < rightTrees.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = leftTrees.get(j);
					root.right = rightTrees.get(k);
					ret.add(root);
				}
			}
		}
		return ret;
	}
}
// @code-end
