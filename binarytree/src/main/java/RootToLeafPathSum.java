/*The most intuitive way is to use a recursion here. One is going through the tree by considering at each step the node itself
and its children. If node is not a leaf, one calls recursively hasPathSum method for its children
with a sum decreased by the current node value. If node is a leaf,
one checks if the the current sum is zero, i.e if the initial sum was discovered.*/

public class RootToLeafPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return hasPathSumUtils(root, targetSum);
    }

    public boolean hasPathSumUtils(TreeNode root, int targetSum) {

        if (root==null)
        {
            return false;
        }

        if(root.left == null  && root.right==null) return targetSum-root.val==0;

        return hasPathSumUtils(root.left, targetSum-root.val) || hasPathSumUtils(root.right, targetSum-root.val);


    }
}