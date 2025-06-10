// leetcode -> https://leetcode.com/problems/bag-of-tokens/description/
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int left = 0, right = tokens.length - 1, score = 0, res = 0;
        Arrays.sort(tokens);

        while (left <= right) {
            if (tokens[left] <= power) {
                power = power - tokens[left];
                score++;
                left++;
                res = Math.max(res, score);
            }

            else if (score > 0) {
                power = power + tokens[right];
                score--;
                right--;
            }
            else {
                break;
            }
        }
        return res;
    }
}
