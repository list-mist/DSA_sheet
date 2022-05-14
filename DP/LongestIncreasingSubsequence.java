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
    // Time complexity ->  O(N*N)
    // Space complexity -> O(N*N)
    int maxLIS(int[] a, int n){
        int[] dp = new int[n];
        int max = 1;
      
        Arrays.fill(dp,1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
               
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
     // Time complexity ->  O(N*N)
    // Space complexity -> O(N)
}
