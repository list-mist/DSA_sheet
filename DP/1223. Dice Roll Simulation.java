class Solution {
    int[][][] dp;
    int mod = (int) Math.pow(10,9) + 7;
    public int dieSimulator(int n, int[] rollMax) {
        dp = new int[n+1][7][16];
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= 6; j++){
                for(int k = 0; k <= 15; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return countWays(n,rollMax, 0, 0, 1);
    }
    
    int countWays(int n, int[] rollMax, int steps, int prev, int count){
        
        if(prev != 0 && count > rollMax[prev-1]) {
            return 0;
        }
        if(steps == n) return 1;

        if(dp[steps][prev][count] != -1) return dp[steps][prev][count];
        
        int cnt = 0;
        
        for(int i = 1; i <= 6; i++){
            
            if(prev == i) {
               
                cnt = (cnt % mod) + (countWays(n,rollMax, steps + 1, i, count + 1) % mod);
            }
            else{
                cnt = (cnt % mod) + (countWays(n,rollMax, steps + 1, i, 1) % mod);
            }
        }
        return dp[steps][prev][count] = cnt % mod ;
    }
}
