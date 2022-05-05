package LinkedList;

import java.util.HashMap;

public class LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class Solution {
        public boolean hasCycle(ListNode head) {
           HashMap<ListNode,Boolean> map = new HashMap<>();
           ListNode curr = head;
            
           while(curr != null){
               if(map.containsKey(curr)) return true;
               map.put(curr,true);
               
               curr = curr.next;
           }
           return false;
        }
    } 
    // Time complexity -> O(N) 
    // space complexity -> O(N)
    boolean has_cycle(ListNode head){
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    // Time complexity -> O(N/2) 
    // space complexity -> O(1)
}
