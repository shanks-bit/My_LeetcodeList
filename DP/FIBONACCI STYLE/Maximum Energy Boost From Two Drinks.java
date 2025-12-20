// leetcode -> https://leetcode.com/problems/maximum-energy-boost-from-two-drinks/description/
class Solution {
    private long[][] dp;
    
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        dp = new long[n][2];

        for (long[] row : dp){
            Arrays.fill(row, -1);
        }
        return Math.max(topDown(energyDrinkA, energyDrinkB, 0, 1),
                        topDown(energyDrinkA, energyDrinkB, 0, 0));
    }
    private long topDown(int[] A, int[] B, int i, int curr){
        //base case
        if (i >= A.length) return 0;
        if (dp[i][curr] != -1) return dp[i][curr];

        long res = 0;
        //cur == 1 i.e means A is taken and if curr == 0 then B is taken as choice
        if (curr == 1){
            res = Math.max(A[i] + topDown(A, B, i+1, curr), 
                                 topDown(A, B, i+1, 1-curr));
        }
        else{
            res = Math.max(B[i] + topDown(A, B, i+1, curr), 
                                 topDown(A, B, i+1, 1-curr));
        }

        return dp[i][curr] = res;
    }
}
//https://leetcode.com/problems/maximum-energy-boost-from-two-drinks/solutions/5653184/dp-o1-space-by-fahad06-3nc3
