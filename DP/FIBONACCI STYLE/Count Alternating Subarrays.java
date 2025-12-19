// leetcode -> https://leetcode.com/problems/count-alternating-subarrays/description/

class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        long cnt = 1;

        //one element is also alternating
        dp[0] = 1;

        for (int i=1; i<len; i++){
            if (nums[i] != nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            else{
                dp[i] = 1;
            }
            cnt += dp[i];
        }
        return cnt;
    }
}
