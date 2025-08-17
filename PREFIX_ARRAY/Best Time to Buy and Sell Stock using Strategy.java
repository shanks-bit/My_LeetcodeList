// leetcode -> https://leetcode.com/problems/best-time-to-buy-and-sell-stock-using-strategy/
class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        
         int n = prices.length;
        int half = k / 2;

        // Step 1: Compute base profit
        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        // Step 2: Prefix sums
        long[] prefixSP = new long[n + 1]; // prefix of strategy[i]*prices[i]
        long[] prefixP = new long[n + 1];  // prefix of prices[i]

        for (int i = 0; i < n; i++) {
            prefixSP[i + 1] = prefixSP[i] + (long) strategy[i] * prices[i];
            prefixP[i + 1] = prefixP[i] + prices[i];
        }

        // Step 3: Find best gain
        long bestGain = 0;
        for (int i = 0; i + k <= n; i++) {
            int mid = i + half;

            // First half contribution
            long part1 = -(prefixSP[mid] - prefixSP[i]);

            // Second half contribution
            long part2 = (prefixP[i + k] - prefixP[mid]) 
                       - (prefixSP[i + k] - prefixSP[mid]);

            long gain = part1 + part2;
            bestGain = Math.max(bestGain, gain);
        }

        return baseProfit + bestGain;
    }
}
/*
We need two things fast:

Base profit (we already compute in O(n)).

Gain of a window [i, i+k-1]:

First half:

change1=−∑(strategy[j]×prices[j])
change1=−∑(strategy[j]×prices[j])

Second half:

change2=∑(prices[j])−∑(strategy[j]×prices[j])
change2=∑(prices[j])−∑(strategy[j]×prices[j])

Total gain = change1 + change2

👉 That means we need prefix sums of strategy[i]*prices[i] and prefix sums of prices[i].
*/
