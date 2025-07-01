// leetcode => https://leetcode.com/problems/total-cost-to-hire-k-workers/description/
//use 2 priority queue
/*


    Initialize two priority queues head_workers and tail_workers that store the first m workers and the last m workers, where the worker with the lowest cost has the highest priority.

    Set up two pointers next_head = m, next_tail = n - m - 1 indicating the next worker to be added to two queues.

    Compare the top workers in both queues, and hire the one with the lowest cost, if both workers have the same cost, hire the worker from head_workers. Add the cost of this worker to the total cost.

    If next_head <= next_tail, we need to fill the queue with one worker:
        If the hired worker is from head_workers, we add the worker costs[next_head] to it and increment next_head by 1.
        If the hired worker is from tail_workers, we add the worker costs[tail_head] to it and decrement tail_head by 1.

    Otherwise, skip this step.

    Repeat steps 3 and 4 k times.

    Return the total cost of all the hired workers.
*/
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();
        
        // headWorkers stores the first k workers.
        // tailWorkers stores at most last k workers without any workers from the first k workers.
        for (int i = 0; i < candidates; i++) {
            headWorkers.add(costs[i]);
        }
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
            tailWorkers.add(costs[i]);
        }

        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length - 1 - candidates;

        for (int i = 0; i < k; i++) {
            if (tailWorkers.isEmpty() || !headWorkers.isEmpty() && headWorkers.peek() <= tailWorkers.peek()) {
                answer += headWorkers.poll();
                
                // Only refill the queue if there are workers outside the two queues.
                if (nextHead <= nextTail) {
                    headWorkers.add(costs[nextHead]);
                    nextHead++;
                }
            } 
            
            else {
                answer += tailWorkers.poll();

                // Only refill the queue if there are workers outside the two queues.
                if (nextHead <= nextTail) {
                    tailWorkers.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }

        return answer;
    }
}

//use 1 Priority queue
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
