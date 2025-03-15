//leetcode => https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        if(nums[left] < nums[right]){
            return nums[left];
        }

        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }
            else if(nums[mid] < nums[right]){
                right = mid;
            }
            else{
                right--;
            }
        }
        return nums[right];
    }
}
//if arr[mid]> arr[j] then i=mid+1 is true that mean min element is at right side of the array and why i=mid+1 because arr[mid] can not be the answer that why we increase it by one!!

//else if(arr[mid]<arr[j]) then j=mid is true that mean min element is at left side of the array and why j=mid beacuse arr[mid] can be the answer as it smaller then arr[j]!!!

//else i.e arr[mid]==arr[j] then j-- means that min element is at left side only as this condition if(arr[mid>arr[j]]) was failed so that why we reduce left index by one!!!
