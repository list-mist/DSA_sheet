class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        if(t.length() > s.length()) return "";
        
        HashMap<String,Integer> tMap = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
           tMap.put(t.substring(i,i+1),tMap.getOrDefault(t.substring(i,i+1),0)+1);
           
        }
        HashMap<String,Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        String res = ""; int max = Integer.MAX_VALUE;
        int cnt = 0, m = t.length();
        while(j < n){
            if(tMap.containsKey(s.substring(j,j+1))){
                int tVal = tMap.get(s.substring(j,j+1));
                int val = map.getOrDefault(s.substring(j,j+1),0);
                if(tVal == 1){
                    if(val == 0) cnt++;
                }
                else{
                    if(val < tVal) cnt++;
                } 
                map.put(s.substring(j,j+1), val+1);
            }
           
            if(cnt == m){
             
                while(cnt == m){
                    int val = map.getOrDefault(s.substring(i,i+1),0);
                    if(val > 0){
                        int tVal = tMap.get(s.substring(i,i+1));
                        if(tVal == 1)
                        {
                            if(val == 1) cnt--;
                        }
                        else{
                            if(tVal >= val) cnt--;
                        }
                        map.put(s.substring(i,i+1),val-1);
    
                    }
            
                    if(max > j - i + 1){
                        max = j - i + 1;
                        res = s.substring(i,j+1);
                    }
                    i++;
                }
            }
            j++;
        }
        return res;
    }
    
}
