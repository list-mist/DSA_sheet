class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int curr = Math.abs(nums[i]);
            if(nums[curr] < 0){
                ans = curr;
                break;
            }
            nums[curr] *= -1;
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }
        return ans;
    }
    
}
