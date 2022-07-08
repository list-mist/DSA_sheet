class Solution {
    int mod = (int)Math.pow(10,9) + 7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = -1;
            }
        }
        return targetSum(n,k,target, 0, 0,dp);
    }
    
    int targetSum(int n, int k, int target, int steps, int sum, int[][] dp){
        
        if(steps == n && sum == target) return 1;
        
        if(steps > n || sum > target) return 0;
        if(dp[steps][sum] != -1) return dp[steps][sum];
        int cnt = 0;
        for(int i = 1; i <= k; i++){
            cnt = (cnt % mod )+ (targetSum(n,k,target, steps + 1, sum + i,dp) % mod);
        }
        
        return dp[steps][sum] = cnt % mod;
        
    }
}
