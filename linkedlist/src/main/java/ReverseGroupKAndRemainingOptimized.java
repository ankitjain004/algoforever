public class ReverseGroupKAndRemainingOptimized {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;
        ListNode newHead = null;
        ListNode rev_head = null;
        while (ptr != null) {
            ptr = head;
            int count = 0;
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }

            if (count == k) {
                rev_head = reverseLinkedList(head, k);
                if (newHead == null)
                    newHead = rev_head;
                if (ktail != null)
                    ktail.next = rev_head;
                ktail = head;
                head = ptr;
            }

        }
        if (ktail != null)
            ktail.next = head;  // ktail.next = reverseLinkedList(head, k); will also reverse the last chunk
        //imprtant point here is you need to pass the head
        return newHead == null ? head : newHead;
    }


    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

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