//leetcode=> https://leetcode.com/problems/kth-missing-positive-number/description/

//Brute force


//binary search
/*
We need a way to check on how many positive integers are missing before the given array element to use binary search. To do that, 
let's compare the input array [2, 3, 4, 7, 11] with an array with no missing integers: [1, 2, 3, 4, 5]. The number of missing 
integers is a simple difference between the corresponding elements of these two arrays:

    Before 2, there is 2 - 1 = 1 missing integer.

    Before 3, there is 3 - 2 = 1 missing integer.

    Before 4, there is 4 - 3 = 1 missing integer.

    Before 7, there are 7 - 4 = 3 missing integers.

    Before 11, there are 11 - 5 = 6 missing integers.

    The number of positive integers which are missing before the arr[idx] is equal to arr[idx] - idx - 1.
    

While left <= right:
Choose the pivot index in the middle: pivot = left + (right - left) / 2. Note that in Java we couldn't use straightforward 
pivot = (left + right) / 2
to avoid the possible overflow. In Python, the integers are not limited, and we're fine to do that.

If the number of positive integers which are missing before is less than k arr[pivot] - pivot - 1 < k - continue to search
on the right side of the array: left = pivot + 1.

Otherwise, continue to search on the left: right = pivot - 1.

At the end of the loop, left = right + 1, and the kth missing number is in-between arr[right] and arr[left]. The number of 
integers missing before arr[right] is arr[right] - right - 1. Hence, the number to return is 
arr[right] + k - (arr[right] - right - 1) = k + left.

**/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // If number of positive integers
            // which are missing before arr[pivot]
            // is less than k -->
            // continue to search on the right.
            if (arr[mid] - (mid+1) < k) { //how many no. are missing=> arr[mid] - (mid+1)
                left = mid + 1;
            }
                // Otherwise, go left.
            else {
                right = mid - 1;
            }
        }
        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = k + left
        return left + k;
    }
}
