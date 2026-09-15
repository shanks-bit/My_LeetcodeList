// https://leetcode.com/problems/rotate-image/description/

class Solution {
    public void rotate(int[][] matrix) {
        int top=0, bottom = matrix.length-1;
        // vertical movement
        while (top < bottom){
            for (int c=0; c<matrix.length; c++){
                int temp = matrix[top][c];
                matrix[top][c] = matrix[bottom][c];
                matrix[bottom][c] = temp;
            }
            top++;
            bottom--;
        }

        // transpose matrix
        for (int row=0; row<matrix.length; row++){
            for (int col=row+1; col<matrix.length; col++){
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }
}
