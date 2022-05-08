package Arrays;


import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int[] ans = new int[2];
        for(int i = 0 ; i < nums.length; i++){
            int y = target - nums[i];
            
            if(map.containsKey(y)){
                ans[0] = i;
                ans[1] = map.get(y);
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
    // Time complexity -> O(N) 
    // Space complexity -> O(N)
}
