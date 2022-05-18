class Solution {
    public void sortColors(int[] nums) {
        int countZero = 0, countOne = 0;
        for(int ele : nums){
            if(ele == 0) countZero++;
            if(ele == 1) countOne++;

        }
        for(int i = 0; i < nums.length; i++){
            while(countZero != 0){
                nums[i] = 0;
                i++;
                countZero--;
            }
            while(countOne != 0){
                nums[i] = 1;
                i++;
                countOne--;
            }
            if(i < nums.length) nums[i] = 2;
        }
    }
}
