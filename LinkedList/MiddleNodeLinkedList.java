package LinkedList;

public class MiddleNodeLinkedList {
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    public ListNode middleNode(ListNode head) {
        int count = count_nodes(head);
        return get_node((count/2),head);
    }
    int count_nodes(ListNode head){
        int count = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        return count;
    }
    ListNode get_node(int idx,ListNode head){
        int count = 0;
        ListNode curr = head;
        while(curr!=null && count != idx){
            curr = curr.next;
            count++;
        }
        
        return curr;
    }

    // Time complexity -> O(N) + O(N/2) 
    // space complexity -> O(1)
}
