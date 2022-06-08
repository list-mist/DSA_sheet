class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, curr = 0, max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            curr += nums[i];
            max = Math.max(curr,max);
            if(curr < 0){
                curr = 0;
            }
            
        }
        return max;
    }
}
