# Thoughts

1. recording the lenth of "new" array,

2. using two pointers to count, compare

--> if arr[i] == arr[j], we juse increase j(j++)

--> if arr[i] != arr[j], copy value of arr[j] into arr[i+1], then increase i, j;

# TC ST

one for loop, so T: O(n), no new space, S: O(1),

# Optimization

If an array doesn't have any duplicates, we might copy arr[j] into arr[i+1] n-1 times, (j == i+1) which is unnecessary. 

So, every time before passing value, we could have a check, if j == i + 1, ignore the passing value step;

# Reference

Thanks to: 

https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
