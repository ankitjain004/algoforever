/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 *//*

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> nodeToBeDeletedSet = new HashSet<>();
        for (int val : to_delete) {
            nodeToBeDeletedSet.add(val);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> solution = new HashSet<>();

        queue.offer(root);
        solution.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (nodeToBeDeletedSet.contains(node.val)) {
                solution.remove(node);
                if (node.left != null) {
                    solution.add(node.left);
                }

                if (node.right != null) {
                    solution.add(node.right);
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
                if (nodeToBeDeletedSet.contains(node.left.val)) {
                    node.left = null;
                }
            }
            if (node.right != null) {
                queue.offer(node.right);
                if (nodeToBeDeletedSet.contains(node.right.val)) {
                    node.right = null;
                }
            }
        }
        return new ArrayList<>(solution);

    }
}

class RecursiveSolution {
    Set<Integer> toBeDeletedSet = new HashSet<>();
    List<TreeNode> solution = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i = 0; i < to_delete.length; i++) {
            toBeDeletedSet.add(to_delete[i]);
        }
        delete(root, toBeDeletedSet);

        if (!toBeDeletedSet.contains(root.val)) {
            solution.add(root);
        }
        return solution;
    }

    public TreeNode delete(TreeNode root, Set<Integer> toBeDeletedSet) {
        if (root == null) return null;
        root.left = delete(root.left, toBeDeletedSet);
        root.right = delete(root.right, toBeDeletedSet);

        if (toBeDeletedSet.contains(root.val)) {
            if (root.left != null) solution.add(root.left);
            if (root.right != null) solution.add(root.right);
            return null;
        }
        return root;
    }
}*/
