// leetcode -> https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/description/
class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, res = 0;

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                // find first element and start backtrack
                if (grid[r][c] != 0)
                    res += backtrack(grid, k, r, c) == 0 ? 1 : 0;
            }
        }
        return res;

    }
    private int backtrack(int[][] grid, int k, int r, int c){
        int m = grid.length, n = grid[0].length;

        //base condition
        if (r < 0 || r == m || c < 0 || c == n || grid[r][c] == 0)
            return 0;

        int res = grid[r][c]; //add element
        grid[r][c] = 0;

        for(int[] dir : directions) {  //Explore element
            int r_ = r + dir[0];
            int c_ = c + dir[1];

            res = (res + backtrack(grid, k, r_, c_)) % k;
        }

        
        return res;
    }
}
