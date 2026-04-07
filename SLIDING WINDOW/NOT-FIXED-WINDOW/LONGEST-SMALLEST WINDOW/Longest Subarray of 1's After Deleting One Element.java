// leetcode => https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/

class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int longestWindow = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeroCount++;
            }

            // Shrink the window until the zero count comes under the limit.
            while (zeroCount > 1) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }

            // Calculate the length of the current valid window.
            longestWindow = Math.max(longestWindow, j - i);
        }

        return longestWindow;
    }
}
