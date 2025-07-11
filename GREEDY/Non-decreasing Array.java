// leetcode -> https://leetcode.com/problems/non-decreasing-array/description/
/*
This problem is like a greedy problem. When you find nums[i-1] > nums[i] for some i, you will prefer to change nums[i-1]'s value, since a larger nums[i]
will give you more risks that you get inversion errors after position i. But, if you also find nums[i-2] > nums[i], then you have to change nums[i]'s value
instead, or else you need to change both of nums[i-2]'s and nums[i-1]'s values.
*/
class Solution {
    public boolean checkPossibility(int[] nums) {
        int numViolations = 0;
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i - 1] > nums[i]) {
                
                if (numViolations == 1) {
                    return false;
                }
                
                numViolations++;
                
                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        
        return true;
    }
}
