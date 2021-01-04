// @desc-start
// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Example 1:
// 
// Input: [3,2,1,5,6,4] and k = 2
// Output: 5
// 
// Example 2:
// 
// Input: [3,2,3,1,2,4,5,5,6] and k = 4
// Output: 4
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ array's length.
// 
// @desc-end


// @code-start
class Solution {
    public int findKthLargest(int[] nums, int k) {
		shuffle(nums);
		int len = nums.length;
		k = len - k;
		int low = 0;
		int high = len - 1;
		while(low <= high) {
			int pivotIndex = partition(nums, low, high);
			if(k > pivotIndex) {
				low = pivotIndex + 1;
			} else if(k < pivotIndex) {
				high = pivotIndex - 1;
			} else {
				return nums[pivotIndex];
			}
		}
		return -1;
    }

	private void shuffle(int[] nums) {
		int n = nums.length;
		Random rand = new Random();
		for(int i = 0; i < n; i++) {
			int r = rand.nextInt(n - i);
			swap(nums, i, r);
		}
	}

	private int partition(int[] nums, int p, int r) {
		int pivot = nums[r];
		int i = p;
		for(int j = p; j < r; j++) {
			if(nums[j] < pivot) {
				swap(nums, i, j);
				i++;
			}
		}
		swap(nums, i, r);
		return i;
	}

	private void swap(int[] nums, int p, int r) {
		int t = nums[p];
		nums[p] = nums[r];
		nums[r] = t;
	}
}
// @code-end
