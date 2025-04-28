//top-down
//leetcode => https://leetcode.com/problems/path-sum/description/

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    private boolean pathSum(TreeNode root, int sum, int curr) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (curr + root.val) == sum; //true or false
        }

        boolean l = pathSum(root.left, sum, curr + root.val);
        boolean r = pathSum(root.right, sum, curr + root.val);

        return l || r; //true or false if this condition happppens true will be the result
    }
}
/*
Now, l || r means:

    l is checking: Is there a valid path in the left subtree? (true or false)

    r is checking: Is there a valid path in the right subtree? (true or false)

Finally, l || r returns:

    true if either l is true or r is true.

    false if both l and r are false.

Why do we use return l || r?

Because you want to find at least one path from root to any leaf where the sum of node values equals the target sum.

    If any one path (left or right) satisfies the condition (curr + root.val == sum at the leaf), you want to return true.

    Otherwise, return false.

That's why you combine the left and right recursive results using || (logical OR).
*/
