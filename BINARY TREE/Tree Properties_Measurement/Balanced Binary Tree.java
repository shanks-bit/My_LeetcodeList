// https://leetcode.com/problems/balanced-binary-tree/editorial/

/* Top down is head recursion(pre-order traversal - DFS) where the recursive call comes first before the 
  evaluation/processing.Bottom up is tail recursion(post-order traversal- DFS) where the evaluation/processing
  comes first before handing over the remaining work to the next recursive call. This will maintain a running
  sum because the evaluation happens before the call.
*/
// top down
class Solution {
    // Recursively obtain the height of a tree. An empty tree has -1 height
    private int height(TreeNode root) {
        // An empty tree has height -1
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        // An empty tree satisfies the definition of a balanced tree
        if (root == null) {
            return true;
        }

        // Check if subtrees have height within 1. If they do, check if the
        // subtrees are balanced
        return (
            Math.abs(height(root.left) - height(root.right)) < 2 &&
            isBalanced(root.left) &&
            isBalanced(root.right)
        );
    }
}

//bottom up
// Utility class to store information from recursive calls
final class TreeInfo {
    public final int height;
    public final boolean balanced;

    public TreeInfo(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}

class Solution {
    // Return whether or not the tree at root is balanced while also storing
    // the tree's height in a reference variable.
    private TreeInfo isBalancedTreeHelper(TreeNode root) {
        // An empty tree is balanced and has height = -1
        if (root == null) {
            return new TreeInfo(-1, true);
        }

        // Check subtrees to see if they are balanced.
        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }

        // Use the height obtained from the recursive calls to
        // determine if the current node is also balanced.
        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
    }
}
  
