package StackAndQueues;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        return decode(s);
    }
    String decode(String s){
        Stack<Character> st = new Stack<>();
        int n = s.length();
        String ans = "";
        char[] ch = s.toCharArray();
        for(int i = 0 ; i < n; i++){
            if(ch[i] != ']'){
                st.push(ch[i]);
            }
            else{
                String numbers = "";
                String character = "";
                while(st.peek() != '['){
                    character = String.valueOf(st.peek()) + character;
                    st.pop();
                }
                st.pop();
                
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    numbers = String.valueOf(st.peek()) + numbers;
                    st.pop();
                }
                      
                for(int k = 0; k < Integer.parseInt(numbers); k++){
                    for(int j = 0; j < character.length(); j++){
                        st.push((character.charAt(j)));
                    }
                }
            }
        }
                while(!st.isEmpty()){
                    ans = st.pop() + ans;
                }
        return ans;
    }
    // Time complexity -> O(N)
    // Space complexity -> O(N)
}
