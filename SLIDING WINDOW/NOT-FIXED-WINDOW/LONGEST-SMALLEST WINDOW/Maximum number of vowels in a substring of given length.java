// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
class Solution {
    public int maxVowels(String s, int k) {
        int left = 0, res = 0, total = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (int right = 0; right < s.length(); right++) {
            // Add to count if the current character is a vowel
            if (vowels.contains(s.charAt(right))) {
                total++;
            }

            // If the window size exceeds k, adjust the sliding window
            if (right - left + 1 > k) {
                if (vowels.contains(s.charAt(left))) {
                    total--;
                }
                left++;
            }

            // Update the result with the maximum vowels in the window
            res = Math.max(res, total);
        }

        return res;
        
    }
}
