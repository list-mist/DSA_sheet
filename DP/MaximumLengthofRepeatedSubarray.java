class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] maxVal = new int[1];
        int[][] dp = new int[n1+1][n2+1];
    //    maxLen(nums1,nums2,n1-1,n2-1,maxVal,dp);
     //   return maxVal[0];
        
        return max_length(nums1,nums2,n1,n2,dp);
    }
    int maxLen(int[] nums1,int[] nums2,int n1,int n2,int[] maxVal,int[][] dp){
        if(n1 < 0 || n2 < 0 ) return 0;
        
        if(dp[n1][n2] != 0) return dp[n1][n2];
        int ans = 0;
        
        if(nums1[n1] == nums2[n2]){
           ans = 1 + maxLen(nums1,nums2,n1-1,n2-1,maxVal,dp);
           maxVal[0] = Math.max(maxVal[0],ans);
        }
        
        maxLen(nums1,nums2,n1-1,n2,maxVal,dp);
        maxLen(nums1,nums2,n1,n2-1,maxVal,dp);
        
        dp[n1][n2] = ans;
        return ans;
    } 
    int max_length(int[] nums1,int[] nums2,int n1,int n2,int[][] dp){
        int ans = 0;
        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                if(i == 0  || j == 0){
                    continue;
                }
                else if(i > 0 && j > 0 && nums1[i-1] == nums2[j-1] ){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
