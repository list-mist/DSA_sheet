class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        
        int a = 0;
        for(int i : rolls) a += i;
        int sum = 0;
        int total = rolls.length + n;
        sum = (mean * total) - (a);
        if(sum < n || sum/n >6) return new int[0];
        
        Arrays.fill(res,sum/n);
        
        int t = sum % n ;
        if(t == 0) return res;
        
        for(int i = 0; i < n; i++){
            if(res[i] == 6) continue;
            if(res[i] + t <= 6){
                res[i] += t;
                return res;
            }
            else{
                res[i] += 1;
                t--;
            }
        }
        if(t != 0) return new int[0];
        return res;
        
    }
}
