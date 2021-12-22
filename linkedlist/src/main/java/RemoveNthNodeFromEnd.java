class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 1 2 3 4 5 6 7 8 9 10
        // 3rd node from end
        //fast pointer at nth node from start slow at before head
        //stop when fast.next == null

        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i< n; i++) fast = fast.next;
        // 1 2 3  -> n=3
        // handle scenario when first node needs to be removed
        if(fast==null) return head.next;

        while(fast.next!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;

    }
}