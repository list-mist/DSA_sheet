class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans,fun(matrix,i,j,dp));
            }
        }
        if(ans == 1) return 1;
        return ans * ans;
    }
    boolean valid(char[][] matrix, int i,int j){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return false;
        return true;
    }
    int fun(char[][] mat, int i, int j,int[][] dp){
        if(!valid(mat,i,j) || mat[i][j] != '1') return 0;
        if(dp[i][j] != 0) return dp[i][j];
        mat[i][j] = '#';
        int area = 0;
        int row = fun(mat,i+1,j,dp);
        int col = fun(mat,i,j+1,dp);
        int diagonal = fun(mat,i+1,j+1,dp);
        
        area =  1 + minimum(row,col,diagonal);
        mat[i][j] = '1';
        
        return dp[i][j] = area;
    }
    int minimum(int row, int col,int diagonal){
        int min1 = Math.min(row,col);

        return Math.min(min1,diagonal);
    }
}
