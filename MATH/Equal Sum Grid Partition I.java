// leetcode -> https://leetcode.com/problems/equal-sum-grid-partition-i/description/

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;     // number of rows
        int m = grid[0].length;  // number of columns

        long[] prefixRowWise = new long[n];
        long[] prefixColWise = new long[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = grid[i][j];
                prefixRowWise[i] += v;  // Sum of each row
                prefixColWise[j] += v;  // Sum of each column
            }
        }

        long totalRowSum = 0, totalColSum = 0;
        for (long r : prefixRowWise) totalRowSum += r;

        totalColSum = totalRowSum;  // total is same regardless of row-wise or column-wise computation

        // Try All Possible Horizontal Cuts
        long currentRowUpperSum = 0L;
        for (int i = 0; i < n - 1; i++) {

            currentRowUpperSum += prefixRowWise[i];
            long lowerSegmentSum = totalRowSum - currentRowUpperSum;
            if (currentRowUpperSum == lowerSegmentSum) return true;
        }

        // Try All Possible Vertical Cuts
        long currentColLeftSum = 0L;
        for (int j = 0; j < m - 1; j++) {
            
            currentColLeftSum += prefixColWise[j];
            long rightSegmentSum = totalColSum - currentColLeftSum;
            if (currentColLeftSum == rightSegmentSum) return true;
        }

        return false;
    }
}
