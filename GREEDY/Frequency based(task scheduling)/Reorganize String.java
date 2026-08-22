// https://leetcode.com/problems/reorganize-string/description/

class Solution {
    public String reorganizeString(String s) {
        int[] charFreq = new int[26];

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            charFreq[c - 'a']++;
        }

        // Step 2: Find max frequency character
        int maxFreq = 0;
        char maxChar = 'a';

        for (int i = 0; i < 26; i++) {
            if (charFreq[i] > maxFreq) {
                maxFreq = charFreq[i];
                maxChar = (char) ('a' + i);
            }
        }

        // Step 3: Check feasibility
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        // Step 4: Place max frequency character
        char[] result = new char[s.length()];
        int index = 0;

        while (charFreq[maxChar - 'a'] > 0) {
            result[index] = maxChar;
            index += 2;
            charFreq[maxChar - 'a']--;
        }

        // Step 5: Fill remaining characters
        for (int i = 0; i < 26; i++) {
            while (charFreq[i] > 0) {
                if (index >= result.length) {
                    index = 1;
                }
                result[index] = (char) ('a' + i);
                index += 2;
                charFreq[i]--;
            }
        }

        return new String(result);        
    }
}
