/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Height
{
    int height;
}
class DiameterOfBinaryTreeOptimized {
    public int diameterOfBinaryTree(TreeNode root) {
        Height height = new Height();

        int ans = diameterOpt(root, height);
        return ans-1;

    }

    int diameterOpt(TreeNode root, Height height)
    {
        if(root==null)
        {
            height.height = 0;
            return 0;
        }
        Height lh = new Height();
        Height rh = new Height();
        int leftDiameter = diameterOpt(root.left, lh);
        int rightDiameter = diameterOpt(root.right, rh);

        height.height = Math.max(lh.height,rh.height)+1;

        return Math.max(leftDiameter, Math.max(rightDiameter, lh.height+rh.height+1));
    }
}