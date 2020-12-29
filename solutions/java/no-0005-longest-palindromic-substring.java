// @desc-start
// Given a string s, return the longest palindromic substring in s.
//  
// Example 1:
// 
// Input: s = "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// 
// Example 2:
// 
// Input: s = "cbbd"
// Output: "bb"
// 
// Example 3:
// 
// Input: s = "a"
// Output: "a"
// 
// Example 4:
// 
// Input: s = "ac"
// Output: "a"
// 
//  
// Constraints:
// 
// 1 <= s.length <= 1000
// s consist of only digits and English letters (lower-case and/or upper-case),
// 
// 
// @desc-end


// @code-start
class Solution {
    public String longestPalindrome(String s) {
		int n = s.length();
		if(n < 2) {
			return s;
		}
		boolean[][] dp = new boolean[n][n];
		// base case
		for(int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
		int start = 0;
		int end = 0;
		int maxLen = 0;
		for(int i = n - 1; i >= 0; i --) {
			for(int j = i; j < n; j ++) {
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = i == j || i + 1 == j || dp[i + 1][j - 1];
				}
				int len = j - i + 1;
				if(dp[i][j] && len > maxLen) {
					start = i;
					end = j;
					maxLen = len;
				}
			}
		}
		return s.substring(start, end + 1);
    }
}
// @code-end
