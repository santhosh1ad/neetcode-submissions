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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return ans;
    }
    public void helper(TreeNode root, int prev) {
        if(root == null)return;

        if(root.val >= prev) {
            
            ans++;
        }

        helper(root.left, Math.max(root.val, prev));
        helper(root.right, Math.max(root.val, prev));
    }
}
