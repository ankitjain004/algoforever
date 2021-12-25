//@link{https://www.youtube.com/watch?v=sWf7k1x9XR4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=39}
//@link{https://leetcode.com/problems/flatten-binary-tree-to-linked-list/}
class FlattenBTToLL {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        //think of it as reverse post order traversal right -> left -> node
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left =null;
        prev = root;
    }
}