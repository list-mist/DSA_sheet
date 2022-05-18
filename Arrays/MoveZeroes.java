class Solution {
    public void moveZeroes(int[] a) {
        int i = 0, j = 0, n = a.length;
        
        while(j < n){
            if(a[j] == 0) j++;
            else{
                a[i] = a[j];
                i++;
                j++;
            }
        }
        while(i < n) {
            a[i] = 0;
            i++;
        }
    }
}
