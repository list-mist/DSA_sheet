package Strings;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        return maxLen(s,k);
    }
    int maxLen(String s, int k){
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length(), res = 0;
        int maxChar = 0;
        while(j < n){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j))+1);
            }
            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), 1);
            }
            
            int window = j - i + 1;
            
            maxChar = Math.max(maxChar, map.get(s.charAt(j)));
        
            if(window - maxChar <= k){
                res = Math.max(res,window);
               
            }
            else if(window - maxChar > k){
                if(map.containsKey(s.charAt(i))){
                    int val = map.get(s.charAt(i));
                    if(val == 0){
                        map.remove(s.charAt(i));
                    }
                    else{
                        map.put(s.charAt(i), val - 1);
                    }
                    i++;
                }
  
            }
           j++;
        }
        return res;
    }
    // Time complexity -> O(N)
    // Space complexity -> O(K)
}
