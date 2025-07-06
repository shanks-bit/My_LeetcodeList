// GFG -> https://www.geeksforgeeks.org/dsa/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/

// Java Code to partition a set into two 
// subsets such that the difference 
// of subset sums is minimum, using Tabulation
import java.util.*;

class GfG {

    // Function to get the minimum difference 
    // using tabulation
    static int minDifference(ArrayList<Integer> arr) {
        int sumTotal = 0;

        // Calculate total sum of the array
        for (int num : arr) {
            sumTotal += num;
        }

        int n = arr.size();

        // Create a DP table where dp[i][j] represents
        // if a subset sum 'j' is achievable 
        // using the first 'i' elements
        boolean[][] dp = new boolean[n + 1][sumTotal + 1];

        // A sum of 0 is always achievable (empty subset)
        dp[0][0] = true;

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= sumTotal; sum++) {             
                

                // Include the current element if sum >= arr[i-1]
                if (sum >= arr.get(i - 1)) {
                    dp[i][sum] = dp[i][sum] 
                          || dp[i - 1][sum - arr.get(i - 1)];
                }
                else {
                  // Exclude the current element
                  dp[i][sum] = dp[i - 1][sum];
                }
            }
        }

        // Find the minimum difference
        int minDiff = Integer.MAX_VALUE;

        // Iterate over all possible subset sums
        // and find the minimum difference
        for (int sum = 0; sum <= sumTotal / 2; sum++) {
            if (dp[n][sum]) {
                minDiff = Math.min(minDiff,
                                 Math.abs((sumTotal - sum) - sum));
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr 
             = new ArrayList<>(Arrays.asList(1, 6, 11, 5));

        System.out.println(minDifference(arr));
    }
}
