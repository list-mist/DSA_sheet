package Strings;

import java.util.HashMap;

public class MaximizeTheConfusionOfExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return maxLen(answerKey,k);
    }
    int maxLen(String ans, int k){
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0, n = ans.length();
        
        int res = 0;
        int maxSimilarChar = 0;
        while(j < n){
            if(map.containsKey(ans.charAt(j))){
                map.put(ans.charAt(j), map.get(ans.charAt(j))+1);
            }
            if(!map.containsKey(ans.charAt(j))){
                map.put(ans.charAt(j), 1);
            }
            
            int window = j - i + 1;
            maxSimilarChar = Math.max(maxSimilarChar,map.get(ans.charAt(j)));
            
            if(window - maxSimilarChar <= k){
                res = Math.max(res, window);
            }
            else if(window - maxSimilarChar > k){
                if(map.containsKey(ans.charAt(i))){
                    int val = map.get(ans.charAt(i));
                    
                    if(val == 0){
                        map.remove(ans.charAt(i));
                    }
                    else{
                        map.put(ans.charAt(i), val - 1);
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
