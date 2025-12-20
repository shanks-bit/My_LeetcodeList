// leetcode -> https://leetcode.com/problems/minimum-number-of-operations-to-have-distinct-elements/description/

class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> sett = new HashSet<>();

        for (int i=nums.length-1; i>=0; i--){
            int a = nums[i];
            if (sett.contains(a)){
                // bcoz index starts at 0
                int l = i + 1;

                // how many group of size 3 are needed to cover l
                //each opert. fix 3 elem. at a time 
                //and if leftover remains we need more 1 opert.
                return (l / 3) + ((l % 3) != 0 ? 1 : 0);
            }
            else sett.add(a);
        }
        return 0;
    }
}
