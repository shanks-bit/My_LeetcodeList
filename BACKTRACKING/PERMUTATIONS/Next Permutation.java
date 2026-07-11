https://leetcode.com/problems/next-permutation/description/

/*
Step-by-Step Algorithm

    Start from the second last element and move left until finding the first element that is smaller than its next element.
        This element is called the pivot.

    If a pivot exists:
        Traverse from the end of the array.
        Find the first element greater than the pivot.
        Swap these two elements.

    Reverse the subarray after the pivot.
        Since this suffix is in descending order, reversing it makes it ascending, producing the smallest possible suffix.

    If no pivot exists, the array is already the largest permutation.
        Reverse the entire array to obtain the smallest permutation.

Important Observations

    Everything to the right of the pivot is always in descending order.
    Searching from the end guarantees that we swap with the smallest element greater than the pivot.
    Reversing the suffix produces the immediate next permutation without sorting.

*/
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        //find pivot element
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            int j = n - 1;
            //Find the first element greater than the pivot
            while (nums[j] <= nums[i]) j--;

            //swap them
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
