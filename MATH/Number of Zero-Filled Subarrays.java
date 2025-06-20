// leetcode -> https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int i = 0, res = 0;
        // subarray ends with 0
        while (i < nums.length) {
            int count = 0;
            // Count consecutive zeros
            while (i < nums.length && nums[i] == 0) {
                count++;
                i++;
                res += count;
            }
            i++;
        }
        
        return res;
    }
    
}
