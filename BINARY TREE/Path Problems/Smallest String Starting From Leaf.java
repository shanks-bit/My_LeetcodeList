// https://leetcode.com/problems/smallest-string-starting-from-leaf

//dfs
class Solution {
    String smallestString = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return smallestString;
    }

    // Helper function to find the lexicographically smallest string
    void dfs(TreeNode root, String currentString) {

        // If the current node is NULL, return
        if (root == null) {
            return;
        }

        // Construct the current string by appending 
        // the character corresponding to the node's value
        currentString = (char) (root.val + 'a') + currentString;

        // If the current node is a leaf node
        if (root.left == null && root.right == null) {

            // If the current string is smaller than the result 
            // or if the result is empty
            if (smallestString.isEmpty() || smallestString.compareTo(currentString) > 0) {
                smallestString = currentString;
            }
        }

        // Recursively traverse the left subtree
        if (root.left != null) {
            dfs(root.left, currentString);
        } 

        // Recursively traverse the right subtree
        if (root.right != null) {
            dfs(root.right, currentString);
        }

    }
}

// bfs
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        String smallestString = "";
        Queue<Pair<TreeNode, String>> nodeQueue = new LinkedList<>();

        // Add root node to queue along with its value converted to a character
        nodeQueue.add(new Pair<>(root, String.valueOf((char)(root.val + 'a'))));

        // Perform BFS traversal until queue is empty
        while (!nodeQueue.isEmpty()) {

            // Pop the leftmost node and its corresponding string from queue
            Pair<TreeNode, String> pair = nodeQueue.poll();
            TreeNode node = pair.getKey();
            String currentString = pair.getValue();
    
            // If current node is a leaf node
            if (node.left == null && node.right == null) {
            
                // Update smallest_string if it's empty or current string is smaller
                if (smallestString.isEmpty()) {
                    smallestString = currentString;
                } else {
                    smallestString = currentString.compareTo(smallestString) < 0 ? currentString : smallestString;
                }
            }

            // If current node has a left child, append it to queue
            if (node.left != null) {
                nodeQueue.add(new Pair<>(node.left, (char)(node.left.val + 'a') + currentString));
            }

            // If current node has a right child, append it to queue
            if (node.right != null) {
                nodeQueue.add(new Pair<>(node.right, (char)(node.right.val + 'a') + currentString));
            }
        }

        return smallestString;
    }
}
