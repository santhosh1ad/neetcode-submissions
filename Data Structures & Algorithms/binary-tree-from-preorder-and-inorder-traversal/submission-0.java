
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ind = 0;
        for (int i : inorder) {
            map.put(i, ind++);
        }

        return buildTree2(preorder, 0, preorder.length - 1,
                          inorder, 0, inorder.length - 1, map);
    }

    public TreeNode buildTree2(int[] pre, int preS, int preE,
                               int[] in, int inS, int inE,
                               HashMap<Integer, Integer> map) {

        if (preS > preE || inS > inE) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preS]);

        int left = map.get(pre[preS]);
        int tot = left - inS;

        root.left = buildTree2(pre, preS + 1, preS + tot,
                               in, inS, left - 1, map);

        root.right = buildTree2(pre, preS + tot + 1, preE,
                                in, left + 1, inE, map);

        return root;
    }
}
