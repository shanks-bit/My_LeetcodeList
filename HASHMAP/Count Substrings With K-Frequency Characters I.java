// leetcode -> https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/submissions/1822222832/

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
/*
res = total number of possible substrings in s.
The formula (n + 1) * n / 2 gives the number of substrings in a string of length n.
(e.g., for "abc" → 6 substrings: "a", "b", "c", "ab", "bc", "abc").

res was initialized with total substrings.
Now, at each step, we subtract the number of substrings ending at index j that are valid 
(i.e., have a character with frequency ≥ k).
Those substrings start anywhere from index i to j, so we subtract j - i + 1.
*/
