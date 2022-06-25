class Solution {
    public void reverseWords(char[] s) {
        
        int i = 0, n = s.length, j = n - 1;
        reverse(s,i,j);
        i = 0;
        j = 0;
        
        while(j < n){
            if(s[j] == ' ' && j > 0){
                int idx1 = i, idx2 = j - 1;
                
                reverse(s,idx1,idx2);
                 i = j + 1;
            }
            j++;
        }
        j = n - 1;
        reverse(s,i,j);
        
    }
    void reverse(char[] s, int i, int j){
        while(i < j){
            swap(s, i,j);
            i++;
            j--;
        }
    }
    void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
