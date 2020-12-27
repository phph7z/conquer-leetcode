// @desc-start
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//  
// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
// Output: ["()"]
// 
//  
// Constraints:
// 
// 1 <= n <= 8
// 
// 
// @desc-end


// @code-start
class Solution {
	private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
		backtrack(0, n, n, new char[2 * n]);
		return ans;
    }

	private void backtrack(int index, int lc, int rc, char[] path) {
		if(lc == 0 && rc == 0) {
			ans.add(new String(path));
			return;
		}
		if(index == path.length)
			return;
		if(lc < rc) {
			path[index] = '(';
			backtrack(index + 1, lc - 1, rc, path);
			path[index] = ')';
			backtrack(index + 1, lc, rc - 1, path);
		} else if(lc == rc) {
			path[index] = '(';
			backtrack(index + 1, lc - 1, rc, path);
		}
	}
}
// @code-end
