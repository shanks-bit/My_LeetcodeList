// leetcode => https://leetcode.com/problems/satisfiability-of-equality-equations/description/

class Solution {
    private int[] parent;
    private int[] rank;

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // Path compression
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) return;

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        // Initialize parent and rank arrays
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // First pass: process equality equations (==)
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }

        // Second pass: process inequality equations (!=)
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }
}
