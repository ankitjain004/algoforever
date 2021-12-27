public class ReverseGroupKAndRemaining {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode ptr = head;
        int count = 0;
        while (ptr != null && count < k) {
            ptr = ptr.next;
            count++;
        }

        if (count == k) {
            ListNode rev_head = reverseLinkedList(head, k);
            head.next = reverseKGroup(ptr, k);
            return rev_head;
        } else {
            // this block takes care fo reversing last chunk
            // if you just return head it will not reverse
            //return head;
            ListNode rev_head = reverseLinkedList(head, k);
            head.next = null;
            return rev_head;
        }
    }

    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null && k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }

}