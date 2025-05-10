// leetcode => https://leetcode.com/problems/course-schedule/
//BFS
class Solution {
    public boolean topologicalSortCheck(Map<Integer, List<Integer>> adj, int n, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
          // if indegree is 0 then add it to queue
            if (indegree[i] == 0) {
                count++;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            //If u does not exist in the map, it returns a new empty list (new ArrayList<>()).This prevents a NullPointerException when trying to access adj.get(u) for nodes without outgoing edges.
                indegree[v]--;

                if (indegree[v] == 0) {
                    count++;
                    queue.offer(v);
                }
            }
        }
        return count == n; // If we visited all courses, return true, otherwise return 
        //false (cycle exists)

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses]; //kahn's algo
        // indegree of a element means how many arrows are pointed towards it

        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            adj.putIfAbsent(b, new ArrayList<>()); //If b is not already a key in the adj map, then add b with an empty list as its value
            adj.get(b).add(a); //b ---> a
            
            indegree[a]++; //arrow ja raha hai 'a' me
        }
        //if cycle is present, not possible
        return topologicalSortCheck(adj, numCourses, indegree);
    }

// DFS
 public boolean isCycleDFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (!visited[v] && isCycleDFS(adj, v, visited, inRecursion))
                return true;
            else if (inRecursion[v])
                return true;
        }

        inRecursion[u] = false;
        return false;
    }
     public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];

        for (int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCycleDFS(adj, i, visited, inRecursion))
                return false;
        }

        return true;
    }
