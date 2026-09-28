// https://leetcode.com/problems/permutation-in-string/description/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();

        // Initialize frequency maps for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }

        // Check if the first window matches
        if (s1Count.equals(s2Count)) {
            return true;
        }

        // Sliding window over the rest of s2
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            // Add the new character to the window
            char charRight = s2.charAt(r);
            s2Count.put(charRight, s2Count.getOrDefault(charRight, 0) + 1);

            // Remove the leftmost character from the window
            char charLeft = s2.charAt(l);
            s2Count.put(charLeft, s2Count.get(charLeft) - 1);

            if (s2Count.get(charLeft) == 0) {
                s2Count.remove(charLeft);
            }

            l++;

            // Check if the current window matches
            if (s1Count.equals(s2Count)) {
                return true;
            }
        }

        return false;
    }
}
