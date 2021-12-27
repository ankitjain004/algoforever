//@link{https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/}
/*Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that
every key of the original BST is changed to the original key
 plus the sum of all keys greater than the original key in BST.*/
public class BSTToGreaterSumTree {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    public void reverseInorder(TreeNode root) {

        if (root == null) return;
        reverseInorder(root.right);

        int temp = root.val;
        root.val = root.val + sum;
        sum = sum + temp;

        reverseInorder(root.left);
    }
}