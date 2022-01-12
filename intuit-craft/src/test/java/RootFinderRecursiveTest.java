import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

class RootFinderRecursiveTest {

    @Test
    public void testNewRoots()
    {
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

        //calling method to return new roots
        RootFinderRecursive rootFinderRecursive = new RootFinderRecursive();
        Vector<Integer> rootsAfterRemovalOfGivenNode = rootFinderRecursive.findNewRootsIdAfterRemovalOfGivenNode(root, 2);
        Collections.sort(rootsAfterRemovalOfGivenNode);

        //preparing expected solution
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,4,5));
        Vector<Integer> vector = new Vector<Integer>(expected);
        Collections.sort(expected);
        Assertions.assertEquals(vector,rootsAfterRemovalOfGivenNode);
    }

}