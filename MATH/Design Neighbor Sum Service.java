// leetcode -> https://leetcode.com/problems/design-neighbor-sum-service/description/
class NeighborSum {
    private int[][] grid;
    private int len;
    private Map<Integer, int[]> positions;
    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.len = grid.length;
        this.positions = new HashMap<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                positions.put(grid[i][j], new int[]{i, j});
            }
        }
    }
    
    public int adjacentSum(int value) {
        int[] pos = positions.get(value);
        int i = pos[0], j = pos[1];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int result = 0;

        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < len && y >= 0 && y < len) {
                result += grid[x][y];
            }
        }
        return result;
    }
    
    public int diagonalSum(int value) {
        int[] pos = positions.get(value);
        int i = pos[0], j = pos[1];
        int[][] dirs = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        int result = 0;

        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < len && y >= 0 && y < len) {
                result += grid[x][y];
            }
        }
        return result;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
