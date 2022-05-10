package Strings;

import java.util.Collections;
import java.util.HashMap;

public class LongestSubWithAtMostKChar {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        return maxLength(s,k);
    }
    int maxLength(String s, int k){
        if(k == 0 || s.length() == 0) return 0;
        
        int i = 0, j = 0, n = s.length();
     
        HashMap<Character,Integer> map = new HashMap<>();
        int max_ans = 1;

        while(j < n){

            map.put(s.charAt(j), j);
        
            if(map.size() == k + 1){
              
                int val = Collections.min(map.values());
                map.remove(s.charAt(val));
                i = val + 1;
            }
            max_ans = Math.max(max_ans, j - i + 1 );
            j++;
        }
        return max_ans;
    }
}
