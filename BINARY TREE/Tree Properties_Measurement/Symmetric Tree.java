//https://leetcode.com/problems/symmetric-tree/submissions/1529494026/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isTreeSymmetric(root.left, root.right);
    }

    public boolean isTreeSymmetric(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot == null && rightRoot == null)
            return true;

        if((leftRoot == null && rightRoot != null)  || 
            (leftRoot != null && rightRoot == null))
            return false;

        if(leftRoot.val != rightRoot.val)
            return false;

        return isTreeSymmetric(leftRoot.left, rightRoot.right) &&
             isTreeSymmetric(leftRoot.right, rightRoot.left);
    }
}
