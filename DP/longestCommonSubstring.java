
class Solution{

    int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        int ans = lcs(S1,S2,n,m,dp);
        return ans;
    }

    int lcs(String s1,String s2,int n,int m,int[][] dp){
        int max = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(i > 0 && j > 0){
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = 0;
                    }
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        
        return max;
    }
}
