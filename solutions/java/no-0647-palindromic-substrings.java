// @desc-start
// Given a string, your task is to count how many palindromic substrings in this string.
// The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
// Example 1:
// 
// Input: "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
// 
//  
// Example 2:
// 
// Input: "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//  
// Note:
// 
// The input string length won't exceed 1000.
// 
//  
// @desc-end


// @code-start
class Solution {
    public int countSubstrings(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int ans = 0;
		for(int i = n - 1; i >= 0; i--) {
			for(int j = i; j < n; j++) {
				if(i==j) {
					dp[i][j] = true;
				} else {
					if(s.charAt(i) == s.charAt(j)) {
						if(dp[i+1][j-1]) dp[i][j] = true;
						else if(j-i==1) dp[i][j] = true;
					}
				}
				if(dp[i][j]) ans++;
			}
		}
		return ans;
    }
}
// @code-end
