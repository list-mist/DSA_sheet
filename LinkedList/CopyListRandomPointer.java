package LinkedList;

import java.util.HashMap;

public class CopyListRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        return copyList(head);
    }
    Node copyList(Node head){
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head, t = head;
        while(curr != null){
            Node curr_new = new Node(curr.val);
            map.put(curr,curr_new);
            curr = curr.next;
        }
        Node ans = null;
        while(t != null){
           ans = map.get(t);
           ans.next = map.get(t.next);
           ans.random = map.get(t.random);  
           map.put(t,ans);
           t = t.next;
        }
        return map.get(head);
        
    }

    // Time complexity -> O(N) 
    // space complexity -> O(N) 
}
