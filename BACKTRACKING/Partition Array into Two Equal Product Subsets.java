// leetcode -> https://leetcode.com/problems/partition-array-into-two-equal-product-subsets/description/

class Solution {
    boolean[] selected; // Marks which elements go into group A

    public boolean checkEqualPartitions(int[] nums, long target) {
        selected = new boolean[nums.length];
        return canPartition(nums, 0, 1, target, 0);     
    }

    private boolean canPartition(int[] nums, int index, long productA, long target, int countA) {
        int n = nums.length;

        // Base case: processed all elements
        if (index == n) {
            // Both groups must be non-empty
            if (countA == 0 || countA == n) return false;

            // Compute product of remaining (group B)
            long productB = 1;
            for (int i = 0; i < n; i++) {
                if (!selected[i]) {
                    productB *= nums[i];
                }
            }

            // Check if both groups match the target
            return (productA == target && productB == target);
        }

        // Option 1: include nums[index] in group A
        selected[index] = true;
        if (canPartition(nums, index + 1, productA * nums[index], target, countA + 1)) {
            return true;
        }

        // Option 2: exclude nums[index] (goes to group B)
        selected[index] = false;
        if (canPartition(nums, index + 1, productA, target, countA)) {
            return true;
        }

        return false;
    }
}
