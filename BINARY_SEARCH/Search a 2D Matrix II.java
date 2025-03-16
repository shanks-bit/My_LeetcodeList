//leetcode => https://leetcode.com/problems/search-a-2d-matrix-ii/description/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0, col = m - 1;
        
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        
        return false;
    }
}


//Start from the top-right corner of the matrix (row = 0, col = m-1), where n is the number of rows and m is the number of columns in the matrix.
//Compare the element at the current position (matrix[row][col]) with the target value:
//    If the element is equal to the target, return true.
//    If the element is less than the target, move to the next row (row++) to explore larger elements.
//    If the element is greater than the target, move to the previous column (col--) to explore smaller elements.
//Continue the process until either the target is found, or the search goes out of bounds (row >= n or col < 0).
//If the target is not found in the matrix, return false.
