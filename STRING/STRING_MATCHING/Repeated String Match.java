// https://leetcode.com/problems/repeated-string-match/description/

class Solution {

    public int repeatedStringMatch(String a, String b) {

        // 👑 Initial shadow army
        StringBuilder sb = new StringBuilder(a);

        // ⚔️ Number of summons
        int ans = 1;

        // 🔥 Expand until battlefield is large enough
        while(sb.length() < b.length()) {
            sb.append(a);
            ans++;
        }

        // 👁️ First enemy detection
        if(sb.toString().contains(b)) return ans;

        // ⚡ Final expansion for overlap cases
        sb.append(a);

        // 👁️ Final enemy scan
        if(sb.toString().contains(b)) return ans + 1;

        // ☠️ Impossible mission
        return -1;
    }
}
