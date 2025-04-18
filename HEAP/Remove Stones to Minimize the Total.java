// leetcode => https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/
// By default, Java's PriorityQueue is a min-heap — it keeps the smallest element at the head.

class Solution {
    public int minStoneSum(int[] piles, int k) {
        // during peek and poll operation we get minimum element and to
        // reverse this we use (x, y) -> Integer.compare(y, x) operation
        // during creation of our priority queue. 
        // So, instead of a min-heap (where smaller elements come first), it becomes a max-heap, where larger elements come first.
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        // here we add all  the elements of piles to our priority queue
        // you can also use q.add method instead of q.offer method
        for(int i = 0; i < piles.length; ++i){
            q.offer(piles[i]);
        }
        // we simply take the maximum elements of priority queue and half it 
        // and store it in the priority queue
        while(k > 0){
            q.offer(q.peek() - q.poll() / 2);
            k--;
        }
        int ans = 0;     // used to store the result
        // finding the sum of all the elements of queue after performing the 
        // operation k number of times
        while( !q.isEmpty()){
            ans += q.poll();
        }

        return ans;
    }
}
