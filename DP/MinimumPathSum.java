class Solution {
 
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
       // return minPath(grid,0,0,dp);
       // return minPath_tabulation(grid,dp);
        return minPathSum(grid,n,m);
    }
    int minPath(int[][] grid, int i, int j,int[][] dp){
        if(valid(grid,i,j) == false) return Integer.MAX_VALUE;
        if(i == grid.length -1 && j == grid[0].length-1) return grid[i][j];
        
        if(dp[i][j] != 0) return dp[i][j];
        int right =  minPath(grid,i,j+1,dp);
        int down =  minPath(grid,i+1,j,dp);
        
        return dp[i][j] = grid[i][j] + Math.min(down,right);
    }
    boolean valid(int[][] grid,int i,int j){
        if(i >= grid.length || j >= grid[0].length) return false;
        return true;
    }
    int minPath_tabulation(int[][] grid,int[][] dp){
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];  
        }
        for(int i = 1; i < grid[0].length; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];  
        }
        int n = dp.length;
        int m = dp[0].length;
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];
    }
    int minPathSum(int[][] grid,int n,int m){
        int[] prev = new int[m];
        int[] curr = new int[m];
        
        prev[0] = grid[0][0];
        for(int i = 1; i < m; i++){
            prev[i] = prev[i-1] + grid[0][i];  
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j == 0){
                    curr[j] = prev[j] + grid[i][0];
                }
                else if(j > 0){
                    curr[j] = grid[i][j] + Math.min(prev[j],curr[j-1]);
                }
            }
            prev = curr;
        } 
        return prev[m-1];
    }
}
