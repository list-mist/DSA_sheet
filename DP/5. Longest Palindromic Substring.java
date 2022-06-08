class Solution {
    public String longestPalindrome(String s) {
        return lcs(s,(s));
    }
    void display(int[][] dp, int n){
        int i = 0, j = 0;
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
               System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    String lcs(String s1, String s2){
        int n = s1.length(); int max = 0;
        String res = "";
        int start = 0, end = 0;
        int[][] dp = new int[n][n];
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; i < n && j < n; i++){
                if(j  == i){
                    dp[i][j] = 1;
                }
                else if(j - i == 1){
                    if(s1.charAt(i) == s2.charAt(j)){
                        dp[i][j] = 2;
                    }
                }
                else if(j - i >= 2){
                    if(s1.charAt(i) == s2.charAt(j) && dp[i+1][j-1] != 0){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }
                }
                if(max < dp[i][j]){
                    max = dp[i][j];
                    start = i; end = j;
                }
            }
        }
        res = s1.substring(start,end+1);
        return res;
    }
}
