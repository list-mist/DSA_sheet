class Solution {
    public int removeDuplicates(int[] a) {
        int i = 0, j = 0;
        int n = a.length;
        int k = 1;
        while(j < n){
            if(a[i] == a[j]) j++;
            else{
                a[k++] = a[j];
                
                i = j;
                j++;
            }
        }
        return k;
    }
}
