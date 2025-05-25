// leetcode => https://leetcode.com/problems/subarray-product-less-than-k/description/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0, prod = 1, res = 0;

        while(right < nums.length) {
            prod *= nums[right];

            while(left <= right && prod >= k) {
                prod = prod / nums[left];
                left++;
            }
            res += (right - left + 1);
            right++;
        }
        return res;
    }
}
