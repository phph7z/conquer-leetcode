// @desc-start
// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// Follow up: Could you write an algorithm with O(log n) runtime complexity?
//  
// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]
// 
//  
// Constraints:
// 
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109
// 
// 
// @desc-end


// @code-start
class Solution {
    public int[] searchRange(int[] nums, int target) {
		if(nums==null||nums.length==0) return new int[]{-1,-1};
		int left = leftBound(nums, target);
		if(left ==-1) return new int[]{-1,-1};
		int right = rightBound(nums, target);
		return new int[]{left, right};
    }

	private int leftBound(int[] nums, int target) {
		int lo=0;
		int hi=nums.length-1;
		int index = -1;
		while(lo<=hi) {
			int mid = lo+(hi-lo)/2;
			if(nums[mid] == target) {
				index = mid;
				hi = mid-1;
			} else if(nums[mid] > target) {
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		return index;
	}

	private int rightBound(int[] nums, int target) {
		int lo=0;
		int hi=nums.length-1;
		int index=-1;
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			if(nums[mid] == target) {
				index=mid;
				lo = mid+1;
			} else if(nums[mid] > target) {
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		return index;
	}
}
// @code-end
