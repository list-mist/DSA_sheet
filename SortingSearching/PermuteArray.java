import java.util.Arrays;

public class PermuteArray {
    class Solution {
        public boolean isPossible(long a[], long b[], long n, long k) {
            Arrays.sort(a);
            Arrays.sort(b);
            
            int mod = (int)Math.pow(10,9)+7;
            k = k % mod;
            for(int i = 0, j = (int)n - 1; i <(int) n && j > -1; i++,j--){
                int sum = ((int) a[i] + (int)b[j]) % mod;
                if(sum < (int) k) return false;
            }
            return true;
        }
    }
}
