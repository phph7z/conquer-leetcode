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
		Arrays.sort(nums);
		List<List<Integer>> ret = new ArrayList<>();

		int i = 0;
		while(i < nums.length - 1) {
			int v = nums[i];
			List<List<Integer>> list = threeSum(nums, i + 1, nums.length - 1, target - v);
			for(List<Integer> l : list) {
				l.add(0, v);
				ret.add(l);
			}
			while(i < nums.length - 1 && nums[i] == v) i++;
		}
		return ret;
    }

	private List<List<Integer>> threeSum(int[] nums, int start, int end, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		int i = start;
		while(i < end) {
			int v = nums[i];
			List<List<Integer>> list = twoSum(nums, i + 1, end, target - v);
			for(List<Integer> l : list) {
				l.add(0, v);
				ret.add(l);
			}
			while(i < end && nums[i] == v) i ++;
		}
		return ret;
	}

	private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		int l = start;
		int r = end;
		while(l < r) {
			int lv = nums[l];
			int rv = nums[r];
			int sum = lv + rv;
			if(sum > target) {
				while(l < r && nums[r] == rv) r--;
			} else if(sum < target) {
				while(l < r && nums[l] == lv) l++;
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(lv);
				list.add(rv);
				ret.add(list);
				while(l < r && nums[l] == lv) l++;
				while(l < r && nums[r] == rv) r--;
			}
		}
		return ret;
	}
}
// @code-end
