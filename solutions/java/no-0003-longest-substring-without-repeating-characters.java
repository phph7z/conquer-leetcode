// @desc-start
// Given a string s, find the length of the longest substring without repeating characters.
//  
// Example 1:
// 
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// 
// Example 2:
// 
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// 
// Example 3:
// 
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
// 
// Example 4:
// 
// Input: s = ""
// Output: 0
// 
//  
// Constraints:
// 
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
// 
// 
// @desc-end


// @code-start
class Solution {
    public int lengthOfLongestSubstring(String s) {
		if(s==null ||s.length() ==0) return 0;
		Map<Character,Integer> memo = new HashMap<>();
		int len = 1;
		int slow =0;
		int i = 0;
		for(; i < s.length();i++) {
			if(memo.containsKey(s.charAt(i))) {
				if(i-slow>len) {
					len=i-slow;
				}
				if(memo.get(s.charAt(i)) >= slow) {
					slow=memo.get(s.charAt(i))+1;
				}
			}
			memo.put(s.charAt(i), i);
		}
		if(i-slow>len) {
			len = i-slow;
		}
		return len;
    }
}
// @code-end
