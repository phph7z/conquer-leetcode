// @desc-start
// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
// Return the max sliding window.
//  
// Example 1:
// 
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// 
// Example 2:
// 
// Input: nums = [1], k = 1
// Output: [1]
// 
// Example 3:
// 
// Input: nums = [1,-1], k = 1
// Output: [1,-1]
// 
// Example 4:
// 
// Input: nums = [9,11], k = 2
// Output: [11]
// 
// Example 5:
// 
// Input: nums = [4,-2], k = 2
// Output: [4]
// 
//  
// Constraints:
// 
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
// 
// 
// @desc-end


// @code-start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		Queue<int[]> largeHeap = new PriorityQueue<int[]>((a,b)->a[0]!=b[0]?b[0]-a[0]:b[1]-a[1]);
		for(int i=0;i<k;i++) {
			largeHeap.offer(new int[]{nums[i], i});
		}
		int[] ret = new int[nums.length-k+1];
		ret[0] = largeHeap.peek()[0];
		for(int i=k; i<nums.length;i++) {
			largeHeap.offer(new int[]{nums[i], i});
			while(largeHeap.peek()[1] <= i-k) {
				largeHeap.poll();
			}
			ret[i-k+1]=largeHeap.peek()[0];
		}
		return ret;
    }
}
// @code-end
