// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

// bfs
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean even = true;
        if (root == null)
            return ans;
        
        q.offer(root);

        while (!q.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int n = q.size();

            for (int i=0; i<n; i++){
                TreeNode front = q.poll();
                row.add(front.val);
                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);
            }
            if (even == true){
                ans.add(row);
                even = false;
            }
            else {
                Collections.reverse(row);
                ans.add(row);
                even = true;
            }
            
        }
        return ans;
    }
}

// dfs
class Solution {
    protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        } else {
            if (level % 2 == 0) results.get(level).add(node.val);
            else results.get(level).add(0, node.val);
        }

        if (node.left != null) DFS(node.left, level + 1, results);
        if (node.right != null) DFS(node.right, level + 1, results);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
    }
}
