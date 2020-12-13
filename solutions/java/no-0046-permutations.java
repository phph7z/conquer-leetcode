// @desc-start
// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//  
// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:
// Input: nums = [1]
// Output: [[1]]
// 
//  
// Constraints:
// 
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.
// 
// 
// @desc-end


// @code-start
class Solution {

	private List<List<Integer>> permutations = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
		permute(nums, new ArrayList<>());
		return permutations;
    }

	public void permute(int[] nums, List<Integer> visited) {
		if(visited.size() == nums.length) {
			permutations.add(new ArrayList<>(visited));
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if(visited.contains(n)) {
				continue;
			}
			visited.add(n);
			permute(nums, visited);
			visited.remove(visited.size() - 1);
		}
	}
}
// @code-end
