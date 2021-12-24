import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList();
        if (root == null) return answer;
        executeXigzagLevelOrder(root, answer);
        return answer;

    }

    public void executeXigzagLevelOrder(TreeNode root, List<List<Integer>> answer) {
        LinkedList<Integer> levelList = new LinkedList();
        LinkedList<TreeNode> node_queue = new LinkedList();
        boolean isOrderLeft = true;

        node_queue.addLast(root);
        node_queue.addLast(null);

        while (node_queue.size() > 0) {
            TreeNode curr = node_queue.pollFirst();  // add this to level_list and its children to deque

            if (curr != null) {

                if (isOrderLeft) {
                    levelList.addLast(curr.val);
                } else {
                    levelList.addFirst(curr.val);
                }


                if (curr.left != null)
                    node_queue.addLast(curr.left);
                if (curr.right != null)
                    node_queue.addLast(curr.right);
            } else {

                answer.add(levelList);
                levelList = new LinkedList();
                if (node_queue.size() > 0)  //important else you will get stuck in a while loop
                    node_queue.addLast(null);
                isOrderLeft = !isOrderLeft;
            }
        }

    }
}