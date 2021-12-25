import java.util.ArrayList;
import java.util.List;

//@link{https://leetcode.com/problems/path-sum-ii/solution/}

/*Intuition

The intuition for this approach is pretty straightforward. The problem statement asks us to
find all root to leaf paths in a given binary tree. If you simply consider the depth first traversal on a tree,
 all it does is traverse once branch after another. All we need to do here is to simply execute
 the depth first traversal and maintain two things along the way:

A running sum of all the nodes traversed till that point in recursion and
A list of all those nodes
If ever the sum becomes equal to the required sum, and the node where this happens is a leaf node,
we can simply add the list of nodes to our final solution. We keep on doing this for every branch of the tree and
we will get all the root to leaf paths in this manner that add up to a certain value. Basically, these paths are
branches and hence the depth first traversal makes the most sense here. We can also use the breadth first approach for solving this problem.
However, that would be super heavy on memory and is not a recommended approach for this very problem.
 We will look into more details towards the end.*/


public class StoreAllValidRootToLeafPathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList();
        List<Integer> temp = new ArrayList();
        haspathSum(root, targetSum, answer, temp);
        return answer;

    }

    public void haspathSum(TreeNode root, int targetSum, List<List<Integer>> answer, List<Integer> temp) {
        if (root == null)
            return;


        targetSum = targetSum - root.val;
        temp.add(root.val);
        if (targetSum == 0 && root.left == null && root.right == null) {
            answer.add(new ArrayList(temp));
        }

        haspathSum(root.left, targetSum, answer, temp);
        haspathSum(root.right, targetSum, answer, temp);

        temp.remove(temp.size() - 1);
    }
}