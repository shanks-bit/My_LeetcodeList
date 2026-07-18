// https://leetcode.com/problems/binary-tree-maximum-path-sum/editorial/

class Solution {
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private int maxSum;

    // post order traversal of subtree rooted at `root`
    private int gainFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);

        // add the path sum from right subtree. 0 if negative
        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        maxSum = Math.max(maxSum, gainFromLeft + gainFromRight + root.val);

        // return the max sum for a path starting at the root of subtree
        return Math.max(gainFromLeft + root.val, gainFromRight + root.val);
    }
}
/*
Step by Step Algorithm
1. Initialize res to root.val

res = root.val

    res stores the maximum path sum found so far.
    It is initially set to the root node’s value, ensuring that at least one node is considered in the sum.

2. Define a Helper Function dfs(node) for Depth-First Search

def dfs(node):

    This function performs a postorder traversal (left → right → root).
    It calculates the maximum path sum for each subtree and updates res with the highest possible value.

3. Use nonlocal to Access res Inside dfs

nonlocal res

    Since res is defined outside dfs, using nonlocal allows modification inside the function.

4. Base Case: Return 0 for None Nodes

if not node:
    return 0

    If node is None, return 0 because an empty subtree contributes nothing to the sum.

5. Compute Maximum Path Sum for Left and Right Subtrees

left_sum = max(0, dfs(node.left))
right_sum = max(0, dfs(node.right))

    Recursively compute the maximum path sum for left and right subtrees.
    Use max(0, dfs(node.left)) to ignore negative sums (if a subtree has a negative sum, it’s better not to include it).

6. Update the Global Maximum Path Sum

res = max(res, left_sum + right_sum + node.val)

    This considers the case where the current node acts as a bridge (splitting into left and right).
    The total sum in this case is: left_sum + right_sum + node.val
    res is updated to store the highest sum encountered so far.

7. Return the Maximum Path Sum Without Splitting

return max(left_sum, right_sum) + node.val

    A valid path must be a single path (it cannot split into left and right at different levels).
    The return value ensures we choose either the left or the right subtree (whichever has the larger sum), plus the current node’s value.

8. Start DFS from the Root and Return res

dfs(root)
return res

    Calls dfs(root), which calculates the maximum path sum recursively.
    The final result is stored in res, which is returned.

*/
