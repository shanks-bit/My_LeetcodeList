// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

// bfs
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int n = q.size();
            for (int i =0; i< n ; i++){
                TreeNode front = q.poll();
                row.add(front.val);
                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);
            }
            ans.add(row);
        }
        return ans;
    }
}

// dfs
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    void helper(TreeNode root, int level, List<List<Integer>> ans){
        if (root == null) return;
        //add new array if not present
        if (level == ans.size()){
            ans.add(new ArrayList<>());
        }
        //add curr val
        ans.get(level).add(root.val);

        helper(root.left, level + 1 , ans);
        helper(root.right, level+1 , ans);

    }
    
}
