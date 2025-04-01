//leetcode => https://leetcode.com/problems/continuous-subarray-sum/submissions/1592751518/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // HashMap to store the remainder of the sum encountered so far and its index
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();

        // To handle the case when subarray will be divisible by k
        //map (remainder, lengthOfSubArray)
        remainderIndexMap.put(0, -1);

        // Initialize the sum to 0
        int sum = 0;     

        // Iterate through the array
        for (int i = 0; i < nums.length; ++i) {

            // Add current number to the sum
            sum += nums[i];

            // Calculate the remainder of the sum w.r.t k
            int remainder = sum % k;

            // If the remainder is already in the map and the subarray is of size at least 2
            if (remainderIndexMap.containsKey(remainder) && i - remainderIndexMap.get(remainder) >= 2) {

                // We found a subarray with a sum that is a multiple of k
                return true;
            }
            // Put the remainder and index in the map if not already present
            remainderIndexMap.putIfAbsent(remainder, i);
        }
        // If we reach here, no valid subarray was found
        return false;
    }
}
