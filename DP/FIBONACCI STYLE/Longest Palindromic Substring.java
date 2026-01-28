// https://leetcode.com/problems/longest-palindromic-substring/description/

class Solution {
    int maxi = 0;
    int start = 0;

    //2 pointer
    // public String longestPalindrome(String s) {
    //     for (int len = s.length(); len > 0; len--){
    //         for (int start = 0; start <= s.length()-len; start++){
    //             if (check(start, start+len, s)){
    //                 return s.substring(start, start+len);
    //             }
    //         }
    //     }
    //     return "";
    // }
    // private boolean check(int i, int j, String s){
    //     int l = i, r = j-1;
    //     while (l < r){
    //         if (s.charAt(l) != s.charAt(r)){
    //             return false;
    //         }
    //         l++;
    //         r--;
    //     }
    //     return true;
    // }

    //dp
    public String longestPalindrome(String s) 
    {    char[] a = s.toCharArray();
        if (s.length() < 2) return s;

        for (int i=0; i<a.length; i++){
            //odd length check
            expandPalin(a, i, i);

            //even length check
            expandPalin(a, i, i+1);
        }
        return s.substring(start, start + maxi);
    }

public void expandPalin( char[] s, int j, int k){
    while ( j>=0 && k<s.length && s[j]==s[k]){
        j--;
        k++;
    }
    if (maxi < k-j-1){
        maxi = k-j-1;
        start = j+1;
    }
}
}
