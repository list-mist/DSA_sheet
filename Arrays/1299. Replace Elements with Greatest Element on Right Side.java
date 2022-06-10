class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
    
        int n = arr.length;
        int max = -1;
        for(int i = n - 2; i >= 0; i--){
            max = Math.max(max,arr[i+1]);
            
            res[i] = max;
        
        }
        res[n-1] = -1;
        return res;
    }
}
