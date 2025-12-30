// leetcode -> https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int r = mat.length, c = mat[0].length;

        for(int i=0; i<r; i++){

            if(i%2 == 0){
                for(int j=0; j<c; j++){
                    if(mat[i][j] != mat[i][(j+k)%c]) return false;
                }
            }else
            {
                for(int j=c-1; j>=0; j--){
                    if(mat[i][j] != mat[i][(j+k)%c]) return false;
                }
            }
        }
        return true;
    }
}
