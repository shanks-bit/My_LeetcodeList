//leetcode => https://leetcode.com/problems/k-radius-subarray-averages/description/
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        if (k == 0) {
            // If k is 0, return the original array
            return nums.clone();
        }

        int[] result = new int[n];
        // Fill the result array with -1 initially
        Arrays.fill(result, -1);

        if (n < 2 * k + 1) {
            // If the array size is less than the required window size, return the result filled 
            //with -1
            return result;
        }

        long windowSum = 0;
        int left = 0;
        int right = 2 * k;
        int i = k;

        // Initialize the first window sum
        for (int j = left; j <= right; j++) {
            windowSum += nums[j];
        }

        result[i] = (int) (windowSum / (2 * k + 1));

        i++;
        right++; // Shift the window

        while (right < n) {
            int outOfWindow = nums[left];
            int cameToWindow = nums[right];

            windowSum = windowSum - outOfWindow + cameToWindow;

            result[i] = (int) (windowSum / (2 * k + 1));
            i++;
            left++;
            right++;
        }

        return result;
    }
}
