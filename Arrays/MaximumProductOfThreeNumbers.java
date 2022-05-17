class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1;
        int max = 0;
        max = nums[i] * nums[i-1] * nums[i-2];
        
        return Math.max(max, nums[0]*nums[1]*nums[i]);
    }
}
