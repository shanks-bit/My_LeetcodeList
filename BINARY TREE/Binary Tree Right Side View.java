//leetcode => https://leetcode.com/problems/binary-tree-right-side-view/description/
//BFS
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        if (root == null) return sol;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            //queue add from |_|_|<--
            sol.add(q.peek().val);
            int size = q.size();

            while (size > 0) {
                //queue poll from -->|_|_|
                TreeNode node = q.poll();
                if (node.right != null) q.offer(node.right);
                if (node.left != null) q.offer(node.left);
                size--;
            }
        }
        return sol;
    }
}
