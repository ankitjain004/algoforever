/*Problem Description
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.*/

/*Algorithm

Initialize a function dfs, as well as a variable numGoodNodes that keeps track of how many good nodes are in the tree. The function should take two arguments: a node node, and an integer representing the greatest value in the path leading from the root to the current node maxSoFar.

For each call to the function, first check if maxSoFar <= node.val. If so, increment numGoodNodes. Next, call dfs(child, max(node.val, maxSoFar)) for all children of the current node.

Call dfs(root, INT_MIN) and return numGoodNodes.*/

class CountGoodNodes {
    static int count = 0;

    public int goodNodes(TreeNode root) {
        goodNodesUtil(root, Integer.MIN_VALUE);
        return count;
    }
    public void goodNodesUtil(TreeNode root, int currMax) {
        if (root.val >= currMax) {
            count++;
            currMax = root.val;
        }
        if (root.left != null) {
            goodNodesUtil(root.left, currMax);
        }
        if (root.right != null) {
            goodNodesUtil(root.right, currMax);
        }
    }
}