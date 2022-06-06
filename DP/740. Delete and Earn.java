class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        int[] dp = new int[10001];
        
        for(int i : nums){
            freq[i]++;
        }
        int max = 0, sum = 0;
        
        dp[0] = 0;
        dp[1] = freq[1]*1;
        
        for(int i = 2; i < freq.length; i++){           
            int choose = freq[i] * i + dp[i-2];
            int notChoose = dp[i-1];
            
            dp[i] = Math.max(choose,notChoose);
        }
         
         return dp[freq.length - 1];
    }
}
