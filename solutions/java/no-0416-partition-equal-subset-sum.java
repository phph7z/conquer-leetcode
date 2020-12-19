// @desc-start
// Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//  
// Example 1:
// 
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
// Example 2:
// 
// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
// 
//  
// Constraints:
// 
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
// 
// 
// @desc-end


// @code-start
class Solution {
    public boolean canPartition(int[] nums) {
		int sum = 0;
		for(int n : nums) {
			sum += n;
		}
		if(sum % 2 != 0) {
			return false;
		}
		int n = nums.length;
		sum = sum / 2;
		boolean dp[][] = new boolean[n + 1][sum + 1];
		// base case
		for(int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}
		// fill the table
		for(int i = 1; i <= nums.length; i++) {
			for(int j = 1; j <= sum; j++) {
				// check edge case
				if(j - nums[i - 1] < 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				}
			}
		}
		return dp[n][sum];
    }
}
// @code-end
