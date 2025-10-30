// leetcode -> https://leetcode.com/problems/maximum-subarray-with-equal-products/description/
class Solution {
    public int maxLength(int[] nums) {
        int len = nums.length;
        int maxLen = 0;

        for (int i=0; i<len; i++){
            int gcdCur = nums[i];
            int lcmCur = nums[i];
            int prdCur = nums[i];

            for (int j=i+1; j<len; j++){
                gcdCur = gcd(gcdCur, nums[j]);
                lcmCur = lcm(lcmCur, nums[j]);
                prdCur *= nums[j];

                if (prdCur == gcdCur * lcmCur){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    private int lcm(int a, int b){
        return (a * b) / (gcd(a, b));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
