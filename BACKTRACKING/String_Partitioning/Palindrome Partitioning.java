//leetcode => https://leetcode.com/problems/palindrome-partitioning/description/
//Approach-1 (Using Bakctracking Khandani Template)
//Whenever a question asks for "Generating all possible" something, think about Backtracking once
//T.C : O(n * 2^n) - For a string of length n, there are 2^(𝑛 − 1) potential ways to partition it (since each position can either be a cut or not). and we also check palindrome O(n)
//S.C : O(n * 2^n) - Number of partitions * their length

class Solution {
    private int n;
    
    public List<List<String>> partition(String s) {
        n = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        
        backtrack(s, 0, curr, result);
        
        return result;
    }

    private void backtrack(String s, int idx, List<String> curr, List<List<String>> result) {
        if (idx == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {    
                curr.add(s.substring(idx, i + 1));     //take element
                backtrack(s, i + 1, curr, result);     //explore element
                curr.remove(curr.size() - 1);         //remove element
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
