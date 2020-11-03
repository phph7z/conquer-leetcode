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
        
        int l = 0;
        int r = strs.length - 1;
        return findPrefix(strs, l, r);
    }
    
    private String findPrefix(String[] strs, int left, int right) {
        
        if(left == right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String lcpLeft = findPrefix(strs, left, mid);
            String lcpRight = findPrefix(strs, mid + 1, right);
            
            int min = Math.min(lcpLeft.length(), lcpRight.length());
            for(int i = 0; i < min; i++) {
                if(lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                    return lcpLeft.substring(0, i);
                }
            }
            return lcpLeft.substring(0, min);
        }
    }
}
// @code-end
