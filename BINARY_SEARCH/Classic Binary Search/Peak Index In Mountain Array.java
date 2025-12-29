//leetcode => https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length-1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(arr[mid] < arr[mid+1]){ //move to right side for finding peak
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
