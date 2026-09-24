/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
    public TreeNode dfs(TreeNode r, TreeNode p, TreeNode q) {
        if(r == null)return null;

        if(r == p || r == q)return r;

        TreeNode left = dfs(r.left, p, q);
        TreeNode right = dfs(r.right, p, q);


        if(left != null && right != null)return r;

        if(left != null)return left;
        if(right != null)return right;

        return null;
    }
}