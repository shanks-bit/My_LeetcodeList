// https://leetcode.com/problems/diameter-of-binary-tree/description/

//recursion 
class Solution {
    private int max;
    
    public int diameterOfBinaryTree(TreeNode root) {
        deepestPath(root);
        return max;
    }
    
    private int deepestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = deepestPath(node.left);
        int right = deepestPath(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
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
