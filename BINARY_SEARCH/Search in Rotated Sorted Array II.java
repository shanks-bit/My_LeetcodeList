//leetcode => https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while( left < right){
            int mid = (left + right) >>> 1;

            if( nums[mid] > nums[right]){
                if( nums[left] <= target && target <= nums[mid]){
                    right = mid;
                }
                else{
                    left = mid + 1;
                }
            }
            else if(nums[mid] < nums[right]){
                if( nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            else{
                right -= 1;
            }
        }
        return nums[left] == target;
    }
}
