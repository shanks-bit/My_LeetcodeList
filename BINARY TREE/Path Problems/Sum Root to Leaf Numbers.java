// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

class Solution {
    public int sumNumbers(TreeNode root) {
        return find(root, 0);
    }

    public int find(TreeNode root, int curr) {
        if (root == null)
            return 0;

        curr = curr * 10 + root.val;

        if (root.left == null && root.right == null) {
            return curr;
        }

        int leftNum = find(root.left, curr);
        int rightNum = find(root.right, curr);

        return leftNum + rightNum;
    }

}
