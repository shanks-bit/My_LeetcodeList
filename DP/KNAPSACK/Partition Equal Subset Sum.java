// leetcode -> https://leetcode.com/problems/partition-equal-subset-sum/description/

class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][subSetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subSetSum; j++) {
                if (j >= curr)
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - curr]);                    
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][subSetSum];
    }
}
