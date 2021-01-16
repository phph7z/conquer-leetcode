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
		backtrack(n, n, 0, new char[n*2]);
		return ans;
    }

	private void backtrack(int left, int right, int i, char[] path) {
		if(left > right || left < 0 || right < 0) return;
		if(left==right && left ==0) {
			ans.add(new String(path));
			return;
		}
		path[i] = '(';
		backtrack(left-1, right, i+1, path);
		path[i] = ')';
		backtrack(left, right-1, i+1, path);
	}
}
// @code-end
