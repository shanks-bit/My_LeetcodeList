// leetcode -> https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
/*
Intuition
We only need to count the unbalanced opening brackets [ that don't have matching closing brackets ]. This helps us figure out how many swaps are needed. Instead of using a stack,
we can track the number of unmatched brackets with an integer, which saves space.

The stackSize represents the number of unmatched [ brackets as we go through the string. When we encounter a closing bracket ], we try to balance it by reducing stackSize if there’s
already an unmatched opening bracket (i.e., stackSize > 0).

After the loop, the value of stackSize will show how many opening brackets are still unmatched. These remaining [ brackets need to be balanced with closing brackets by performing
swaps. Each swap balances two brackets (one [ and one ]), so the minimum number of swaps is (stackSize + 1) / 2.
*/
class Solution {
    public int minSwaps(String s) {
        int stackLen = 0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            // If character is opening bracket, increment the stack size.
            if (ch == '[') stackLen++;
            else {
                // If the character is closing bracket, and we have an opening bracket, decrease the stack size.
                if (stackLen > 0) stackLen--;
            }
        }
        return (stackLen + 1) / 2;
    }
}
