// leetcode => https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/
class Solution {
    public int appendCharacters(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int i = 0, j = 0;

        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }

        return (tLen - j);
    }
}
