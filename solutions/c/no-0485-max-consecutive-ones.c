// @desc-start
// Given a binary array, find the maximum number of consecutive 1s in this array.
// Example 1:
// 
// Input: [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s.
//     The maximum number of consecutive 1s is 3.
// 
// 
// Note:
// 
// The input array will only contain 0 and 1.
// The length of input array is a positive integer and will not exceed 10,000
// 
// 
// @desc-end


// @code-start


int findMaxConsecutiveOnes(int* nums, int numsSize){
	int slow = -1;
	int fast = 0;
	int max = 0;

	while (fast < numsSize)
	{
		if (*(nums + fast) == 0)
		{
			if (slow != -1)
			{
				if (fast - slow > max)
				{
					max = fast - slow;
				}
				slow = -1;
			}
		}
		else
		{
			if (slow == -1)
			{
				slow = fast;
			}
		}
		fast ++;
	}
	if (slow != -1)
	{
		if (fast - slow > max)
		{
			max = fast - slow;
		}
	}
	return max;
}
// @code-end
