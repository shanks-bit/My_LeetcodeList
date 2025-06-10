// leetcode -> https://leetcode.com/problems/rotate-array/description/
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        revr(nums, 0, n - 1);
        revr(nums, 0, k - 1);
        revr(nums, k, n - 1);
    }
    private void revr(int[] nums, int l, int r){
        while (l < r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
