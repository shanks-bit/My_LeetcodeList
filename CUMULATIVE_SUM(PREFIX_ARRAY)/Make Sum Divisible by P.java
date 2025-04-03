//leetcode => https://leetcode.com/problems/make-sum-divisible-by-p/description/
class Solution {
    public int minSubarray(int[] nums, int p) {
        // Initialize remainder to accumulate the sum of the array elements modulo p
        int remainder = 0;
        for (int num : nums) {
            remainder = (remainder + num) % p;
        }
        
        // If the total sum is a multiple of p, no subarray needs to be removed
        if (remainder == 0) {
            return 0;
        }
        // Create a hashmap to store the most recent index where a certain modulo value was seen  => map -> (sum % p, index)
        Map<Integer, Integer> lastIndex = new HashMap<>();
        lastIndex.put(0, -1); // Initialize with the value 0 at index -1
        int n = nums.length;

        // Set the initial smallest subarray length to the array's length
        int smallestLength = n;
        int currentSumModP = 0; // This will keep the running sum modulo p


        for (int i = 0; i < n; ++i) {
            currentSumModP = (currentSumModP + nums[i]) % p;

            // Calculate the target modulo value that would achieve our remainder if removed
            int target = (currentSumModP - remainder + p) % p;

            // If the target already exists in the hashmap, calculate the length of the subarray that could be removed
            if (lastIndex.containsKey(target)) {
                smallestLength = Math.min(smallestLength, i - lastIndex.get(target));
            }

            // Update the hashmap with the current modulo value and its index
            lastIndex.put(currentSumModP, i);
        }

        // If the smallestLength was not updated, return -1 to signify no valid subarray exists
        return smallestLength == n ? -1 : smallestLength;
    }
}
