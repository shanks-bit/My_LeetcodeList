// leetcode => https://leetcode.com/problems/sliding-window-maximum/description/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>(); 
        int i=0, j=0, ptr=0; 
        int n = nums.length; 
        int[] res = new int[n-k+1]; 

        while(j<n){
            while(!q.isEmpty() && q.peekLast()<nums[j]){
                q.pollLast(); 
            }
        
            q.add(nums[j]);

            if(j-i+1<k){
                j++; 
            }else if(j-i+1==k){

                res[ptr++] = q.peek();
                
                if(nums[i]==q.peek()){
                    q.pollFirst(); 
                }
                i++; 
                j++;
            }
        }

        return res; 
    }
}
