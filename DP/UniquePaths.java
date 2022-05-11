package DP;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return total_ways(m-1,n-1,dp);
    }
    int total_ways(int m,int n,int[][] dp){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        
        if(dp[m][n] != 0) return dp[m][n];
        int down = total_ways(m-1,n,dp);
        int right = total_ways(m,n-1,dp);
        
        return dp[m][n] = down + right;
    }
    // Time complexity -> O(M*N)
    // Space complexity -> O(M*N)
    int totalWays(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0 ; i < n; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int down = dp[i-1][j];;
                int right = dp[i][j-1];
                
                dp[i][j] = down + right;
            }
        }
        return dp[m-1][n-1];
    }
    // Time complexity -> O(M*N)
    // Space complexity -> O(M*N)
    int no_of_ways(int m, int n){
        int[] prev = new int[n];
        int[] curr = new int[n];
        for(int i = 0; i < n; i++){
            prev[i] = 1;
        }
        curr[0] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int down = prev[j];;
                int right = curr[j-1];
                
                curr[j] = down + right;
            }
            prev = curr;
        }
        return prev[n-1];
    }
    // Time complexity -> O(M*N)
    // Space complexity -> O(N)
}
