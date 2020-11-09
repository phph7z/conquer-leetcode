// @desc-start
// Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
// You may return any answer array that satisfies this condition.
//  
// 
// Example 1:
// 
// Input: [3,1,2,4]
// Output: [2,4,3,1]
// The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
// 
//  
// Note:
// 
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000
// 
// 
// 
// @desc-end

#include <stdlib.h>


// @code-start


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortArrayByParity(int* A, int ASize, int* returnSize){
	int left = 0;
	int right = ASize - 1;
	int *ret = (int *)malloc(sizeof(int) * ASize);
	for(int i = 0; i < ASize; i++)
	{
		if(*(A + i) % 2 == 0)
		{
			*(ret + left) = *(A + i);
			left ++;
		}
		else
		{
			*(ret + right) = *(A + i);
			right --;
		}
	}
	*returnSize = ASize;
	return ret;
}
// @code-end
