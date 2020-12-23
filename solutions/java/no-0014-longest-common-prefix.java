// @desc-start
// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
//  
// Example 1:
// 
// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// 
// Example 2:
// 
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
// 
//  
// Constraints:
// 
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lower-case English letters.
// 
// 
// @desc-end


// @code-start
class Solution {
    public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		return findLcp(strs, 0, strs.length - 1);
    }

	private String findLcp(String[] strs, int start, int end) {
		if(start == end) {
			return strs[start];
		}
		int mid = (start + end) / 2;
		String leftLcp = findLcp(strs, start, mid);
		String rightLcp = findLcp(strs, mid + 1, end);
		int len = Math.min(leftLcp.length(), rightLcp.length());
		for(int i = 0; i < len; i ++) {
			if(leftLcp.charAt(i) != rightLcp.charAt(i)) {
				return leftLcp.substring(0, i);
			}
		}
		return leftLcp.substring(0, len);
	}
}
// @code-end
