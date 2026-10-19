class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int ans = 0;
        int[] res = {0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] != 1 && grid[i][j] == 1) {
                    dfs(grid, vis, i, j, res);
                    ans = Math.max(ans, res[0]);
                    res[0] = 0;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid, int[][] vis, int i, int j, int[] res) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0
            || vis[i][j] == 1)
            return;

        vis[i][j] = 1;
        res[0]++;
        dfs(grid, vis, i + 1, j, res);
        dfs(grid, vis, i - 1, j, res);
        dfs(grid, vis, i, j + 1, res);
        dfs(grid, vis, i, j - 1, res);
        return;
    }
}

