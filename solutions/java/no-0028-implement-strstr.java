// @desc-start
// Implement strStr().
// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
// Clarification:
// What should we return when needle is an empty string? This is a great question to ask during an interview.
// For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
//  
// Example 1:
// Input: haystack = "hello", needle = "ll"
// Output: 2
// Example 2:
// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
// Example 3:
// Input: haystack = "", needle = ""
// Output: 0
// 
//  
// Constraints:
// 
// 0 <= haystack.length, needle.length <= 5 * 104
// haystack and needle consist of only lower-case English characters.
// 
// 
// @desc-end


// @code-start
class Solution {
    public int strStr(String haystack, String needle) {
		int len1 = haystack.length();
		int len2 = needle.length();
		if(len1 == 0 && len2 == 0) return 0;
		if(len2 > len1) return -1;

		for(int i = 0; i < len1 - len2 + 1; i++) {
			boolean found = true;
			for(int j = 0; j < len2; j++) {
				if(haystack.charAt(j+i) != needle.charAt(j)) {
					found = false;
					break;
				}
			}
			if(found) return i;
		}
		return -1;
    }
}
// @code-end
