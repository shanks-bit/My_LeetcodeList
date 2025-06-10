// leetcode -> https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/description/
class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int[] sol = new int[nums.length];
        int index = 0;

        while (index != nums.length) {
            sol[index ++] = nums[left++];

            if (left <= right) {
                sol[index ++] = nums[right--];
               
            }
        }
        return sol;
    }
}
