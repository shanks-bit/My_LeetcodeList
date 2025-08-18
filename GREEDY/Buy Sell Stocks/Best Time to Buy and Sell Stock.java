// leetcode -> https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1, Maxy = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                Maxy = Math.max(Maxy, prices[right] - prices[left]);
            }
            else {
                left = right;
            }
            right++;
        }
        return Maxy;
    }
}
