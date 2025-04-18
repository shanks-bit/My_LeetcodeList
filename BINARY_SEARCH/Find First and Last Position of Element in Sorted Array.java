// leetcode link => https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lIndex = find(nums, target);
        int rIndex = find(nums, target + 1);

        if(lIndex == rIndex){
            return new int[] {-1,-1};
        }
        else{
            return new int[] {lIndex, rIndex - 1};
        }
    }

    private int find(int[] nums, int targ) {
        int l = 0;
        int r = nums.length;
        while( l < r){
            int m = (l + r) >>> 1;
            if(nums[m] >= targ){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return l;
    }
}
