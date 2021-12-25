//@link{https://leetcode.com/problems/validate-binary-search-tree/}

/*Approach 1: Recursive Traversal with Valid Range
The idea above could be implemented as a recursion. One compares the node value with its upper and lower limits if they are available.
Then one repeats the same step recursively for left and right subtrees.*/
public class CheckBST {
    public boolean isValidBST(TreeNode root) {

        return isValidBSTUtils(root, null, null);

    }

    public boolean isValidBSTUtils(TreeNode root, Integer min, Integer max) //taking it as integer to handle cases when nodes value are itself integer.max or min
    {
        // Empty trees are valid BSTs.
        if (root == null) return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        // do not manipulate root.val with +1 and -1 . It failed in extreme test cases due to overflow
        return isValidBSTUtils(root.left, min, root.val) && isValidBSTUtils(root.right, root.val, max);


    }
}