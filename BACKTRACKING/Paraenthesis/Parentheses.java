// leetcode -> https://leetcode.com/problems/generate-parentheses/description/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();

        backtrack(0, 0, "", n, res);
        return res;
    }

        private void backtrack(int openN, int closeN, String s, int n, List<String>res){
            if(openN == closeN && openN + closeN == n * 2){
                res.add(s);
                return;
            }

            if( openN < n){
                backtrack(openN + 1, closeN, s + "(", n, res);
            }
            if( closeN < openN){
                backtrack(openN, closeN + 1, s + ")", n, res);
            }
        }

    
}
