// https://leetcode.com/problems/remove-outermost-parentheses/description/
/*
We can represent a valid parentheses string as a Dyck Path:
Dyck Path is a series of up and down steps.
    “(” moves the path up by one level.
    “)” moves the path down by one level.
The path will begin and end on the same level, and as the path moves from left to right it will rise and fall, 
never dipping below the height it began on.
*/
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sol = new StringBuilder();
        int l = 0;
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if ((ch == '(' && l++ > 0) || (ch == ')' && --l > 0)){
                sol.append(ch);
            }
        }
        return sol.toString();
    }
}
