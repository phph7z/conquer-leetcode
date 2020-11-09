// @desc-start
// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Example:
// 
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Note:
// 
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
// 
// @desc-end


// @code-start


void moveZeroes(int* nums, int numsSize){
	if(numsSize < 2)
		return;

	int slow = 0;
	int fast = 1;
	
	while(fast < numsSize)
	{
		if(*(nums + slow) == 0)
		{
			if(*(nums + fast) == 0)
			{
				fast ++;
			}
			else
			{
				int t = *(nums + fast);
				*(nums + fast) = *(nums + slow);
				*(nums + slow) = t;
			}
		}
		else
		{
			slow++;
			if(slow == fast)
			{
				fast ++;
			}
		}
	}
}
// @code-end
