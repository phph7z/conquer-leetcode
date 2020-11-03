// @desc-start
// Given a string s, return the longest palindromic substring in s.
//  
// Example 1:
// 
// Input: s = "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// 
// Example 2:
// 
// Input: s = "cbbd"
// Output: "bb"
// 
// Example 3:
// 
// Input: s = "a"
// Output: "a"
// 
// Example 4:
// 
// Input: s = "ac"
// Output: "a"
// 
//  
// Constraints:
// 
// 1 <= s.length <= 1000
// s consist of only digits and English letters (lower-case and/or upper-case),
// 
// 
// @desc-end

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// @code-start

char *longestPalindrome(char *s)
{
    if (!s)
        return s;
    int len = strlen(s);
    if (len < 2)
        return s;

    int si = 0;
    int ei = 0;
    int pi = 0;
	int loop_size = len * 2 - 1;
    while (pi < loop_size)
    {
		int i = (pi + 1) / 2;
		if (pi % 2 == 0)
		{
			for(int j = 0; i - j >= 0 && i + j < len; j++)
			{
				if (*(s + i - j) == *(s + i + j))
				{
					if((i + j) - (i - j) > (ei - si))
					{
						si = i - j;
						ei = i + j;
					}
				}
				else
				{
					break;
				}
			}
		}
		else
		{
			int li = pi / 2;
			int ri = pi / 2 + 1;
			for(int j = 0; li - j >= 0 && ri + j < len;)
			{
				if(*(s + li - j) == *(s + ri + j))
				{
					if ((ri + j) - (li - j) > (ei - si))
					{
						si = li - j;
						ei = ri + j;
					}
				}
				else
				{
					break;
				}
				li --;
				ri ++;
			}
		}
		pi ++;
    }
    int s_len = ei - si + 1;
    char *ret = malloc((s_len + 1) * sizeof(char));
    *(ret + s_len) = '\0';
    strncpy(ret, s + si, s_len);
    return ret;
}
// @code-end
