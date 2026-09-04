// https://leetcode.com/problems/queue-reconstruction-by-height

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> ordered = new LinkedList<>();
        for (int[] p: people) ordered.add(p[1], p);

        return ordered.toArray(new int[people.length][2]);
    }
}

/*
Well, at least this is quite simple. We just need to sort our array in descending order by height and in ascending 
order by k for people that share the same height. Then, we quite literally just insert into an array based on the 
k value as the index. We'll use a linked list initially for insertion before converting to a 2D array.
Just to be completely clear, this works because of two reasons:
Taller heights aren't affected by shorter heights
We can sort each individual height in ascending order by k
*/
