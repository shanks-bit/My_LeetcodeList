// GFG => https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.*;

public class Solution {

    // DSU structures
    static int[] parent;
    static int[] rank;

    // Find with path compression
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    static void union(int x, int y) {
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

    // Kruskal's algorithm
    static int kruskal(List<int[]> edges) {
        int sum = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (find(u) != find(v)) {
                union(u, v);
                sum += wt;
            }
        }
        return sum;
    }

    // Function to find sum of weights of edges of the MST
    public static int spanningTree(int V, List<List<int[]>> adj) {
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<int[]> edges = new ArrayList<>();

        // Extract edges from adjacency list
        for (int u = 0; u < V; u++) {
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int wt = neighbor[1];
                edges.add(new int[]{u, v, wt});
            }
        }

        // Sort edges by weight
        edges.sort(Comparator.comparingInt(a -> a[2]));

        return kruskal(edges);
    }
}
