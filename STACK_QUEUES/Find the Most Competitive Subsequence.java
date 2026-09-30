// https://leetcode.com/problems/find-the-most-competitive-subsequence/description/

/*
We need to find the most competitive subsequence of length k from the given array nums.
A subsequence is more competitive if it is lexicographically smaller than other subsequences of the same length.
To achieve this efficiently, we use a monotonic stack approach:
Iterate through the array:
For each element val, while:
The stack is not empty,
The top of the stack (st.peek()) is greater than the current element,
And there are still enough elements left to reach a total size of k (checked by (st.size() + (nums.length - ind)) > k),
We pop from the stack to remove a larger element that makes the sequence less competitive.
Push the current element onto the stack if the stack size is less than k.
After traversing all elements, the stack contains the most competitive subsequence.
Finally, we build the result array by popping elements from the stack in reverse order.
*/
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();

        int ind = 0;
        for(int val : nums){
            while(!st.isEmpty() && st.peek() > val && (st.size() + (nums.length - ind)) > k){
                st.pop();
            }

            if(st.size() < k){
                st.push(val);
            }
            ind++;
        }

        ind = k - 1;
        int[] res = new int[k];
        while(!st.isEmpty()){
            res[ind--] = st.pop();
        }

        return res;
    }
}
