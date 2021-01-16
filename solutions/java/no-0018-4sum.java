// @desc-start
// Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
// Notice that the solution set must not contain duplicate quadruplets.
//  
// Example 1:
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2:
// Input: nums = [], target = 0
// Output: []
// 
//  
// Constraints:
// 
// 0 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 
// 
// @desc-end


// @code-start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		if(nums == null || nums.length < 4) return ret;
		Arrays.sort(nums);
		for(int i=0; i<nums.length;i++) {
			List<List<Integer>> groups = threeSum(nums, i+1, target-nums[i]);
			for(List<Integer> group : groups) {
				group.add(nums[i]);
				ret.add(group);
			}
			while(i<nums.length-1&&nums[i]==nums[i+1]) i++;
		}
		return ret;
    }

	private List<List<Integer>> threeSum(int[] nums, int start, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		for(int i=start; i<nums.length;i++) {
			List<List<Integer>> groups = twoSum(nums, i+1, target-nums[i]);
			for(List<Integer> group : groups) {
				group.add(nums[i]);
				ret.add(group);
			}
			while(i<nums.length-1&&nums[i]==nums[i+1]) i++;
		}
		return ret;
	}

	private List<List<Integer>> twoSum(int[] nums, int start, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		int lo = start;
		int hi = nums.length - 1;
		while(lo < hi) {
			int left = nums[lo];
			int right = nums[hi];
			int sum = left + right;
			if(sum == target) {
				List<Integer> group = new ArrayList<>();
				group.add(nums[lo]);
				group.add(nums[hi]);
				ret.add(group);
				while(lo<hi && nums[lo]==left) lo++;
				while(lo<hi && nums[hi]==right) hi--;
			} else if(sum > target) {
				while(lo<hi && nums[hi]==right) hi--;
			} else if(sum < target) {
				while(lo<hi && nums[lo]==left) lo++;
			}
		}
		return ret;
	}
}
// @code-end
