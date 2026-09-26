// https://leetcode.com/problems/max-consecutive-ones-iii/description/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, maxOne = 0, zeroCnt = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCnt ++;                
            }
            while (zeroCnt > k) {
                if (nums[left] == 0) {
                    zeroCnt --;
                }
                left ++;
            }
            maxOne = Math.max(maxOne, right - left + 1);
            right ++;
        }
        return maxOne;
    }
}
