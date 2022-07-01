class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int extraRocks) {
        
        for(int i = 0; i < rocks.length; i++){
            int diff = capacity[i] - rocks[i];
            rocks[i] = diff;
        }
        
        Arrays.sort(rocks);
        int cnt = 0;
        int i = 0;
        while(i < rocks.length && extraRocks > 0){
          
            int diff = rocks[i];
        
            extraRocks -= diff;
            if(extraRocks < 0) break;
            cnt++;
            
            i++;
        }
        return cnt;
    }
}
