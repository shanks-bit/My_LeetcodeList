// leetcode => https://leetcode.com/problems/maximum-erasure-value/description/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0, curSum = 0, left = 0, right = 0;
        HashSet<Integer> sett = new HashSet<>();

        while (right < nums.length) {

            while (sett.contains(nums[right])) {
                sett.remove(nums[left]);
                curSum -= nums[left];
                left++;
            }
            curSum += nums[right];
            sett.add(nums[right]);
            res = Math.max(res, curSum);
            right++;
        }
        return res;
    }
}
