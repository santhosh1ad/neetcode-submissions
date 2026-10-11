class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         dfs(root);
         return ans;
    }
    public int dfs(TreeNode r) {
        if(r == null)return 0;

        int left = Math.max(0, dfs(r.left));
        int right= Math.max(0, dfs(r.right));

        int mxSum = Math.max(left , right) + r.val;

        ans = Math.max(ans, left + right + r.val);

        return mxSum;
    }
}
