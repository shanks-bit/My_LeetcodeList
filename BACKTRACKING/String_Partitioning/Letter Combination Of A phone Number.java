//leetcode => https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    private List<String> result = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        StringBuilder temp = new StringBuilder();

        solve(0, digits, temp, mp);

        return result;
    }


    private void solve(int idx, String digits, StringBuilder temp, HashMap<Character, String> 
    mp) {
        if (idx >= digits.length()) {
            result.add(temp.toString());
            return;
        }

        char ch = digits.charAt(idx);
        String str = mp.get(ch);

        for (int i = 0; i < str.length(); i++) {
            // Do
            temp.append(str.charAt(i));
            solve(idx + 1, digits, temp, mp);
            // Undo
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
