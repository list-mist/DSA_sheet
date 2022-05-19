class Solution {
    public String simplifyPath(String path) {
       Stack<String> st = new Stack<>();
       String[] str = path.split("/");
       for(String s : str){
           if(s.equals(".") || s.equals("")) continue;
           if(s.equals("..")) {
               if(!st.isEmpty()) st.pop();
           }
           else{
               st.push(s);
           }
       }
       String res = "";
       for(String s : st){
           res += "/";
           res += s;
       }
       res = res.length() > 0 ? res : "/";
       return res;
    }
}
