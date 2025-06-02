// leetcode => https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right=0; right<s.length(); right++) {
            char curr = s.charAt(right);

            while (charSet.contains(curr)) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(curr);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
