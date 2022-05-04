package Arrays;

import java.util.HashMap;

public class SubArraySumDiviibleK {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
    static int subarraySum(int[] nums, int k) {
        return count_subarray(nums,k);
    }
    static int count_subarray(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int currSum = 0;
        for(int i = 0 ; i < nums.length; i++){
            currSum += nums[i];
            int diff = currSum - k;
            if(currSum == k) count++;
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return count;
    }

    // Time complexity -> O(n)
    // Space complexity -> O(n)
}
