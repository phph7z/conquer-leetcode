// @desc-start
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
//  
// Example 1:
// 
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
// Example 2:
// 
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// 
// Example 3:
// 
// Input: nums = [3,3], target = 6
// Output: [0,1]
// 
//  
// Constraints:
// 
// 2 <= nums.length <= 105
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
// 
// 
// @desc-end

#include <uthash.h>

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

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *twoSum(int *nums, int numsSize, int target, int *returnSize)
{
    *returnSize = 2;
    int *ret = (int *)malloc(*returnSize * sizeof(int));

    for (int i = 0; i < numsSize; ++i)
    {
        add_to_hashmap(nums[i], i);
    }

    for (int i = 0; i < numsSize; ++i)
    {
        int num = target - nums[i];

        struct hashmap *s;
        HASH_FIND_INT(dict, &num, s);
        if (s != NULL && s->value != i)
        {
            ret[0] = i;
            ret[1] = s->value;
            break;
        }
    }
    delete_hashmap();

    return ret;
}
// @code-end
