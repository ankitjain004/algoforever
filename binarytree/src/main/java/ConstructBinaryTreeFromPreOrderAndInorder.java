import java.util.HashMap;
// @link{https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/}
/*Approach 1: Recursion
Intuition

The two key observations are:

Preorder traversal follows Root -> Left -> Right, therefore, given the preorder array preorder, we have easy access to the root which is preorder[0].

Inorder traversal follows Left -> Root -> Right, therefore if we know the position of Root, we can recursively split the entire array into two subtrees.

Now the idea should be clear enough. We will design a recursion function: it will set the first element of preorder as the root, and then construct the entire tree. To find the left and right subtrees, it will look for the root in inorder, so that everything on the left should be the left subtree, and everything on the right should be the right subtree. Both subtrees can be constructed by making another recursion call.

It is worth noting that, while we recursively construct the subtrees, we should choose the next element in preorder to initialize as the new roots. This is because the current one has already been initialized to a parent node for the subtrees.*/
class ConstructBinaryTreeFromPreOrderAndInorder {
    static int preOrderIndex = 0;
    HashMap<Integer , Integer> inorderIndexMap = new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // this is important as your variable is static... For next test case it will start from prev test case
        //If you dont want to do this way then remove static and make it private
        preOrderIndex = 0;

        int n = preorder.length;
        for(int i=0;i<n;i++)
        {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildArrayToTree(preorder, 0, n-1);
    }

    public TreeNode buildArrayToTree(int[] preOrder, int start, int end)
    {
        if(start>end) return null;
        int curr = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(curr);

        root.left = buildArrayToTree(preOrder, start, inorderIndexMap.get(curr)-1);

        root.right = buildArrayToTree(preOrder, inorderIndexMap.get(curr)+1, end);
        return root;
    }
}
