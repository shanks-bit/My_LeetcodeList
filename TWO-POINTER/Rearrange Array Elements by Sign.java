// leetcode -> https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posIndx = 0, negIndx = 1;
        int[] sol = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            if (nums[i] < 0) {
                sol[negIndx] = nums[i];
                negIndx += 2;
            }
            else {
                sol[posIndx] = nums[i];
                posIndx += 2;
            }
        }
        return sol;
    }
}
