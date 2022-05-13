class Solution {
    int mod = (int)Math.pow(10,9) + 7;
    public int knightDialer(int n) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        map.put(1,Arrays.asList(6,8));
        map.put(2,Arrays.asList(7,9));
        map.put(3,Arrays.asList(4,8));
        map.put(4,Arrays.asList(0,3,9));
        map.put(5,Arrays.asList());
        map.put(6,Arrays.asList(0,1,7));
        map.put(7,Arrays.asList(2,6));
        map.put(8,Arrays.asList(1,3));
        map.put(9,Arrays.asList(2,4));
        map.put(0,Arrays.asList(6,4));
        
        int[][] dp = new int[n][10];
        int count = 0;
        for(int i = 0; i <= 9; i++){
            count = count + (moves(map,n,String.valueOf(i),i,dp)) % mod;
            count = count % mod;
        }
        
        return count;
    }
    int moves(HashMap<Integer,List<Integer>> map,int n,String psf,int idx,int[][] dp){
        if(psf.length() == n) return 1;
        if(dp[psf.length()][idx] != 0) return dp[psf.length()][idx];
        int count = 0;
        for(int i = 0; i < map.get(idx).size(); i++){
            int path = map.get(idx).get(i);
            count = count + (moves(map,n,psf+path,path,dp)) % mod;
            
            count = count % mod;
        }
        return dp[psf.length()][idx] = count;
    }
}
