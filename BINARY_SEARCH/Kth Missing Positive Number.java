//leetcode=> https://leetcode.com/problems/kth-missing-positive-number/description/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] - (mid+1) < k) { //how many no. are missing=> arr[mid] - (mid+1)
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}
