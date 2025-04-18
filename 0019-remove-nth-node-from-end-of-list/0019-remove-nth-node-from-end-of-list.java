class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        int counter = 1;
        while(fast.next != null){                              
            fast = fast.next;       
            if(counter >= n){
                prev = slow;
                slow = slow.next;
            }                   
            counter++;         
        }
        if(fast.next == null){            
            if(head.next == null && n == 1){
                head = null;
            }
            if(slow == prev){
                return slow.next;
            }
            prev.next = slow.next;      
        }
        return head;        
    }
}