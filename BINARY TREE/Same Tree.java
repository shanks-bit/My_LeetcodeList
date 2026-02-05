// https://leetcode.com/problems/same-tree/editorial/
// recursion
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}

// iteration
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);
    
        while(!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            
            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            
            queue.add(p.left);
            queue.add(q.left);
            queue.add(p.right);
            queue.add(q.right);
        }
        return true;
    }
}
