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
        if(s == null || s.length() < 2) {
            return s;
        }
        
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

		int start = 0;
		int end = 0;
		int maxLen = 0;
		for(int i = 0; i < len; i++) {
			for(int j = 0; j <= i; j++) {
				if(s.charAt(i) == s.charAt(j)) {
					if(i - j <= 2 || dp[i - 1][j + 1]) {
						dp[i][j] = true;
						if(i - j > maxLen) {
							maxLen = i - j;
							start = j;
							end = i;
						}
					}
				}
			}
		}
		return s.substring(start, end + 1);
    }
}
// @code-end
