// https://leetcode.com/problems/palindromic-substrings/description/

class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i=0; i<s.length(); i++){
            //check odd len
            count += countPalin(s, i, i);
            
            //check even len
            count += countPalin(s, i, i+1);
        }
        return count;
    }
    public int countPalin(String s, int j, int k){
        int count = 0;

        while ( j>=0 && k<s.length()){
            if (s.charAt(j) != s.charAt(k)) break;

            j--;
            k++;

            count += 1;
        }
        return count;
    }
}
