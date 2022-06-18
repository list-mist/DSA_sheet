class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return fun(s, wordDict,0, s.length());
    }
    boolean fun(String s, List<String> wordDict, int start, int end){
        if(wordDict.contains(s)) return true;
        if(map.containsKey(s)) return map.get(s);
        boolean ans = false;
        for(int k = start + 1; k < end; k++){
            String s1 = s.substring(start,k);
            String s2 = s.substring(k,end);
            ans = ans || (fun(s1,wordDict, 0, s1.length()) && fun(s2,wordDict, 0, s2.length()));
        }
        map.put(s, ans);
        return ans;
    }
}
