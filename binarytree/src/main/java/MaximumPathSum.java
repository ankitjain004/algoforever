// @link{https://leetcode.com/problems/binary-tree-maximum-path-sum/solution/}

/*Algorithm

Now everything is ready to write down an algorithm.

Initiate max_sum as the smallest possible integer and call max_gain(node = root).
Implement max_gain(node) with a check to continue the old path/to start a new path:
Base case : if node is null, the max gain is 0.
Call max_gain recursively for the node children to compute max gain from the left and right subtrees : left_gain = max(max_gain(node.left), 0) and
right_gain = max(max_gain(node.right), 0).
Now check to continue the old path or to start a new path. To start a new path would cost price_newpath = node.val + left_gain + right_gain. Update max_sum if it's better to start a new path.
For the recursion return the max gain the node and one/zero of its subtrees could add to the current path : node.val + max(left_gain, right_gain).*/

public class MaximumPathSum {
    private int maxSum = Integer.MIN_VALUE; // very Imp as initilaizing with 0 will give wrong answer with all negative nodes

    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxSum;

    }

    public int maxPathSumUtil(TreeNode root) {

        if (root == null) {
            return 0;
        }
        else {
            int lSum = Math.max(maxPathSumUtil(root.left), 0);
            int rSum = Math.max(maxPathSumUtil(root.right), 0);
            maxSum = Math.max(maxSum, lSum + rSum + root.val); // if this node is where the max path is and it is the turning node
            int currMax = Math.max(lSum, rSum);
            return currMax + root.val; // return the max of 2 if there is 1 path going from here
        }


    }
}
