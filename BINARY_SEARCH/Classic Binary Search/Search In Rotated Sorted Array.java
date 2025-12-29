//leetcode => https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] < nums[r]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
    }
} 
