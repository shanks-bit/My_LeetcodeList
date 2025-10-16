//leetcode -> https://leetcode.com/problems/count-special-triplets/description/
class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int mod = 1_000_000_007;
        Map<Integer, Integer> rightFreq = new HashMap<>();
        Map<Integer, Integer> leftFreq = new HashMap<>();

        // Step 1: Count frequency of all numbers (initialize rightFreq)
        for (int num : nums) {
            rightFreq.put(num, rightFreq.getOrDefault(num, 0) + 1);
        }

        long count = 0;

        // Step 2: Iterate through each element as the "middle" element (j)
        for (int j = 0; j < n; j++) {
            int val = nums[j];

            // Remove current element from rightFreq since we are now processing it
            rightFreq.put(val, rightFreq.get(val) - 1);

            int doubleVal = val * 2;

            // Count how many times 2*val appears on the left and right
            int countLeft = leftFreq.getOrDefault(doubleVal, 0);
            int countRight = rightFreq.getOrDefault(doubleVal, 0);

            // Add combinations of such pairs to the total count
            count = (count + (long) countLeft * countRight) % mod;

            // Now mark this element as part of the left side
            leftFreq.put(val, leftFreq.getOrDefault(val, 0) + 1);
        }

        return (int) count;
    }
}
