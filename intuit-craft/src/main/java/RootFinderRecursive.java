import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RootFinderRecursive {
    static Vector<Integer> solution = new Vector<>();
    public Node findRoots(Node root, int nodeIdToRemove)
    {
        if(root==null) return null;
        root.left = findRoots(root.left, nodeIdToRemove);
        root.right = findRoots(root.right, nodeIdToRemove);

        if(root.id == nodeIdToRemove)
        {
            if(root.left!=null) solution.add(root.left.id);
            if(root.right!=null) solution.add(root.right.id);
            return null;
        }
        return root;
    }

    public Vector<Integer> findNewRootsIdAfterRemovalOfGivenNode(Node root, int nodeIdToRemove)
    {
        RootFinderRecursive rootFinderRecursive = new RootFinderRecursive();
        rootFinderRecursive.findRoots(root, nodeIdToRemove);
        if(root.id != nodeIdToRemove) solution.add(root.id);
        return solution;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;
        node6.left = node7;


        int nodeIdToRemove = 2;
        RootFinderRecursive rootFinderRecursive = new RootFinderRecursive();
        Vector<Integer> rootsAfterNodeRemoval = rootFinderRecursive.findNewRootsIdAfterRemovalOfGivenNode(root, nodeIdToRemove);
        System.out.println("New roots after removal of given node is "+ rootsAfterNodeRemoval);

    }


}
