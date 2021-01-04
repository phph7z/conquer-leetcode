// @desc-start
// Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
//  
// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2
// 
//  
// Constraints:
// 
// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
// 
// 
// @desc-end


// @code-start
class Solution {
    public int subarraySum(int[] nums, int k) {
		Map<Integer,Integer> m = new HashMap<>();
		m.put(0, 1);
		int ans = 0; int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int targetSum = sum - k;
			if(m.containsKey(targetSum)) {
				ans += m.get(targetSum);
			}
			m.put(sum, m.getOrDefault(sum, 0) + 1);
		}
		return ans;
    }
}
// @code-end
