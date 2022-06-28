class Solution {
    public int minimumDeletions(int[] nums) {
        
        int minId = 0, maxId = 0;
        
        int max = nums[0], min = nums[0];
        int n = nums.length;
        if(n == 1) return 1;
        for(int i = 0; i < n; i++){
            if(max < nums[i]){
                max = nums[i];
                maxId = i;
            }
            if(min > nums[i]){
                min = nums[i];
                minId = i;
            }
        }
        int minIdx = Math.min(minId, maxId);
        int maxIdx = Math.max(minId, maxId);
        int interval1 = minIdx + 1 + n - maxIdx;

        int interval2 = n - minIdx;
        int interval3 = maxIdx + 1;

        int ans = Math.min(Math.min(interval1,interval2), interval3);
        return ans;
    }
}
