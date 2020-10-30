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
        
        // initial state
        int start = 0;
        int end = 0;
        int maxLen = 1;
        for(int r = 1; r < len; r++) {
            for(int l = 0; l < r; l++) {
                if(s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if(r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        start = l;
                        end = r;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
// @code-end
