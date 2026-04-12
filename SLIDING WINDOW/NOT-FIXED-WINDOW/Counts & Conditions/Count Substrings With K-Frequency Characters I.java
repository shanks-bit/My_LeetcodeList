// https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/submissions/1822222832/

class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length(), res = (n + 1) * n / 2;
        int[] count = new int[26];

        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            count[c - 'a']++;
            while (count[c - 'a'] >= k) {
                char leftChar = s.charAt(i);
                count[leftChar - 'a']--;
                i++;
            }
            res -= j - i + 1;
        }
        
        return res;
    }
}
