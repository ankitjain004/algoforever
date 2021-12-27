//@link{https://leetcode.com/problems/symmetric-tree/solution/}
public class SymmetricBT {
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right!=null) return false;
        if(root.right == null && root.left!=null) return false;
        return checkIsSymmetric(root.left, root.right);
    }

    public boolean checkIsSymmetric(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2 == null ) return true;
        if(root1==null || root2==null) return false;

        if(root1.val == root2.val && checkIsSymmetric(root1.left, root2.right) &&
                checkIsSymmetric(root1.right, root2.left) ) return true;
        return false;
    }
}