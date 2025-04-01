//leetcode => https://leetcode.com/problems/count-vowel-strings-in-ranges/description/
class Solution {

    // Helper function to check if a character is a vowel
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int N = words.length;
        int Q = queries.length;
        int[] result = new int[Q];
        //cumSum have prefix sum
        int[] cumSum = new int[N];
        
        // Build cumulative sum array
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (isVowel(words[i].charAt(0)) && 
                isVowel(words[i].charAt(words[i].length() - 1))) 
            {
                sum++;
            }
            cumSum[i] = sum;
        }
        
        // Process each query
        for (int i = 0; i < Q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = cumSum[r] - (l > 0 ? cumSum[l - 1] : 0);
        }
        
        return result;
    }
}
