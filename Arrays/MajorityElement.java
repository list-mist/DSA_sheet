

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i) > n/2) return i;
        }
        return -1;
    }
    // Time complexity -> O(N)
    // Space complexity -> O(N)
    public int majorityElement_(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        if(n == 1) return nums[0];
        int count = 1;
        for(int i = 1; i < n; i++){
            while(i < n && nums[i-1] == nums[i]){
                count++;
                i++;
            }
            if(count > n/2) return nums[i-1];
        }
        return -1;
    }
    // Time complexity -> O(N) + O(nlogn)
    // Space complexity -> O(1)
}
