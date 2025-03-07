//leetcode => https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        if( nums[l] <= nums[r]){
            return nums[0];
        }
        while(l < r){
            int m = r + l >>> 1;
            if(nums[0] <= nums[m]){
                l = m + 1;
            }
            else{
                r = m;
            }
        }
        return nums[l];
    }
}
