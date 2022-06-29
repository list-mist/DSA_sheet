class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        if(n == 1) return nums[0];
      
        int res = maxMoney(nums, nums.length - 1, dp,1);
     
        Arrays.fill(dp,-1);
        int res1 = maxMoney(nums, nums.length - 2, dp,0);
        return Math.max(res, res1);
       
    }
     int maxMoney(int[] nums, int i, int[] dp,int end){
        if(i < end) return 0;
        if(dp[i] != -1) return dp[i];
        int notTake = maxMoney(nums, i - 1, dp,end);
        
        int take = nums[i] + maxMoney(nums, i - 2, dp,end);
        
        return dp[i] = Math.max(take,notTake);
    }
    
}
