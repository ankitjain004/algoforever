import java.util.*;

public class RootFinderIterative {
    boolean isValidNodeEntered = false;
    public ArrayList<Node> findRoots(Node root, int nodeToBeRemoved)
    {
        Set<Node> solution = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        solution.add(root);
        while (!queue.isEmpty())
        {
            Node node = queue.poll();
            if(node.id == nodeToBeRemoved)
            {
                solution.remove(node);
                if(node.left!=null)
                {
                    solution.add(node.left);
                }
                if(node.right!=null)
                {
                    solution.add(node.right);
                }
            }

            if(node.left!=null)
            {
                queue.offer(node.left);
                if(node.left.id==nodeToBeRemoved)
                {
                    node.left = null;
                }
            }

            if(node.right!=null)
            {
                queue.offer(node.right);
                if(node.right.id==nodeToBeRemoved)
                {
                    node.right = null;
                }
            }
        }
        return new ArrayList<>(solution);
    }

    public Vector<Integer> findNewRootsIdAfterRemovalOfGivenNode(Node root, int nodeToBeRemoved)
    {
        ArrayList<Node> roots = findRoots(root, nodeToBeRemoved);
        Vector<Integer> solution = new Vector<Integer>();
        for(Node node : roots)
        {
            solution.add(node.id);
        }
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


        RootFinderIterative rootFinderIterative = new RootFinderIterative();
        Vector<Integer> rootsAfterRemovalOfGivenNode = rootFinderIterative.findNewRootsIdAfterRemovalOfGivenNode(root, 2);
        System.out.println("New roots after removal of given node is "+ rootsAfterRemovalOfGivenNode);
    }
}

/*
Extensions:
1. Check if given node to be removed is valid
Edge cases
1. Only root node is there and we pass it for removal
2. We try to remove one of the leaf nodes
*/

