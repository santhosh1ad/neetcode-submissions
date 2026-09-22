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
    public boolean isBalanced(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }
    public int dfs(TreeNode r) {
        if(r == null) return 0;

        int left = dfs(r.left);
        int right = dfs(r.right);

        if(left == -1 || right == -1)return -1;
        if(Math.abs(left - right) > 1)return -1;

        return Math.max(left, right) + 1;
    }
}