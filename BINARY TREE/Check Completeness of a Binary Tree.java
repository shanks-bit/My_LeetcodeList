//leetcode => https://leetcode.com/problems/check-completeness-of-a-binary-tree/
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
    public boolean isCompleteTree(TreeNode root) {
        // Using BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean past = false; // Have we seen a NULL node in the past?
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                past = true;
            }
            else {
                if (past == true) {
                    return false; // If a non-null node comes after a null node, it's not 
                                //complete
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        
        return true;

    }
}
