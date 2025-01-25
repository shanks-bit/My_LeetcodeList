//leetcode => https://leetcode.com/problems/combinations/description/

class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    private void solve(int start, int n, int k, List<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);                     //add element
            solve(i + 1, n, k - 1, temp);    //explore element
            temp.remove(temp.size() - 1);    //remove element
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        solve(1, n, k, temp);
        return result;
    } 
