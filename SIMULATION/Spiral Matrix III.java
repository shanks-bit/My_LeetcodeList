// https://leetcode.com/problems/spiral-matrix-iii/description/

class Solution {
    int leftBound, topBound, rightBound, bottomBound, currentIndex;
    int[][] path;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int totalCells = cols * rows;
        path = new int[totalCells][];
        
        initializeBounds(rStart, cStart);
        addToPath(rStart, cStart);
        
        while (currentIndex < totalCells) {
            if (topBound >= 0) {
                traverseEast(Math.max(0, leftBound + 1), Math.min(cols - 1, rightBound));
            }
            bottomBound++;
            if (currentIndex >= totalCells) break;
            
            if (rightBound < cols) {
                traverseSouth(Math.max(0, topBound + 1), Math.min(rows - 1, bottomBound));
            }
            leftBound--;
            if (currentIndex >= totalCells) break;
            
            if (bottomBound < rows) {
                traverseWest(Math.min(cols - 1, rightBound - 1), Math.max(0, leftBound));
            }
            topBound--;
            if (currentIndex >= totalCells) break;
            
            if (leftBound >= 0) {
                traverseNorth(Math.min(rows - 1, bottomBound - 1), Math.max(0, topBound));
            }
            rightBound++;
            if (currentIndex >= totalCells) break;
        }
        
        return path;
    }

    private void initializeBounds(int rStart, int cStart) {
        leftBound = rightBound = cStart;
        topBound = bottomBound = rStart;
        currentIndex = 0;
        rightBound++;
    }

    private void addToPath(int row, int col) {
        path[currentIndex++] = new int[]{row, col};
    }

    private void traverseEast(int start, int end) {
        for (int i = start; i <= end; i++) addToPath(topBound, i);
    }

    private void traverseWest(int start, int end) {
        for (int i = start; i >= end; i--) addToPath(bottomBound, i);
    }

    private void traverseSouth(int start, int end) {
        for (int i = start; i <= end; i++) addToPath(i, rightBound);
    }

    private void traverseNorth(int start, int end) {
        for (int i = start; i >= end; i--) addToPath(i, leftBound);
    }
}
