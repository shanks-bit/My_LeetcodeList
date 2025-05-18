// leetcode => https://leetcode.com/problems/path-with-minimum-effort/solutions/4049576/99-92-dijkstra-s-algorithm-binary-search-commented-code/

class Solution {
    static class Cell {
        int effort, x, y;

        Cell(int effort, int x, int y) {
            this.effort = effort;
            this.x = x;
            this.y = y;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] directions = {
            {-1, 0},
            {0, -1}, {0, 1},
            {1, 0}
        };

        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.effort));
        pq.offer(new Cell(0, 0, 0));
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            Cell current = pq.poll();

            int x = current.x;
            int y = current.y;
            int diff = current.effort;

            // If destination is reached
            if (x == m - 1 && y == n - 1) {
                return diff;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {

                    int newEffort = Math.max(diff, Math.abs(heights[x][y] - heights[newX][newY]));

                    if (newEffort < result[newX][newY]) {
                        result[newX][newY] = newEffort;
                        pq.offer(new Cell(newEffort, newX, newY));
                    }
                }
            }
        }

        return result[m - 1][n - 1];
    }
}
