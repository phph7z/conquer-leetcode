// @desc-start
// Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
// More formally check if there exists two indices i and j such that :
// 
// i != j
// 0 <= i, j < arr.length
// arr[i] == 2 * arr[j]
// 
//  
// Example 1:
// 
// Input: arr = [10,2,5,3]
// Output: true
// Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
// 
// Example 2:
// 
// Input: arr = [7,1,14,11]
// Output: true
// Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
// 
// Example 3:
// 
// Input: arr = [3,1,7,11]
// Output: false
// Explanation: In this case does not exist N and M, such that N = 2 * M.
// 
//  
// Constraints:
// 
// 2 <= arr.length <= 500
// -10^3 <= arr[i] <= 10^3
// 
// 
// @desc-end

#include <uthash.h>
#define bool int

// @code-start

struct hashmap
{
	int key;
	int value;
	UT_hash_handle hh;
};

struct hashmap *dict = NULL;

void add_to_hashmap(int key, int value)
{
    struct hashmap *s;
    HASH_FIND_INT(dict, &key, s);
    if (s == NULL)
    {
        s = (struct hashmap *)malloc(sizeof *s);
        s->key = key;
        HASH_ADD_INT(dict, key, s);
    }
    s->value = value;
}

void delete_hashmap()
{
    struct hashmap *current, *tmp;
    HASH_ITER(hh, dict, current, tmp)
    {
        HASH_DEL(dict, current);
        free(current);
    }
}

bool checkIfExist(int* arr, int arrSize){
	dict = NULL;

	for(int i = 0; i < arrSize; i++)
	{
		add_to_hashmap(*(arr + i), i);
	}
	for(int i = 0; i < arrSize; i++)
	{
		int n = *(arr + i) * 2;
		struct hashmap *s;
		HASH_FIND_INT(dict, &n, s);
		if(s != NULL && s->value != i)
		{
			return 1;
		}
	}
	return 0;
}
// @code-end
