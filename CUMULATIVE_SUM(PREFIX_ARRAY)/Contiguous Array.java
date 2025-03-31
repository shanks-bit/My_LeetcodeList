//leetcode => https://leetcode.com/problems/contiguous-array/

class Solution {
//T.C : O(n)
//S.C : O(1)
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;

        HashMap<Integer, Integer> mp = new HashMap<>();
        int currSum = 0;
        int maxL = 0;
        
        //mp(cumulative_sum, index) => before o index sum is kept 0
        mp.put(0, -1);

        for (int i = 0; i < n; i++) {
            // 0 is replaced with -1 and 1 with 1 so sum could be zero 
            currSum += (nums[i] == 1) ? 1 : -1;

            if (mp.containsKey(currSum)) {
                maxL = Math.max(maxL, i - mp.get(currSum));
            } else
                mp.put(currSum, i);
        }
        //it is index
        return maxL;
    }
}
