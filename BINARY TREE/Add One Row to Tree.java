//bfs
//leetcode => https://leetcode.com/problems/add-one-row-to-tree/description/

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
