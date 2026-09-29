class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode sub) {
        if (root == null) return false;

        if (isSameTree(root, sub)) {
            return true;
        }

        return dfs(root.left, sub) || dfs(root.right, sub);
    }

    public boolean isSameTree(TreeNode root, TreeNode sub) {
        if (root == null && sub == null) return true;
        if (root == null || sub == null) return false;

        if (root.val != sub.val) return false;

        return isSameTree(root.left, sub.left)
            && isSameTree(root.right, sub.right);
    }
}