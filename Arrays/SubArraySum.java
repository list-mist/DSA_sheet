package Arrays;

import java.util.HashMap;

public class SubArraySum{
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,-1};
        int k = 5;

        System.out.println(subarraysDivByK(nums, k));
    }
    public static int subarraysDivByK(int[] nums, int k) {
        return count_subarray(nums,k);
    }
    static int count_subarray(int[] nums,int k){
        int[] prefix = new int[nums.length];
        int count = 0;
        prefix[0] = nums[0];
        for(int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < prefix.length; i++){
            int rem = prefix[i] % k;
            if(rem < 0) rem += k;
            if(map.containsKey(rem)){
                count +=  map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        return count;
    }
    // Time complexity -> O(n)
    // Space complexity -> O(n)
}
