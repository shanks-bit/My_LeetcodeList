// https://leetcode.com/problems/diagonal-traverse/description/

/*Approach

    Initialization:
        Get the dimensions of the matrix m x n.
        Prepare an output array of size m * n to store the traversal.
        Start from the top-left cell (row = 0, col = 0).

    Traversal Rule:
        For each step, add the current element to the result.
        The direction of movement depends on the sum of indices (row + col):
        Even sum → move up-right (row--, col++).
        Odd sum → move down-left (row++, col--).

    Boundary Conditions:

        While moving up-right:
            If we are at the last column, move down (row++).
            Else if we are at the first row, move right (col++).

        While moving down-left:
            If we are at the last row, move right (col++).
            Else if we are at the first column, move down (row++).

    Repeat until all m * n elements are filled in the result array.

    Return the result array containing elements in diagonal order
  */
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int m = mat.length, n = mat[0].length;
        int[] sol = new int [m*n];
        int row = 0, col = 0;

        for (int i=0; i<m*n; i++){
            sol[i] = mat[row][col];

            if ((row+col)%2 == 0){
                if (col == n-1) row++;
                else if (row == 0) col++;
                else { row--; col++;}
            }
            else{
                if (row == m-1) col++;
                else if (col == 0) row++;
                else {row++; col--;}
            }
        }
        return sol;
    }
}
