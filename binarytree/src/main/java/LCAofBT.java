/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class LCAofBT {
    static TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorUtils(root, p, q);
        return ans;

    }

    private int lowestCommonAncestorUtils(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int first = lowestCommonAncestorUtils(root.left, p, q);
        int second = lowestCommonAncestorUtils(root.right, p, q);
        int third = ((root.val == p.val) || (root.val == q.val)) ? 1 : 0;

        if (first + second + third >= 2) {
            ans = root; //very important, cant return directly from this method as its return type is null

        }

        return (first + second + third) > 0 ? 1 : 0;  // important

    }
}