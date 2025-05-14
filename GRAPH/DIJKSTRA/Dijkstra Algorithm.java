// GFG => https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1


/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
*/

// User function Template for Java
class Solution {
    int first, second;
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int V = adj.size(); // Number of vertices
        
        // in pq => distance, node
        PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.first));

        //in result => node, distance
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));
        
        result.set(src, 0);
        pq.offer(new iPair(0, src));

        while (!pq.isEmpty()) {
            iPair top = pq.poll();
            int d = top.first;  // this is distance
            int node = top.second; // this is node

            for (iPair vec : adj.get(node)) {
                int adjNode = vec.first;  // this is node
                int dist = vec.second;  // this is distance

                if (d + dist < result.get(adjNode)) {
                    result.set(adjNode, d + dist);
                    pq.offer(new iPair(result.get(adjNode), adjNode));
                }
            }
        }

        return result;
    }
}
