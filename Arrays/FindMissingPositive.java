class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        
        int res = 1;
        for(int i = 0; i < nums.length; i++){
            if(res == nums[i]) res++;
            else if(nums[i] > res) return res;
        }
        return res;
    }
}
