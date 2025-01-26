//leetcode => https://leetcode.com/problems/combination-sum-iv/

import java.util.Arrays;

class Solution {
    int[][] dp;
    int n;

    private int solve(int idx, int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (idx >= n || target < 0) {
            return 0;
        }

        if (dp[target][idx] != -1) {
            return dp[target][idx];
        }

        int result = 0;
        for (int i = idx; i < n; i++) {
            result += solve(0, nums, target - nums[i]);
        }

        return dp[target][idx] = result;
    }

    public int combinationSum4(int[] nums, int target) {
        n = nums.length;
        dp = new int[target + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, nums, target);
    }
}

---------------------------------------------------------------------------------------
class Solution {
    int[] t;
    
    public int combinationSum4(int[] nums, int target) {
        t = new int[target+1];
        Arrays.fill(t,-1);
        return solve(nums,target);
    }

    public int solve(int[] nums, int target)
    {
        if(target == 0) {
            return 1;
        }
        if(target < 0) {
            return 0;
        }
        
        if(t[target] != -1) {
            return t[target];
        }
        
        int result = 0;
        for(int i = 0; i<nums.length;i++) {
            result += solve(nums, target-nums[i]);
        }
        return t[target] = result;
    }
}
