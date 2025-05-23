// GFG => https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
//T.C : O(n)
//S.C : O(1)
// fixed window
class Solution {
    
    private boolean allZero(int[] count) {
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    int search(String pat, String txt) {
        int k = pat.length();
        int[] count = new int[26];
        Arrays.fill(count, 0);
        
        for (char ch : pat.toCharArray()) {
            count[ch - 'a']++;
        }

        int i = 0, j = 0;
        int n = txt.length();
        int result = 0;

        while (j < n) {
            int idx = txt.charAt(j) - 'a';
            count[idx]--;

            if (j - i + 1 == k) {
                if (allZero(count)) {
                    result++;
                }

                count[txt.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return result;
    }
}
