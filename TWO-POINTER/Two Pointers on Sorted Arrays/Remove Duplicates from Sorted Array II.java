// leetcode -> https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            int count = 1;

            // Count the occurrences of the current number
            while (r + 1 < nums.length && nums[r] == (nums[r + 1])) {
                r++;
                count++;
            }

            // Keep at most two occurrences of the current number
            for (int i = 0; i < Math.min(2, count); i++) {
                nums[l] = nums[r];
                l++;
            }

            r++;
        }

        return l;
    }
}
