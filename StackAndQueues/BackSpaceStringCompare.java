package StackAndQueues;

import java.util.Stack;

public class BackSpaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        s = convert(s);
        t = convert(t);
        
        if(s.equals(t)) return true;
        return false;
    }
    String convert(String s){
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch != '#'){
                st.push(ch);
            }
            else if(!st.isEmpty()){
                st.pop();
            }
        }
        String ans = "";
        
        while(!st.isEmpty()){
            ans += String.valueOf(st.pop());
        }
        
        return ans;
    }
    // Time complexity -> O(N)
    // Space complexity -> O(N)

}
