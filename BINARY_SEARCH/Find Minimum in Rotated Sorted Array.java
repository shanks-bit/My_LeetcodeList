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
/* as mums was sorted and then rotated so    
    Find the mid element of the array.
    If mid element > first element of array this means that we need to look for the inflection point on the right of mid.
    If mid element < first element of array this that we need to look for the inflection point on the left of mid.
*/
