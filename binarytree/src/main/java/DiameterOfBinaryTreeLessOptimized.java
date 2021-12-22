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
class DiameterOfBinaryTreeLessOptimized {
    public int diameterOfBinaryTree(TreeNode root) {
        int ans = diameter(root);
        if (ans == 0) return 0;
        return ans - 1;
    }

    public int diameter(TreeNode root) {
        if (root == null) return 0;

        return Integer.max(1 + height(root.left) + height(root.right), Math.max(diameter(root.left), diameter(root.right)));
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}