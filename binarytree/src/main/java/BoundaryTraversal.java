/*@link {https://leetcode.com/problems/boundary-of-binary-tree/solution/}
Left Boundary: We keep on traversing the tree towards the left and keep on adding the nodes in the resres array,
provided the current node isn't a leaf node. If at any point, we can't find the left child of a node,
but its right child exists, we put the right child in the resres and continue the process.

Leaves - preorder

Right Boundary: We perform the same process as the left boundary. But, this time, we traverse towards the right.
If the right child doesn't exist, we move towards the left child. Also, instead of putting the traversed nodes in the resres array,
we push them over a stack during the traversal. After the complete traversal is done, we pop the element from over the stack
and append them to the resres array. The following animation depicts the process.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BoundaryTraversal {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> answer = new ArrayList();
        if (root == null) return answer;
        answer.add(root.val);
        if (root.left == null && root.right == null) {

            return answer;
        }
        List<Integer> left = new ArrayList();
        addLeftBoundary(root.left, left);

        answer.addAll(left);
        //leaf addition
        List<Integer> leaves = new ArrayList();
        addAllLeaves(root, leaves);
        answer.addAll(leaves);

        //right traversal
        List<Integer> right = new ArrayList();
        addRightBoundary(root.right, right);

        Collections.reverse(right);
        answer.addAll(right);


        return answer;


    }

    public void addRightBoundary(TreeNode node, List<Integer> right) {
        if (node == null) return;
        TreeNode temp = node;
        while (temp != null) {
            if (temp.left != null || temp.right != null)
                right.add(temp.val);
            if (temp.right != null) {
                temp = temp.right;
            } else if (temp.left != null) {
                temp = temp.left;
            } else
                break;
        }


    }

    public void addAllLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        addAllLeaves(root.left, leaves);
        addAllLeaves(root.right, leaves);

    }

    public void addLeftBoundary(TreeNode node, List<Integer> left) {
        TreeNode temp = node;
        while (temp != null) {
            if (temp.left != null) {
                left.add(temp.val);
                temp = temp.left;
            } else if (temp.right != null) {
                left.add(temp.val);
                temp = temp.right;
            } else
                break;
        }


    }
}