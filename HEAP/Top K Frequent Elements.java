//https://leetcode.com/problems/top-k-frequent-elements/description/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
             map.put(num, map.getOrDefault(num, 0) + 1); 
        }

        //heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int key : map.keySet()) {
            heap.add(key); 
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            ans.add(heap.poll());
        }
        
        return ans;
    }
}

//bucket sort
//https://leetcode.com/problems/top-k-frequent-elements/solutions/5032156/beats-96-39-of-users-with-java-simple-well-explained-bucket-sorting-hashmap-solution
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num,0) + 1);
        }
        for (int key : hm.keySet()) {
            int freq = hm.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] ans = new int[k];
        int pos = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && pos < k; j++) {
                    ans[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }
        return ans;
    }
}
