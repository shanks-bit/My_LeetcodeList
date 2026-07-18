// https://leetcode.com/problems/spiral-matrix-iv/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int[] row: res){
            Arrays.fill(row, -1); 
        }

        int topRow = 0, bottomRow = m - 1, leftColumn = 0, rightColumn = n - 1;
        while (head != null) {
        
            for (int col = leftColumn; col <= rightColumn && head != null; col++) {
                res[topRow][col] = head.val;
                head = head.next;
            }
            //Update Boundaries: After filling each part of the matrix, adjust the boundaries to move inward.
            topRow++;

        
            for (int row = topRow; row <= bottomRow && head != null; row++) {
                res[row][rightColumn] = head.val;
                head = head.next;
            }
            rightColumn--;

 
            for (int col = rightColumn; col >= leftColumn && head != null; col--) {
                res[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;

       
            for (int row = bottomRow; row >= topRow && head != null; row--) {
                res[row][leftColumn] = head.val;
                head = head.next;
            }
            leftColumn++;
        }

        return res;
    }
}
