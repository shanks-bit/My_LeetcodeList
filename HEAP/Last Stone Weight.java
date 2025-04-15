// leetcode => https://leetcode.com/problems/last-stone-weight/description/

class Solution {
    public int lastStoneWeight(int[] stones) {
         // Create a max-heap to store and compare the stone weights in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Add all stone weights to the max-heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        // Continue until there is only one stone left or none at all
        while (maxHeap.size() > 1) {
            // Get the two heaviest stones
            int stoneOne = maxHeap.poll();
            int stoneTwo = maxHeap.poll();

            // If they are not the same weight, put the difference back into the max-heap
            if (stoneOne != stoneTwo) {
                maxHeap.offer(stoneOne - stoneTwo);
            }
            // If they are equal, both stones are completely smashed, and nothing is added back
        }
        // Return the last stone's weight or 0 if no stones are left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
