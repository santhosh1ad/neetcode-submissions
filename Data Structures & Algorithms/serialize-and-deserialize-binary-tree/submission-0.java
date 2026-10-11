
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeDFS(root, list);
        return String.join(",", list);
    }

    public void serializeDFS(TreeNode r, List<String> list) {
        if (r == null) {
            list.add("N");
            return;
        }

        list.add(String.valueOf(r.val));
        serializeDFS(r.left, list);
        serializeDFS(r.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val = data.split(",");
        int[] ind = {0};
        return dfsDeserialize(val, ind);
    }

    public TreeNode dfsDeserialize(String[] val, int[] ind) {
        if (val[ind[0]].equals("N")) {
            ind[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val[ind[0]]));
        ind[0]++;

        node.left = dfsDeserialize(val, ind);
        node.right = dfsDeserialize(val, ind);

        return node;
    }
}
