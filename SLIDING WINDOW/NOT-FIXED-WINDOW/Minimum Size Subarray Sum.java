// leetcode => https://leetcode.com/problems/minimum-size-subarray-sum/description/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0, sum = 0, minSize = n+1;

        while (right < n) {
            sum += nums[right];

            while (sum >= target) {
                minSize = Math.min(minSize, right-left+1);

                sum -= nums[left];
                left++;
            }
            right++;
        }

        return minSize == n+1 ? 0 : minSize;
    }
}
// Time Complexity -> O(n)
