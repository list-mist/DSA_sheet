class Solution {
    public String longestCommonPrefix(String[] strs) {
        String max = "";
        String ans = "";
        int i = 0, j = strs[0].length() , n = strs.length;
        while(i < n && j >= 0){
            ans = strs[0].substring(0,j);
            if(strs[i].startsWith(ans)){
                max = ans;
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }

}
