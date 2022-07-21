class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] mat) {
        
        int maxVal = 0;
        dp = new int[mat.length][mat[0].length];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++) dp[i][j] = -1;
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
              
                if(dp[i][j] == -1){
                     maxVal = Math.max(maxVal, dfs(mat,i,j,Integer.MAX_VALUE));
                }
            }
        }
      
        return maxVal;
    }
    
    int dfs(int[][] mat, int i, int j, int prev){
        if(isSafe(mat,i,j) == false || (prev <= mat[i][j] && prev != Integer.MAX_VALUE)  ) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int c = mat[i][j];
        mat[i][j] = -1;
        
        int a = 1 + dfs(mat, i - 1, j, c);
        int b = 1 + dfs(mat, i + 1, j, c);
        int ce = 1 + dfs(mat, i , j - 1, c);
        int d = 1 + dfs(mat, i , j + 1, c);
    
        mat[i][j] = c;
        return dp[i][j] = Math.max(dp[i][j], Math.max(Math.max(a,b),Math.max(ce,d)));
        
    }
    
    boolean isSafe(int[][] mat, int i, int j){
     if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == -1) return false;
     return true;
    }
}
