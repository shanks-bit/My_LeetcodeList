// GFG -> https://www.geeksforgeeks.org/dsa/cutting-a-rod-dp-13/

// Java program to find maximum
// profit from rod of size n and only one array is given so dp[]

import java.util.*;

class GfG {

    static int cutRod(int[] price) {
        int n = price.length;
        int[] dp = new int[n + 1];

        // Find maximum value for all 
        // rod of length i.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }
}
