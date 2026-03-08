// https://leetcode.com/problems/path-sum-iii/description/

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
    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        List<Integer> temp = new ArrayList<>();
        collectPaths(root, targetSum, temp, count);
        return count;
    }

     private void collectPaths(TreeNode root, int curr, List<Integer> temp, int count) {
        if (root == null)
            return;
        
        temp.add(root.val);

        // Found a leaf node, if targetSum becomes zero after adding leaf node value then a path is found, add the path to the result list
        if (root.left == null && root.right == null && root.val == curr) {
            count += 1;
        }

        // Traverse left part(reduce targetSum by node value), and backtrack (by deleting node from list) after completing the left subtree
        collectPaths(root.left, curr - root.val, temp, count);

        // Traverse right part and backtrack
        collectPaths(root.right, curr - root.val, temp, count);

        temp.remove(temp.size() - 1);
    }
}
