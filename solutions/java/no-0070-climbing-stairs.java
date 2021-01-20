// @desc-start
// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//  
// Example 1:
// 
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// 
// Example 2:
// 
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
// 
//  
// Constraints:
// 
// 1 <= n <= 45
// 
// 
// @desc-end


// @code-start
class Solution {
    public int climbStairs(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return climbStairs(n, memo);
    }

	private int climbStairs(int n, int[] memo) {
		if(n==1) return 1;
		if(n==2) return 2;
		if(memo[n] != -1) return memo[n];
		int ans = climbStairs(n-1, memo) + climbStairs(n-2, memo);
		memo[n] = ans;
		return ans;
	}
}
// @code-end
