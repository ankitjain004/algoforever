public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        //these 2 blocks are important, not required while maxDepth
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;


        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}