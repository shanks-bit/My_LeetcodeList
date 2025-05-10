// leetcode => https://leetcode.com/problems/course-schedule-ii/
// BFS
class Solution {
    public int[] topologicalSortCheck(Map<Integer, List<Integer>> adj, int n, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[n];
        int index = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
          // add element in queue whose indegree is zero
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            result[index++] = u;
            count++;

            if (adj.containsKey(u)) {
                for (int v : adj.get(u)) {
                    indegree[v]--;

                    if (indegree[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
        }

        return (count == n) ? result : new int[0];  // Return empty array if cycle exists
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];

            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(b).add(a);
            indegree[a]++;
        }

        return topologicalSortCheck(adj, numCourses, indegree);
    }

// DFS
    private boolean hasCycle = false;

    private void DFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited, Stack<Integer> st, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (inRecursion[v]) {
                hasCycle = true;
                return;
            }
            if (!visited[v]) {
                DFS(adj, v, visited, st, inRecursion);
            }
        }

        st.push(u);
        inRecursion[u] = false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        hasCycle = false;
        Stack<Integer> st = new Stack<>();

        // Building adjacency list
        for (int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        // Performing DFS for all nodes
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                DFS(adj, i, visited, st, inRecursion);
            }
        }

        // If cycle exists, return empty array
        if (hasCycle) {
            return new int[0];
        }

        // Pop from stack to get topological order
        int[] result = new int[st.size()];
        int index = 0;
        while (!st.isEmpty()) {
            result[index++] = st.pop();
        }

        return result;
    }
