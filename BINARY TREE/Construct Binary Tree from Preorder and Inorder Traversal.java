// leetcode => https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int[] idx = {0}; // Use an array to pass by reference
        return solve(preorder, inorder, 0, n - 1, idx);
    }

    private TreeNode solve(int[] preorder, int[] inorder, int start, int end, int[] idx) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[idx[0]];
        int i = start;

        // Find the index of root value in the inorder array
        for (; i <= end; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
        }

        idx[0]++;
        TreeNode root = new TreeNode(rootVal);
        root.left = solve(preorder, inorder, start, i - 1, idx);
        root.right = solve(preorder, inorder, i + 1, end, idx);

        return root;
    }
}
/*
 Why idx[0]?

    You need a global counter to remember which element of preorder to use next during recursion.

    Java is pass-by-value, so primitive int would not update across recursive calls.

    By using int[] idx = {0}, you're passing a reference to an array, so changes to idx[0] inside the recursive solve function are reflected across all calls.

What idx[0]++ Does:
This means:

    Pick the current root value from preorder using idx[0]

    Then increment it so the next call picks the next root
*/     
