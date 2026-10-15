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
/*
because of the modulo property — if two prefix sums have the same remainder mod k, their difference (the subarray sum between them) is divisible by k.

Why that works (brief):

    Let prefixSum[i] = sum of nums[0..i].
    If prefixSum[j] % k == prefixSum[i] % k (with j > i) then (prefixSum[j] - prefixSum[i]) % k == 0, so the sum of nums[i+1..j] is a multiple of k.
    So by storing remainders of prefix sums and their earliest index, when we see the same remainder again we know there's a subarray whose sum is divisible by k.

*/
