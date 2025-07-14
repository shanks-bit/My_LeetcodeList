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
We check whether the current count of unique substrings, combined with the remaining characters in the string, can yield a higher count than what we have 
already found. If this total cannot exceed our maximum count, we return immediately, skipping unnecessary calculations. This step significantly reduces the number
of recursive calls, especially for longer strings
*/
