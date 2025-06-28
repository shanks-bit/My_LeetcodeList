// leetcode => https://leetcode.com/problems/binary-subarrays-with-sum/description/
//Sliding Window
class Solution {
    // Helper function to count the number of subarrays with sum at most the given goal
    private int slidingWindowAtMost(int[] nums, int goal) {
        int start = 0, currentSum = 0, totalCount = 0;

        // Iterate through the array using a sliding window approach
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            // Adjust the window by moving the start pointer to the right
            // until the sum becomes less than or equal to the goal
            while (start <= end && currentSum > goal) {
                currentSum -= nums[start++];
            }

            // Update the total count by adding the length of the current subarray
            totalCount += end - start + 1;
        }
        return totalCount;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }
}

//Sliding Window in one pass
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixZeros = 0;
        int windowSum = 0;
        int count = 0;
        
        int i = 0, j = 0;
        
        while (j < nums.length) {
            windowSum += nums[j];
            
            while (i < j && (nums[i] == 0 || windowSum > goal)) {
                if (nums[i] == 1) {
                    prefixZeros = 0;
                } else {
                    prefixZeros += 1;
                }
                
                windowSum -= nums[i];
                i++;
            }
            
            if (windowSum == goal) {
                count += 1 + prefixZeros;
            }
            j++;
        }
        
        return count; 
    }
}
