// GFG -> https://www.geeksforgeeks.org/dsa/count-of-subsets-with-sum-equal-to-x/

// A Java program to count the number of subsets with a
// sum equal to a target using tabular dp
import java.util.Arrays;

class GfG {

    // Function to count the number of subsets
    // with a sum equal to the target using tabular DP
    static int perfectSum(int[] arr, int target) {
        int n = arr.length;

        // Create a 2D DP table
        int[][] dp = new int[n + 1][target + 1];

        // Base case: There's one way to achieve a
        // sum of 0 (by selecting no elements)
        dp[0][0] = 1;

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {      

                // Include the current element if
                // it doesn't exceed the current sum
                if (j >= arr[i - 1]) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
               else {
                 // Exclude the current element
                dp[i][j] = dp[i - 1][j];
               }
            }
        }

        // Return the number of ways to achieve the target
        // sum
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3 };
        int target = 6;
        System.out.println(perfectSum(arr, target));
    }
}
