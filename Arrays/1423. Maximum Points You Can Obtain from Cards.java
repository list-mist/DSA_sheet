class Solution {
    public int maxScore(int[] card, int k) {
        int n = card.length;
        
        int[] res = new int[2 * k + 1];
        int idx = 0;
        for(int i = n - k; i < n; i++) res[idx++] = card[i];
        for(int i = 0; i < k ; i++) res[idx++] = card[i];
        
        int sum = sumWindow(res,res.length,k);
        return sum;
    }
     int sumWindow(int[] a, int n, int k){
         int maxSum = 0;
         int i = 0, j = 0;
         int sum = 0;
         while(j < n){
             sum += a[j];
             
             if(j - i + 1 <= k) j++;
             else{
                 if(j - i + 1 >= k){
                     sum -= a[i];
                     i++;
                     j++;
                 }
             }
             maxSum = Math.max(maxSum,sum);
         }
         return maxSum;
     }
}
