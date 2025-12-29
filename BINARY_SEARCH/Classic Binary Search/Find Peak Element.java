// leetcode => https://leetcode.com/problems/find-peak-element/description/

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while( l < r){
            int m = r + l >>> 1;
            if( nums[m] > nums[m+1]){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return l;
    }
}
