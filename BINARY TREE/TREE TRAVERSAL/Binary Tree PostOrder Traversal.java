// https://leetcode.com/problems/binary-tree-postorder-traversal/description/
// postorder => left, right, root

// recursion
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;        
    }

    private void postorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }
}

// iterative
public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();

    if (root == null) return result;

    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.addFirst(node.val);   // reverse preorder
        if (node.left != null) stack.push(node.left);
        if (node.right != null) stack.push(node.right);
    }
    return result;
}
//Reverse of (Root → Right → Left) = Left → Right → Root
