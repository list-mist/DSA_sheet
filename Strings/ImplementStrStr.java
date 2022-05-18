class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0, n = haystack.length(), needLen = needle.length();
        int idx = -1;
        if(haystack.equals(needle)) return 0;
        while(i + needLen <= n){
            String str = haystack.substring(i,i + needLen);
            
            if(!str.equals(needle)) {
                i++;
               
            }
            else{
                return i;
            }
        }
        return idx;
    }
}
