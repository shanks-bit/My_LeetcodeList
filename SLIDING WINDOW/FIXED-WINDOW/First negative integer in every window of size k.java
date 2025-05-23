// GFG => https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

class Solution {

    // Function to find the first negative integer in every window of size k
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        // write code here
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (j < arr.length) {
            
            if (arr[j] < 0) {
                deque.addLast(arr[j]);
            }
            
            if (j - i + 1 == k) {
                
                 // Add the first negative number from the deque or 0 if the deque is empty
                result.add(deque.isEmpty() ? 0 : deque.peekFirst());
                
                // Remove the first element from the deque if it is sliding out of the window
                if (!deque.isEmpty() && arr[i] == deque.peekFirst()) {
                    deque.pollFirst();
                }
                i++;
            }
            j++;
        }
        return result;
    }
}
