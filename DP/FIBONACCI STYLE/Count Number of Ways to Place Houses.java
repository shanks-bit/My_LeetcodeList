// https://leetcode.com/problems/count-number-of-ways-to-place-houses/description/

class Solution {
    long m = 1000000007;
    long[] dp;
    
    public int countHousePlacements(int n) {
        this.dp = new long[n+1];
        Arrays.fill(this.dp, -1);
        long ans = this.solve(n);
        return (int)((ans* ans)%this.m);
        
    }
    
    // Returns all possible ways we can palce houses in N palces
    public long solve(int n){
        
        // base case (no place left to place a new home)
        if(n <= 0){
            return 1;
        }
        
        // Early return
        if(dp[n] != -1){
            return this.dp[n];
        }
        
        long usedCurrPlace = 1L * this.solve(n-2);
        long notUsedCurrPlace = 1L * this.solve(n-1);
        
        return this.dp[n] = (usedCurrPlace + notUsedCurrPlace)%this.m;
    }
}

/*
Idea is at each place we have 2 choices either place a house at current place or don't place a house at current place.
So traverse both the possiblities and their sum of both the ways will be answer for that iteration.
  */
