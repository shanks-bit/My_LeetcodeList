//leetcode => https://leetcode.com/problems/binary-tree-right-side-view/description/
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

//dfs
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // Modified pre-order traversal: root -> right -> left
    private void preOrder(TreeNode root, int level, List<Integer> result) {
        if (root == null)
            return;
        
        if (result.size() < level)
            result.add(root.val);
        
        preOrder(root.right, level + 1, result);
        preOrder(root.left, level + 1, result);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, 1, result);
        return result;
    }
}
