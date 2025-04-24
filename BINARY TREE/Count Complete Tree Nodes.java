//leetcode => https://leetcode.com/problems/count-complete-tree-nodes/
  
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
// Class containing a solution method to count the nodes of a binary tree.
class Solution { 

    // Method that returns the count of nodes in a complete binary tree.
    public int countNodes(TreeNode root) {
        // Base case: if the tree is empty, return 0
        if (root == null) {
            return 0;
        }


        // Compute the depth of the left subtree
        int leftDepth = computeDepth(root.left);

        // Compute the depth of the right subtree
        int rightDepth = computeDepth(root.right);


        // Check if the left and right depths are equal
        if (leftDepth == rightDepth) {
            // If equal, the left subtree is complete and we add its node count to the recursive count of the right subtree
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // If not equal, the right subtree is complete and we add its node count to the recursive count of the left subtree
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    // Helper method that computes the depth of the tree (distance from the root to the deepest leaf node)
    private int computeDepth(TreeNode root) {
        int depth = 0;

        // Loop to travel down the left edge of the tree until a null is encountered
        for (; root != null; root = root.left) {
            depth++;
        }
        // Return the depth of the tree
        return depth;

    }

}
