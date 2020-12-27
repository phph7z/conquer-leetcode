// @desc-start
// You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
// Find out how many ways to assign symbols to make sum of integers equal to target S.
// Example 1:
// 
// Input: nums is [1, 1, 1, 1, 1], S is 3. 
// Output: 5
// Explanation: 
// 
// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3
// 
// There are 5 ways to assign symbols to make the sum of nums be target 3.
// 
//  
// Constraints:
// 
// The length of the given array is positive and will not exceed 20.
// The sum of elements in the given array will not exceed 1000.
// Your output answer is guaranteed to be fitted in a 32-bit integer.
// 
// 
// @desc-end


// @code-start
class Solution {

    public int findTargetSumWays(int[] nums, int S) {
		// sum(A) = target + sum(B)
		// sum(A) + sum(A) = target + sum(B) + sum(A);
		// 2 * sum(A) = target + sum(nums)
		// sum(A) = (target + sum(nums)) / 2;

		int sum = 0;
		for(int n : nums) {
			sum += n;
		}
		int target = (S + sum) / 2;
		if(sum < S || (sum + S) % 2 == 1) {
			return 0;
		}
		return subset(nums, target);
	}

	private int subset(int[] nums, int target) {
		int n = nums.length;
		int[][] dp = new int[n + 1][target + 1];
		// base case
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= target; j++) {
				if(j >= nums[i - 1]) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][target];
	}

}
// @code-end
