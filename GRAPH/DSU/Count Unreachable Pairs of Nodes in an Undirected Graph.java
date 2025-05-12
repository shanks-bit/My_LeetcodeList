// leetcode => https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

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
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        // Initialize Union-Find
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Union-Find operations
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        // Count the size of each component
        Map<Integer, Integer> componentSize = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);  //finding i is in which component or parent
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
        }

        // Calculate the number of unreachable pairs
        long result = 0;
        long remainingNodes = n;

        for (int size : componentSize.values()) {
            result += (long) size * (remainingNodes - size);
            remainingNodes -= size;
        }

        return result;
    }
}
