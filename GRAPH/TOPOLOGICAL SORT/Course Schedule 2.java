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
