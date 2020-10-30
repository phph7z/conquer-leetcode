// @desc-start
// Given a 32-bit signed integer, reverse digits of an integer.
// Note:
// Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//  
// Example 1:
// Input: x = 123
// Output: 321
// Example 2:
// Input: x = -123
// Output: -321
// Example 3:
// Input: x = 120
// Output: 21
// Example 4:
// Input: x = 0
// Output: 0
// 
//  
// Constraints:
// 
// -231 <= x <= 231 - 1
// 
// 
// @desc-end


// @code-start
class Solution {
    public int reverse(int x) {
        int ans = 0;
        int v = x;
        while(v != 0) {
            int n = v % 10;
            v /= 10;
            if(x > 0 && (Integer.MAX_VALUE / 10 < ans || Integer.MAX_VALUE / 10 == ans && n > 7))
               return 0;
            if(x < 0 && (Integer.MIN_VALUE / 10 > ans || Integer.MIN_VALUE / 10 == ans && n < -8))
               return 0;
            ans = ans * 10 + n;            
        }
        return ans;
    }
}
// @code-end
