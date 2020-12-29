// @desc-start
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//  
// Example 1:
// 
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
// Example 2:
// 
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//  
// Constraints:
// 
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
// 
// 
// @desc-end


// @code-start
class Solution {
    public int[][] merge(int[][] intervals) {
		if(intervals.length <= 1) {
			return intervals;
		}
		List<int[]> ret = new ArrayList<>();
		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
		int n = intervals.length;
		int start = intervals[0][0];
		int end = intervals[0][1];
		for(int i = 1; i < n; i++) {
			int[] interval = intervals[i];
			if(interval[0] > end) {
				ret.add(new int[]{start, end});
				start = interval[0];
				end = interval[1];
			} else {
				if(interval[1] > end) {
					end = interval[1];
				}
			}
		}
		ret.add(new int[]{start, end});
		int[][] retArr = new int[ret.size()][2];
		for(int i = 0; i < ret.size(); i++) {
			retArr[i] = ret.get(i);
		}
		return retArr;
    }
}
// @code-end
