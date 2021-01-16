// @desc-start
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//  
// Example 1:
// 
// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
// 
// Example 2:
// 
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// 
// Example 3:
// 
// Input: nums = [0]
// Output: 0
// 
//  
// Constraints:
// 
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000
// 
// 
// @desc-end


// @code-start
class Solution {
    public int rob(int[] nums) {
		if(nums==null) return 0;
		int n = nums.length;
		if(n==0) return 0;
		if(n==1) return nums[0];
		int[] memo = new int[nums.length];
		Arrays.fill(memo, -1);
		int v1 = dp(nums, 0, nums.length-2, 0, memo);
		Arrays.fill(memo, -1);
		int v2 = dp(nums, 1, nums.length-1, 1, memo);
		return Math.max(v1, v2);
    }

	private int dp(int[] nums, int start, int end, int i, int[] memo) {
		if(i>end) return 0;
		if(memo[i]!=-1) return memo[i];
		memo[i] = Math.max(dp(nums, start, end, i+1, memo), nums[i]+dp(nums, start, end, i+2, memo));
		return memo[i];
	}
}
// @code-end
