// GFG -> https://www.geeksforgeeks.org/count-of-subsets-with-given-difference/
// Java Implementation
import java.util.*;

class Main {
    public static int countSub(ArrayList<Integer> v, int n, int diff) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += v.get(i);
        if (diff > sum)
            return 0;

        if ((diff + sum) % 2 != 0)
            return 0;

        int s2 = (diff + sum) / 2;

        int[][] dp = new int[n + 1][s2 + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int j = 1; j <= s2; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s2; j++) {
                if (v.get(i - 1) <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - v.get(i - 1)];                    
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][s2];
    }

    public static void main(String[] args) {
        int n, diff;
        ArrayList<Integer> v = new ArrayList<>();
        n = 5;
        diff = 1;
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(1);
        v.add(2);
        System.out.println(countSub(v, n, diff));
    }
}
// This code is contributed by Tapesh(tapeshdua420)
