// @desc-start
// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
// Notice that the solution set must not contain duplicate triplets.
//  
// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Example 2:
// Input: nums = []
// Output: []
// Example 3:
// Input: nums = [0]
// Output: []
// 
//  
// Constraints:
// 
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
// 
// 
// @desc-end


// @code-start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		if(nums == null || nums.length == 0) return ret;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			int v = nums[i];
			List<List<Integer>> pairs = twoSum(nums, i+1, 0-v);
			for(List<Integer> pair : pairs) {
				pair.add(v);
				ret.add(pair);
			}
			while(i<nums.length-1&&nums[i]==nums[i+1]) i++;
		}
		return ret;
    }

	private List<List<Integer>> twoSum(int[] nums, int i, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		int start = i; int end = nums.length - 1;
		while(start < end) {
			int left = nums[start];
			int right = nums[end];
			int sum = left + right;
			if(sum < target) {
				while(start<end && nums[start]==left) start++;
			} else if(sum > target) {
				while(start<end && nums[end]==right) end--;
			} else {
				List<Integer> pair = new ArrayList<>();
				pair.add(nums[start]);
				pair.add(nums[end]);
				ret.add(pair);
				while(start<end && nums[start]==left) start++;
				while(start<end && nums[end]==right) end--;
			}
		}
		return ret;
	}
}
// @code-end
