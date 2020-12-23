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
// Input: nums = [0] Output: []  
// Constraints:
// 
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
// 
// 
// @desc-end


// @code-start
class Solution {

	private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		int i = 0;
		while(i < len - 1) {
			int v = nums[i];
			int target = 0 - v;
			List<List<Integer>> pairList = getTwoSum(nums, i + 1, len - 1, target);
			if(!pairList.isEmpty()) {
				for(List<Integer> pair : pairList) {
					pair.add(0, v);
					ret.add(pair);
				}
			}
			while(i < len - 1 && nums[i] == v) i ++;
		}
		return ret;
    }

	private List<List<Integer>> getTwoSum(int[] nums, int start, int end, int target) {
		List<List<Integer>> retList = new ArrayList<>();
		int l = start;
		int r = end;
		while(l < r) {
			int lv = nums[l];
			int rv = nums[r];
			int sum = lv + rv;
			if(sum > target) {
				while(l < r && nums[r] == rv) r --;
			} else if(sum < target) {
				while(l < r && nums[l] == lv) l ++;
			} else {
				List<Integer> pair = new ArrayList<>();
				pair.add(lv);
				pair.add(rv);
				retList.add(pair);
				while(l < r && nums[r] == rv) r --;
				while(l < r && nums[l] == lv) l ++;
			}
		}
		return retList;
	}
}
// @code-end
