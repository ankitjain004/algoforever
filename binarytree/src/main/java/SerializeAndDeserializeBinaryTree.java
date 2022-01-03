import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = "";
        return serializeUtils(root, ans);
    }

    public String serializeUtils(TreeNode root, String ans) {
        if (root == null) {
            ans = ans + "null,";
            return ans;
        } else {
            ans += String.valueOf(root.val) + ",";
            ans = serializeUtils(root.left, ans);
            ans = serializeUtils(root.right, ans);
        }

        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(s));
        return deserializeUtils(list);

    }

    public TreeNode deserializeUtils(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            node.left = deserializeUtils(list);
            node.right = deserializeUtils(list);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;