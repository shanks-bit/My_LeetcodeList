//leetcode => https://leetcode.com/problems/find-right-interval/description/
class Solution {

    int binarySearch(int[] arr,int target){
        int l = 0;
        int r = arr.length - 1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target){
                ans = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }
        return ans;
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] arr = new int[n];
        int[] ans = new int[n];
        for(int i = 0; i < n; ++i)
            arr[i] = intervals[i][0];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i)
            map.put(arr[i],i);
        Arrays.sort(arr);
        for(int i = 0; i < n; ++i){
            int val = binarySearch(arr,intervals[i][1]);
            if(val == -1)
                ans[i] = -1;
            else
             ans[i] = map.get(arr[val]);
        }
        return ans;
    }
}
/*
First, the code extracts the start times of each interval and stores them in an array arr. It also creates a mapping from the start time to its corresponding index in the original intervals array.
Next, it sorts the arr array, which allows for efficient binary search.
Then, for each interval in the intervals array, it performs a binary search on the sorted arr array to find the right interval. If a right interval is found, it retrieves the index of the interval from the mapping created earlier.
Finally, it returns an array containing the indices of the right intervals corresponding to each interval in the original array.
*/
