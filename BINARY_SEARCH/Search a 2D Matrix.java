//leetcode => https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int b = matrix[0].length;
        int a = matrix.length;
        int left = 0, right = (a*b)-1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int row = mid/b;
            int col = mid%b;

            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}
