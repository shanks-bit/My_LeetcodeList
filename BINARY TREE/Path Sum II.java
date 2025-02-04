//top-down approach backtrack
//leetcode => https://leetcode.com/problems/path-sum-ii/
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        collectPaths(root, targetSum, temp, result);
        return result;
    }

    private void collectPaths(TreeNode root, int curr, List<Integer> temp, List<List<Integer>> result) {
        if (root == null)
            return;
        
        temp.add(root.val);

        // Found a leaf node, if targetSum becomes zero after adding leaf node value then a path is found, add the path to the result list
        if (root.left == null && root.right == null && root.val == curr) {
            result.add(new ArrayList<>(temp));
        }

        // Traverse left part(reduce targetSum by node value), and backtrack (by deleting node from list) after completing the left subtree
        collectPaths(root.left, curr - root.val, temp, result);

        // Traverse right part and backtrack
        collectPaths(root.right, curr - root.val, temp, result);

        temp.remove(temp.size() - 1);
    }
}
