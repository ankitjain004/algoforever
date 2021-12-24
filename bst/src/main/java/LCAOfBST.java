/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/*Algorithm

Start traversing the tree from the root node.
If both the nodes p and q are in the right subtree, then continue the search with right subtree starting step 1.
If both the nodes p and q are in the left subtree, then continue the search with left subtree starting step 1.
If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees. and hence we return this common node as the LCA.*/

class LCAOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            int rootVal = root.val;
            int first = p.val;
            int second = q.val;
            if (rootVal > first && rootVal > second)
                root = root.left;
            else if (rootVal < first && rootVal < second)
                root = root.right;
            else
                return root;
        }
        return null;

    }

    public TreeNode lowestCommonAncestorUsingRecursion(TreeNode root, TreeNode p, TreeNode q) {
        //using recursion
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}