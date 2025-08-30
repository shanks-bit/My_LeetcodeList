//leetcode link = https://leetcode.com/problems/word-search/

/*Space Complexity: O(L)
Time Complexity: O(M * N * 3^L)
Space Complexity is because of recursion - to store function stack context.
Time Complexity - from every block we go in three adjacent blocks (avoiding the direction we came from). 
This walk can go for max of L times. So each thred at most goes L length long. -> O(3^L).
Now this is applied at each node from main calling function -> O(M * N). Therefore, O(M * N * 3^L).
*/
class Solution {
    int l,m,n;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        l = word.length();
        if(m*n < 1)
            return false;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                // find first word and start backtrack
                if(board[i][j] == word.charAt(0) && find(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board,int i,int j,String word,int idx){
        if(idx >= l)
            return true;

        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(idx))
            return false;

        char temp = board[i][j];    //Add element
        board[i][j] = '$';

        for(int[] dir : directions) {  //Explore element
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if(find(board, i_, j_, word, idx+1))
                return true;
        }

        board[i][j] = temp;   //Drop element
        return false;
    }
}

