//leetcode => https://leetcode.com/problems/max-chunks-to-make-sorted/description/

// Approach-1 (Using cumulative Sum)
// T.C : O(n)
// S.C : O(1)
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int cumSum = 0;
        int normalSum = 0;

        int chunksCount = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            normalSum += i;

            if (cumSum == normalSum) {
                chunksCount++;
            }
        }

        return chunksCount;
    }
}

// Approach-2 (Using max check)
// T.C : O(n)
// S.C : O(1)
class Solution {
    public int maxChunksToSorted(int[] arr) {
         int chunkCount = 0; // Initialize the count of chunks
        int maxSoFar = 0; // Initialize the maximum value found so far in the array
        // Iterate through the array
        for (int index = 0; index < arr.length; ++index) {
            // Update the maximum value seen so far
            maxSoFar = Math.max(maxSoFar, arr[index]);          

            // If the current index is equal to the maximum value encountered,
            // it means all values before this index are smaller or equal to 'index'
            // and this position is a valid chunk boundary
            if (index == maxSoFar) {
                // Increment the count of chunks
                ++chunkCount;
            }
        }
        return chunkCount; // Return the total number of chunks
    }
}
