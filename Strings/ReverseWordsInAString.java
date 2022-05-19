class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        String[] strd = s.split(" ");
        for(String str : strd){
            if(str.equals("")) continue;
            st.push(str);
        }
        String res = "";
        while(!st.isEmpty()){
            res += st.pop()+" ";
        }
        return res.substring(0,res.length() -1);
    }
}
