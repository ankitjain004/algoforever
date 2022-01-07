/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null || head == null) return true;
        ListNode firstHalfEnd = getSecondHalf(head);
        ListNode secondHalfStart = reverse(firstHalfEnd.next); //reverse the second half always smaller in case of odd elements
        boolean isPalindrome = true;
        ListNode first = head;
        ListNode second = secondHalfStart;
        while (second != null) { //as second always smaller
            if (first.val != second.val) {
                isPalindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }


        secondHalfStart = reverse(secondHalfStart);//maintaing the link back
        return isPalindrome;

    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode getSecondHalf(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow == null ? head : slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            return slow.next;  // 1 2 3  return 2
        else
            return slow; // 1 2 3 4 return 2
    }
}
