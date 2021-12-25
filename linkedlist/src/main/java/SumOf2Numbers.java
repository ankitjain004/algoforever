//@link{https://leetcode.com/explore/interview/card/microsoft/32/linked-list/205/}
/*You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/
/*Input: l1 = [7,2,4,3], l2 = [5,6,4]
        Output: [7,8,0,7]*/
public class SumOf2Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = reverse(l1);
        ListNode second = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode temp =dummy;
        int carry = 0;
        while(first!=null || second!=null)
        {
            int val1 = first==null?0:first.val; // this is because we are using OR operator in while loop
            int val2 = second==null?0:second.val;
            int finalVal = val1 + val2 + carry;
            carry = finalVal/10;
            temp.next = new ListNode(finalVal%10);
            temp = temp.next;
            if(first!=null) first = first.next;
            if(second!=null) second = second.next;
        }

        if(carry>0)
        {
            temp.next = new ListNode(carry); //important I had missed it
            temp = temp.next;
        }

        ListNode ans = reverse(dummy.next);
        return ans;

    }


    public ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev=null;
        ListNode next =null;
        while(curr!=null)
        {
            next =curr.next;
            curr.next = prev;
            prev=curr;
            curr = next;
        }
        return prev;
    }
}