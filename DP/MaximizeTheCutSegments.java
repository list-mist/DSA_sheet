package DP;

public class MaximizeTheCutSegments {
    
class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       int[] dp = new int[n+1];
       int ans = maxCuts(x,y,z,n,dp);
       if(ans <= 0) return 0;
       return ans;
    }
    int maxCuts(int x,int y,int z,int n,int[] dp){
        if(n == 0) return 0;
        
        if(n < 0) return Integer.MIN_VALUE;
        if(dp[n] != 0) return dp[n];
        int max_cut_x = 1 + maxCuts(x,y,z,n-x,dp);
        int max_cut_y = 1 + maxCuts(x,y,z,n-y,dp);
        int max_cut_z = 1 + maxCuts(x,y,z,n-z,dp);
        
        return  dp[n] = Math.max(max_cut_x,Math.max(max_cut_y, max_cut_z));
    }
}
 // Time complexity -> O(N)
 // Space complexity -> O(N)
}
