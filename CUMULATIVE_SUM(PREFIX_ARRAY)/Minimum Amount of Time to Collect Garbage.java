//leetcode => https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/submissions/1596177459/
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int time = 0;
        int n = garbage.length;

        int G = 0;
        int M = 0;
        int P = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    M = i;
                } else if (garbage[i].charAt(j) == 'P') {
                    P = i;
                } else {
                    G = i;
                }
                total++;
                //it is counting all minutes of all element whwnever they are picking up garbage
            }
        }

        // Precompute the time (prefix sum)so that at any index can calculate cumulative time with respect to any element last position seen
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        total += M > 0 ? travel[M - 1] : 0;
        total += P > 0 ? travel[P - 1] : 0;
        total += G > 0 ? travel[G - 1] : 0;

        return total;
    }
}
