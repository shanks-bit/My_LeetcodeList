// leetcode -> https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> codeSet = new HashSet<>();
        int totalCombinations = 1 << k; // 2^k
        
        for (int i = 0; i <= s.length() - k; i++) {
            //Java substring excludes the end index
            codeSet.add(s.substring(i, i + k));
        }
        
        return codeSet.size() == totalCombinations;
    }
}
