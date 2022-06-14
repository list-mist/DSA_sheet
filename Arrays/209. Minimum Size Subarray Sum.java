class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, n = nums.length;
        
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(j < n){
            sum += nums[j];
            
            while(i < n && sum >= target){
                res = Math.min(res, j - i +1);
                sum -= nums[i];
                i++;
            }
    
            j++;
        }
        if(res == Integer.MAX_VALUE) return 0;
        
        return res;
    }
}
