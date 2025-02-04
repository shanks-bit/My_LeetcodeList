//top-down
//leetcode => https://leetcode.com/problems/path-sum/description/

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    private boolean pathSum(TreeNode root, int sum, int curr) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (curr + root.val) == sum; //true or false
        }

        boolean l = pathSum(root.left, sum, curr + root.val);
        boolean r = pathSum(root.right, sum, curr + root.val);

        return l || r; //true or false if this condition happppens true will be the result
    }
}
