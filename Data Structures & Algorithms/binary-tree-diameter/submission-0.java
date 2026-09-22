/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return d - 1;
    }
    public int dfs(TreeNode r) {
        if(r == null)return 0;
        int left = dfs(r.left);
        int right = dfs(r.right);

        d = Math.max(left + right + 1, d);

        return Math.max(left, right) + 1;
    }
}
