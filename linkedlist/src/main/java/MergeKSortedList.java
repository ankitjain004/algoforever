import java.util.PriorityQueue;

class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode ans = mergeList(lists, 0,n-1);
        return ans;
    }

    public ListNode mergeList(ListNode[] lists, int start, int end)
    {
        if(start>end)
            return null;

        ListNode second = mergeList(lists, start+1, end); //trust the function that it will merge with given start index till end
        ListNode first = lists[start];

        return merge(first, second); //merge both and chill
    }

    public ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(head1!=null && head2!=null)
        {
            if(head1.val<head2.val)
            {
                dummy.next = head1;
                dummy = dummy.next;
                head1= head1.next;
            }
            else
            {
                dummy.next = head2;
                dummy = dummy.next;
                head2 = head2.next;
            }
        }

        if(head1!=null && head2 == null)
            dummy.next = head1;
        else if(head1==null && head2!=null)
            dummy.next = head2;

        return temp.next;

    }
}
