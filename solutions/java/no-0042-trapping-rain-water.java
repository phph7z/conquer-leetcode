// @desc-start
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//  
// Example 1:
// 
// 
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// 
// Example 2:
// 
// Input: height = [4,2,0,3,2,5]
// Output: 9
// 
//  
// Constraints:
// 
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
// 
// 
// @desc-end


// @code-start
class Solution {
    public int trap(int[] height) {
		if(height.length == 0)
			return 0;
		int left = 0;
		int right = height.length - 1;
		int ans = 0;
		int leftMax = height[0];
		int rightMax = height[height.length - 1];
		while(left <= right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);
			if(leftMax < rightMax) {
				ans += leftMax - height[left];
				left ++;
			} else {
				ans += rightMax - height[right];
				right --;
			}
		}
		return ans;
    }
}
// @code-end
