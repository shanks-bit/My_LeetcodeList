//leetcode => https://leetcode.com/problems/add-one-row-to-tree/description/

//bfs
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        boolean rowAdded = false;
        while (!queue.isEmpty()) {
            int n = queue.size();
            level++;
            while (n-- > 0) {
                TreeNode curr = queue.poll();
                TreeNode tempL = curr.left;
                TreeNode tempR = curr.right;
                if (level == depth - 1) {
                    curr.left = new TreeNode(val);
                    curr.right = new TreeNode(val);
                    curr.left.left = tempL;
                    curr.right.right = tempR;
                    rowAdded = true;
                }
                if (tempL != null)
                    queue.add(tempL);
                if (tempR != null)
                    queue.add(tempR);
            }
            if (rowAdded)
                break;
        }
        return root;
    }
}

//dfs
// Definition for a binary tree node.

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;


    TreeNode() {}


    TreeNode(int val) { this.val = val; }


    TreeNode(int val, TreeNode left, TreeNode right) {

        this.val = val;

        this.left = left;

        this.right = right;

    }

}


class Solution {

    // Instance variables to store the value to be added and the target depth

    private int value;

    private int targetDepth;


    // Main method to add a new row to the tree

    public TreeNode addOneRow(TreeNode root, int value, int depth) {

        // Handling the special case where the new row is to be added as the new root

        if (depth == 1) {

            return new TreeNode(value, root, null);

        }

        // Initialize the instance variables

        this.value = value;

        this.targetDepth = depth;

        // Start the depth-first search (DFS) from the root

        depthFirstSearch(root, 1);

        return root;

    }


    // Helper method to perform depth-first search

    private void depthFirstSearch(TreeNode node, int currentDepth) {

        // If the node is null, there is nothing to do; return immediately

        if (node == null) {

            return;

        }

        // Check if we reached the parent level of the target depth

        if (currentDepth == targetDepth - 1) {

            // Create new nodes with the given value and make them children of the current node

            TreeNode leftChild = new TreeNode(value, node.left, null);

            TreeNode rightChild = new TreeNode(value, null, node.right);

            // Update the current node's children to the newly created nodes

            node.left = leftChild;

            node.right = rightChild;

            // No need to traverse further as we have added the row at the target depth

            return;

        }

        // Recursively search the left and right subtrees, increasing the depth by 1

        depthFirstSearch(node.left, currentDepth + 1);

        depthFirstSearch(node.right, currentDepth + 1);

    }

}
