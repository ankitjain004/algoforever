public class SwapKthNodeValueFormBeginningAndEnd {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode first = null;
        for (int i = 1; i < k; i++) {
            if (curr != null)
                curr = curr.next;
        }
        first = curr; //kth node
        ListNode fast = curr.next; //to make gap of k as slow will start from 1
        ListNode slow = head;
        //k+1th node from last we have to find
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode second = slow; //important
        //swapping the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;


    }
}