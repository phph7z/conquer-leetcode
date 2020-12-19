// @desc-start
// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
// You have the following three operations permitted on a word:
// 
// Insert a character
// Delete a character
// Replace a character
// 
//  
// Example 1:
// 
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
// 
// Example 2:
// 
// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation: 
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')
// 
//  
// Constraints:
// 
// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase English letters.
// 
// 
// @desc-end


// @code-start
class Solution {
    public int minDistance(String word1, String word2) {
		Map<String,Integer> memo = new HashMap<>();
		return dp(word1, word2, 0, 0, 0, memo);
    }

	private int dp(String w1, String w2, int i , int j, int step, Map<String,Integer> memo) {
		String key = i + "_" + j;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int ans = 0;
		if(i == w1.length()) {
			ans = w2.length() - j + step;
		} else if(j == w2.length()) {
			ans = w1.length() - i + step;
		} else if(w1.charAt(i) == w2.charAt(j)) {
			ans = dp(w1, w2, i + 1, j + 1, step, memo);
		} else {
			// delete
			int v1 = dp(w1, w2, i + 1, j, step, memo) + 1;
			// replace
			int v2 = dp(w1, w2, i + 1, j + 1, step, memo) + 1;
			// insert
			int v3 = dp(w1, w2, i, j + 1, step, memo) + 1;
			ans = Math.min(v1, v2);
			ans = Math.min(ans, v3);
		}
		memo.put(key, ans);
		return ans;
	}
}
// @code-end
