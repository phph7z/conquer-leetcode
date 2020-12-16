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
		if(s.length() == 0)
			return 0;

		Map<Character, Integer> map = new HashMap<>();
		int left = 0;
		int right = 0;
		int len = Integer.MIN_VALUE;
		while(right < s.length()) {
			char rch = s.charAt(right);
			putch(map, rch);
			right ++;
			while(map.get(rch) > 1) {
				char lch = s.charAt(left);
				removech(map, lch);
				left ++;
			}
			len = Math.max(right - left, len);
		}
		return len;
    }

	private void putch(Map<Character, Integer> m, char ch) {
		if(m.containsKey(ch)) {
			m.put(ch, m.get(ch) + 1);
		} else {
			m.put(ch, 1);
		}
	}

	private void removech(Map<Character, Integer> m, char ch) {
		if(m.containsKey(ch)) {
			int v = m.get(ch) - 1;
			m.put(ch, v);
		}
	}
}
// @code-end
