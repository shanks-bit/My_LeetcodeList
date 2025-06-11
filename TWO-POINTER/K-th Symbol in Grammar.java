// leetcode -> https://leetcode.com/problems/k-th-symbol-in-grammar/submissions/1660529240/
class Solution {
    public int kthGrammar(int n, int k) {
        int cur = 0;
        int l = 0, r = (int)Math.pow(2, n - 1);

        for (int i = 0; i < n - 1; i++) {
            int mid = (l + r) / 2;

            if (k <= mid) {
                r = mid;
            } else {
                l = mid + 1;
                cur = (cur == 0) ? 1 : 0;
            }
        }
    return cur;
    }
}
