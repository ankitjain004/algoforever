import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //1:12
        List<List<Integer>> ans = new ArrayList();
        levelOrderTraversal(root, ans);
        return ans;

    }

    public void levelOrderTraversal(TreeNode root, List<List<Integer>> ans) {

        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return;
        queue.offer(root);
        while (queue.size() > 0) {
            int n = queue.size();
            List<Integer> temp = new ArrayList();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                temp.add(curr.val);
            }
            ans.add(temp);
        }
    }
}