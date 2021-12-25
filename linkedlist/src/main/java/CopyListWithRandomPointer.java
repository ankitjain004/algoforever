// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node start = head;
        Node curr = head;
        //copy is created here
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }

        //adjust the random pointer

        while (start != null) {
            if (start.random != null)
                start.next.random = start.random.next;
            start = start.next.next;
        }

        //break the link
        Node dummy = new Node(0);
        Node temp = dummy;
        start = head;
        while (start != null) {
            dummy.next = start.next;
            start.next = start.next.next;
            start = start.next;
            dummy = dummy.next;
        }

        return temp.next;
    }
}

