class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        if(n == 1) return 1;
        int[][] dp = new int[n+1][n+1];
        return maxLen(nums,n-1,n,dp);
    }
    int maxLen(int[] a, int idx, int prev,int[][] dp){
        if(idx == 0){
            if(prev != a.length && a[prev] > a[idx]) return 1;
            return 0;
        }
       
        if(dp[idx][prev] != 0) return dp[idx][prev];
        int take = 0;
        
        if(prev == a.length || a[idx] < a[prev]){
            take = 1 + maxLen(a,idx-1,idx,dp);
        }
        int notTake = maxLen(a,idx-1,prev,dp);
     
        return  dp[idx][prev] = Math.max(take,notTake);
    }
}
