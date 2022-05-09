package TwoPointer;

public class sortColors {
    public void sort_Colors(int[] nums) {
        int j = 0;
        int n = nums.length;
        
        int zero = 0, one = 0, two = 0;
        for(int i : nums){
            if(i == 0) zero++;
            else if(i == 1) one++;
            else two++;
        }
        while(j < n && zero != 0){
            nums[j] = 0;
            j++;
            zero--;
        }
        while(j < n && one != 0){
            nums[j] = 1;
            j++;
            one--;
        }
        while(j < n && two != 0){
            nums[j] = 2;
            j++;
            two--;
        }
    }
}
