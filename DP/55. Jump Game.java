class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        
        return canReach(nums,n,dp);
    }
    
    boolean canReach(int[] a,int n, boolean[] dp){
       dp[n-1] = true;
        
       for(int i = n-2; i >= 0; i--){
           if(a[i] >= 1 && dp[i+1]){
               dp[i] = true;
           }else{
               int k = 1;
               while(dp[i+k] != true && k <= a[i]){
                   k++;
               }
               if(dp[i+k] && k <= a[i]) dp[i] = true;
               
           }
       }
       return dp[0];
    }
}
