// leetcode -> https://leetcode.com/problems/subarray-sum-equals-k/description/
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(0,1);

        int sol = 0, total = 0;

        for (int i=0; i<nums.length; i++) {
            total += nums[i];

            if (counter.containsKey(total-k)) {
                sol += counter.get(total-k);
            }

            counter.put(total, counter.getOrDefault(total,0) + 1);
        }
        return sol;
    }
}
