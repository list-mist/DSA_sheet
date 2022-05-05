package StackAndQueues;

import java.util.Stack;

public class ImplementQueueUsingStack {
    class MyQueue {
        Stack<Integer> st_1;
        Stack<Integer> st_2;
        int front = 0 ;
        public MyQueue() {
            st_1 = new Stack<>();
            st_2 = new Stack<>();
        }
        public void push(int x) {
            st_1.push(x);
        }
        private void convert(){
            while(!st_1.isEmpty()){
                st_2.push(st_1.pop());
            }
        }
        public int pop() {
           if(!st_2.isEmpty()) return st_2.pop();
           convert();
               
           return st_2.pop();
        }
        
        public int peek() {
           if(!st_2.isEmpty()) return st_2.peek();
           convert();
               
           return st_2.peek();
        }
        
        public boolean empty() {
            if(st_1.size() == 0 && st_2.size() == 0) return true;
            return false;
        }
    }
    // Time complexity -> push operation -> O(1) , pop and peek -> O(1) amortized
    // Space complexity -> O(N)
}
