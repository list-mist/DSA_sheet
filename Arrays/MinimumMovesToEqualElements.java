class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            moves += nums[i] - nums[0];
        }
        return moves;
    }
}
