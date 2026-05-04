https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/editorial/

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        int[] cols = new int[c];
        int res = 0;

        for (int i=0; i<r; i++){
            int rows = 0;
            for (int j=0; j<c; j++){
                cols[j] += grid[i][j];
                rows += cols[j];
                if (rows <= k) res++;
            }
        }
        return res;
    }
}
