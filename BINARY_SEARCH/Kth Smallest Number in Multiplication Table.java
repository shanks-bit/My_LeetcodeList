//leetcode => https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/

class Solution {
     public boolean helper(int x,int row,int col,int k){
        int count = 0;
        for(int i = 1;i<=row;i++){
            count += Math.min(x/i,col);
        }
        return count >= k;
    }
    public int findKthNumber(int m, int n, int k) {
        int low = 1,high = m*n;
        while(low < high){
            int mid = low + (high - low)/2;
            if(helper(mid,m,n,k)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
