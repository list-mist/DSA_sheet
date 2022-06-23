class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
    ListNode merge(ListNode left, ListNode right){
        ListNode l1 = left;
        ListNode l2 = right;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        while(l1 != null){
            curr.next = new ListNode(l1.val);
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2 != null){
            curr.next = new ListNode(l2.val);
            curr = curr.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
    ListNode sort(ListNode head){
        if (head == null || head.next == null) return head;
        
        ListNode mid = getMid_(head);
        ListNode left = sort(head);
        ListNode right = sort(mid);
        return merge(left, right);
    }
    ListNode getMid_(ListNode head){
        ListNode slow = head, fast = head;
        ListNode prev = null;
    // iterate until fast is at last node or become null
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if(prev == null){
            prev = head;
        }else{
            prev = prev.next;
        }
    }
       prev.next = null;
       return slow;
    } 
}
