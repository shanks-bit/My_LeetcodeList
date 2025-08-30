// leetcode => https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> st = new HashSet<>();
        int[] maxCount = new int[1]; // Using array to allow updates by reference
        solve(s, 0, st, 0, maxCount);
        return maxCount[0];
    }

    private void solve(String s, int idx, HashSet<String> st, int currCount, int[] maxCount) {
        // Pruning for slight improvement
        if(currCount + (s.length() - idx) <= maxCount[0]) {
            return;
        }

        if (idx == s.length()) {
            maxCount[0] = Math.max(maxCount[0], currCount);
            return;
        }

        for (int j = idx; j < s.length(); j++) {
            String sub = s.substring(idx, j + 1);
            if (!st.contains(sub)) {
                st.add(sub);                                  // do
                solve(s, j + 1, st, currCount + 1, maxCount); // explore
                st.remove(sub);                               // undo
            }
        }
    }
}
/*
Pruning explanantion ---
We check whether the current count of unique substrings, combined with the remaining characters in the string, 
can yield a higher count than what we have 
already found. If this total cannot exceed our maximum count, we return immediately, skipping unnecessary
calculations. This step significantly reduces the number
of recursive calls, especially for longer strings
*/
class Solution {

    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        return backtrack(s, 0, seen);
    }

    private int backtrack(String s, int start, Set<String> seen) {
        // Base case: If we reach the end of the string, return 0 (no more substrings to add)
        if (start == s.length()) return 0;

        int maxCount = 0;

        // Try every possible substring starting from 'start'
        for (int end = start + 1; end <= s.length(); ++end) {
            String substring = s.substring(start, end);
            // If the substring is unique
            if (!seen.contains(substring)) {
                // Add the substring to the seen set
                seen.add(substring);
                // Recursively count unique substrings from the next position
                maxCount = Math.max(maxCount, 1 + backtrack(s, end, seen));
                // Backtrack: remove the substring from the seen set
                seen.remove(substring);
            }
        }
        return maxCount;
    }
}
