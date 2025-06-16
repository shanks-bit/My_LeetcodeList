// leetcode => https://leetcode.com/problems/sort-colors/submissions/1665457872/
class Solution {
    public void sortColors(int[] nums) {
        int i = 0, l = 0, r = nums.length-1;
        while (i<nums.length && i<=r) {
            if (nums[i] == 0) {
                int temp1 = nums[l];
                nums[l] = nums[i];
                nums[i] = temp1;
                l++;
                i++;
            }
            else if (nums[i] == 2) {
                int temp2 = nums[r];
                nums[r] = nums[i];
                nums[i] = temp2;
                r--;
            }
            else {
                //nums[i] == 1
                i++;
            }
        }
    }
}
