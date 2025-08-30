// leetcode => https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

//Pruning Solution
class Solution {

    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        int[] maxCount = new int[1];
        backtrack(s, 0, seen, 0, maxCount);
        return maxCount[0];
    }

    private void backtrack(
        String s,
        int start,
        Set<String> seen,
        int count,
        int[] maxCount
    ) {
        // Prune: If the current count plus remaining characters can't exceed maxCount, return
        if (count + (s.length() - start) <= maxCount[0]) return;

        // Base case: If we reach the end of the string, update maxCount
        if (start == s.length()) {
            maxCount[0] = Math.max(maxCount[0], count);
            return;
        }

        // Try every possible substring starting from 'start'
        for (int end = start + 1; end <= s.length(); ++end) {
            String substring = s.substring(start, end);
            // If the substring is unique
            if (!seen.contains(substring)) {
                // Add the substring to the seen set
                seen.add(substring);
                // Recursively count unique substrings from the next position
                backtrack(s, end, seen, count + 1, maxCount);
                // Backtrack: remove the substring from the seen set
                seen.remove(substring);
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

//Simple Backtrack
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
