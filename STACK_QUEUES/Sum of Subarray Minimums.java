// https://leetcode.com/problems/sum-of-subarray-minimums/description/
/*
The trickiest part is:
st.size() + (nums.length - ind) > k
Suppose:
nums = [9, 8, 7]
k = 2
When processing 7, stack might contain:
[9, 8]
We want to remove 8 and 9.
But we cannot remove too many elements if there aren't enough elements remaining.
The condition guarantees:
elements already kept + elements available from current position
is enough to eventually construct k elements.
Another way to understand it:
Remove a bigger element only when doing so cannot make it impossible to reach size k.
*/
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];
      
        Arrays.fill(left, -1);
        Arrays.fill(right, length);
      
        Deque<Integer> stack = new ArrayDeque<>();
      
        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
      
        stack.clear();
      
        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
      
        int mod = (int) 1e9 + 7;
        long answer = 0;
      
        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }
      
        return (int) answer;
    }
}
