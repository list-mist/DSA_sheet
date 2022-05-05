package LinkedList;

public class RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    ListNode delete(ListNode head){
        if(head.next == null || head == null) return head;
        ListNode head1 = delete(head.next);
        if(head1.val == head.val) return head1;
        head.next = head1;
        return head;
    }
    // Time complexity -> O(N) 
    // space complexity -> O(1) 
}
