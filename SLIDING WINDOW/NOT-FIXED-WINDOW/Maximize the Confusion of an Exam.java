// leetcode => https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int result = 0;

        // First pass: flipping 'F' to 'T'
        int i = 0, j = 0, countF = 0;
        while (j < n) {
            if (answerKey.charAt(j) == 'F') {
                countF++;
            }

            while (countF > k) {
                if (answerKey.charAt(i) == 'F') {
                    countF--;
                }
                i++;
            }

            result = Math.max(result, j - i + 1);
            j++;
        }

        // Second pass: flipping 'T' to 'F'
        i = 0;
        j = 0;
        int countT = 0;
        while (j < n) {
            if (answerKey.charAt(j) == 'T') {
                countT++;
            }

            while (countT > k) {
                if (answerKey.charAt(i) == 'T') {
                    countT--;
                }
                i++;
            }

            result = Math.max(result, j - i + 1);
            j++;
        }

        return result;
    }
}
