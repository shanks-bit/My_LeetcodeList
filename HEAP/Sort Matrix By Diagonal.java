// leetcode -> https://leetcode.com/problems/sort-matrix-by-diagonals/description/
/*
Each diagonal can be mapped using the key i - j:
If i - j >= 0 → bottom-left → sort in descending order.
If i - j < 0 → top-right → sort in ascending order.
To efficiently sort while building the matrix back:
Use a min-heap (PriorityQueue) for ascending order (top-right).
Use a max-heap (PriorityQueue with reverse order) for descending order (bottom-left).
Traverse the matrix once to collect elements into their corresponding priority queues.
Traverse the matrix again, and for each cell (i, j) fetch the next element from its diagonal’s heap.
Return the modified matrix. */

class Solution {
    public int[][] sortMatrix(int[][] matrix) {
        Map<Integer, PriorityQueue<Integer>> diagonalMap = new 
                                            HashMap<>();
        int rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                diagonalMap.putIfAbsent(key, key < 0 ? 
                                        new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder()));

                diagonalMap.get(key).offer(matrix[i][j]);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                matrix[i][j] = diagonalMap.get(key).poll();
            }
        }

        return matrix;
    }
}
