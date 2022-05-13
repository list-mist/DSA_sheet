class Solution {
    public int coinChange(int[] coins, int amt) {
        int n = coins.length;
        int[][] dp = new int[n][amt+1];
        // int ans =  minCoins(coins,amt,coins.length - 1,dp);
        // if(ans >= 100000) return -1;
        int ans = min_table(coins,amt,n,dp);
      //  if(ans == 0) return -1;
        return ans;
    }
    int minCoins(int[] coins, int amt, int n,int[][] dp){
        if(n == 0) {
            
             if(amt % coins[0] == 0) return amt / coins[0];
             return Integer.MAX_VALUE; 
        }
        if(dp[n][amt] != 0) return dp[n][amt];
        int take = 100000; 
        if(coins[n] <= amt){
            take = 1 + minCoins(coins,amt-coins[n],n,dp);
        }
        
        int notTake = minCoins(coins,amt,n-1,dp);
        return dp[n][amt] =  Math.min(notTake,take);
    }
    int min_table(int[] coins,int amt,int n,int[][] dp){
        if(amt == 0 || n == 0) return 0; 
        for(int i = 0; i <= amt; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i / coins[0];
            }
            else{
                dp[0][i] = Integer.MAX_VALUE / 10;
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= amt; j++){
                int take = Integer.MAX_VALUE / 10;
                if(coins[i] <= j){
                    take = 1 + dp[i][j-coins[i]];
                }
                int notTake = dp[i-1][j];
                
                dp[i][j] = Math.min(take,notTake);
            }
        }
       if(dp[n-1][amt] == 0 || dp[n-1][amt] >= Integer.MAX_VALUE / 10) return -1;
     
        return dp[n-1][amt];
    }
    
}
