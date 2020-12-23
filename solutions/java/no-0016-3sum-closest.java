// @desc-start
// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//  
// Example 1:
// 
// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//  
// Constraints:
// 
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
// 
// 
// @desc-end


// @code-start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int i = 0;
		int minAbs = Integer.MAX_VALUE;
		int ret = Integer.MAX_VALUE;
		while(i < nums.length - 2) {
			int v = nums[i];
			int twoSum = twoSumClosest(nums, i + 1, nums.length - 1, target - v);
			int sum = v + twoSum;
			int delta = Math.abs(sum - target);
			if(delta < minAbs) {
				minAbs = delta;
				ret = sum;
			}
			i++;
		}
		return ret;
    }

	private int twoSumClosest(int[] nums, int start, int end, int target) {
		int minAbs = Integer.MAX_VALUE;
		int ret = Integer.MAX_VALUE;
		int l = start;
		int r = end;
		while(l < r) {
			int lv = nums[l];
			int rv = nums[r];
			int sum = lv + rv;
			int delta = Math.abs(sum - target);
			if(delta < minAbs) {
				minAbs = delta;
				ret = sum;
			}
			if(sum >= target) {
				r--;
			} else if(sum < target) {
				l++;
			}
		}
		return ret;
	}
}
// @code-end
