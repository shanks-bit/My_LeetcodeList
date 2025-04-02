//leetcode => https://leetcode.com/problems/find-pivot-index/submissions/1593982588/
class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num; // Calculate total sum of array
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - nums[i] - leftSum; // Calculate right sum

            if (leftSum == rightSum) {
                return i; // Found pivot index
            }

            leftSum += nums[i]; // Update left sum
        }

        return -1; // No pivot index found
    }
}
