import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList();
        if (root == null) return null;
        queue.add(root);
        while (queue.size() > 0) {
            int n = queue.size();
            Node prev = null; // it should be outside the loop so that it is null just first time
            for (int i = 0; i < n; i++) {
                Node curr = queue.poll();
                if (prev != null) {
                    prev.next = curr;

                }
                prev = curr;  // we should assign prev as curr for the 2nd node
                //special handling for last node
                if (i == n - 1) {
                    curr.next = null;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }
}