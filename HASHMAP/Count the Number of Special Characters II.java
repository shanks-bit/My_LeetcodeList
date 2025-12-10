// leetcode -> https://leetcode.com/problems/count-the-number-of-special-characters-ii/description/

class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,Integer> lwr= new HashMap<>();
        HashMap<Character,Integer> upr= new HashMap<>();
        for(int i=0;i<word.length();i++){
            char chr = Character.toLowerCase(word.charAt(i));
            if(Character.isLowerCase(word.charAt(i))){
                lwr.put(chr,i);
            }
            else {
                if(!upr.containsKey(chr)){
                    upr.put(chr,i);
                }
            }
        }
        int cnt=0;
        for(char ky:lwr.keySet()){
            if(upr.containsKey(ky)&&lwr.get(ky)<upr.get(ky)){
                cnt++;
            }
        }
        return cnt;
    }
}
