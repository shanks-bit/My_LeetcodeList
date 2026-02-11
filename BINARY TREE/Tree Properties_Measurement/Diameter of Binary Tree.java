// https://leetcode.com/problems/diameter-of-binary-tree/description/

//recursion 
class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }
    private int longestPath(TreeNode node){
        if(node == null) return -1;
        // recursively find the longest path in
        // both left child and right child
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        // update the diameter if left_path plus right_path is larger
        diameter = Math.max(diameter, leftPath + rightPath + 2);

        // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        return Math.max(leftPath, rightPath) + 1;
    }
}

//iteration
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);
        TreeNode deepestNode = root;
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        while (!bfs.isEmpty()) {
            int count = bfs.size();
            while (count-- > 0) {
                TreeNode node = bfs.remove();
                deepestNode = node;
                if (node.left != null) {
                    bfs.add(node.left);
                    parents.put(node.left, node);
                }
                if (node.right != null) {
                    bfs.add(node.right);
                    parents.put(node.right, node);
                }
            }
        }
        
        Set<TreeNode> visited = new HashSet<>();
        int diameter = -1;
        bfs.add(deepestNode);
        visited.add(deepestNode);
        while (!bfs.isEmpty()) {
            int count = bfs.size();
            while (count-- > 0) {
                TreeNode node = bfs.remove();
                for (TreeNode next : new TreeNode[] {node.left, node.right, parents.get(node)}) {
                    if (next != null && visited.add(next)) {
                        bfs.add(next);
                    }
                }
            }
            diameter++;
        }
        return diameter;
    }
}
