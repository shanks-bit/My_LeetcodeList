// https://leetcode.com/problems/longest-mountain-in-array/description/

class Solution {
    public int longestMountain(int[] arr) {
         // A mountain needs at least 3 elements
        if(arr.length < 3)
            return 0;
        int ans = 0;
        int si =0; // si -> start index of a potential mountain
        int i = si+1; //i -> moving pointer to scan the array
        while(i<arr.length){
            // If the slope is flat or decreasing, a mountain cannot start here.
            // Move the start index forward and continue scanning.
            if(arr[i] <= arr[i-1]){
                si=i;
                i++;
                continue;
            }
            // Climb up: strictly increasing sequence until we reach the peak
            while(i<arr.length && arr[i] > arr[i-1]){
                i++;
            }
            // If we reached the end or encountered a flat slope,
            // then this cannot form a valid mountain
            // Reset start
            if(i==arr.length || arr[i] == arr[i-1])
                continue;        
            
            // Descend: strictly decreasing sequence after the peak
            while(i<arr.length && arr[i] < arr[i-1])
                i++;
            
            // i is already one step past the last valid element of the mountain,
            // so the mountain length is (i - si)
            ans = Math.max(i-si, ans);

            // Reset start index to the last element of the mountain
            // This allows detection of overlapping mountains
            si=i-1;
        }

        return ans;
    }
}
