// leetcode => https://leetcode.com/problems/total-cost-to-hire-k-workers/description/
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
         // Create a priority queue with a custom comparator
        // The comparator orders by cost and then index
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int n = costs.length;
        int leftIndex = candidates - 1; // Left boundary of the elements added to the queue
        int rightIndex = n - candidates; // Right boundary of the elements added to the queue

        // Add initial candidates to the priority queue
        for (int h = 0; h < candidates; ++h) {
            queue.offer(new int[]{costs[h], h});
        }

        // Add the opposite end candidates to the priority queue
        for (int h = n - candidates; h < n; ++h) {
            if (h > leftIndex) {
                queue.offer(new int[]{costs[h], h});
            }
        }

        long totalCost = 0; // Sum of the costs
        while (k-- > 0) {
            int[] current = queue.poll(); // Get the least expensive element
            int cost = current[0], index = current[1];
            totalCost += cost; // Update the total cost

            // If the element is from the left side, move right
            if (index <= leftIndex) {
                if (++leftIndex < rightIndex) {
                    queue.offer(new int[]{costs[leftIndex], leftIndex});
                }
            }

            // If the element is from the right side, move left
            if (index >= rightIndex) {
                if (--rightIndex > leftIndex) {
                    queue.offer(new int[]{costs[rightIndex], rightIndex});
                }
            }
        }

        return totalCost; // Return the total cost after processing for k elements
    }
}
