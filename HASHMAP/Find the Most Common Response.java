// leetcode -> https://leetcode.com/problems/find-the-most-common-response/description/

class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> map = new HashMap<>();

        String str = "";
        int freq = 0;

        for(List<String> response : responses) {
            Set<String> answers = new HashSet<>();

            for(String answer : response) {
                if(!answers.contains(answer)) {
                    int count = map.getOrDefault(answer, 0) + 1;

                    map.put(answer, count);
                    answers.add(answer);

                    if(count > freq || (count == freq && 
                            answer.compareTo(str) < 0)) 
                    //If both have the same frequency, pick the lexicographically smaller string.
                        {
                            freq = count;
                            str = answer;
                        }
                }
            }
        }

        return str;
    }
}
