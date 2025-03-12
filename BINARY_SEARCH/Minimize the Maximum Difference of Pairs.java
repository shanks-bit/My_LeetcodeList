//Binary Search + Greedy (This is the same Qn of pattern "Applying binary search on answer" (Time Compplexity - O(m * log(n)) where m = max diff in pair
//How to identify -> Notice the keywords - "min max"
//Whenever we see in Question to Find Min(Max) or Max(Min) we will try to use Binary search on the result

//leetcode => https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/

class Solution {
    private int n;

    private boolean isValid(int[] nums, int mid, int p) {
        int i = 0, pairs = 0;

        while (i < n - 1) {
            if (nums[i + 1] - nums[i] <= mid) {
                pairs++;
                i += 2;
            } else {
                i++;
            }
        }
        return pairs >= p;
    }
    public int minimizeMax(int[] nums, int p) {
         n = nums.length;
        Arrays.sort(nums);

        int left = 0, right = nums[n - 1] - nums[0];
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(nums, mid, p)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
