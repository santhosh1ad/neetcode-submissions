class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] != 1 && grid[i][j] == '1') {
                    dfs(grid, vis, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int[][] vis, int i, int j) {
         if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || vis[i][j] == 1)return;

         vis[i][j] = 1;
         dfs(grid, vis, i + 1, j);
         dfs(grid, vis, i - 1, j);
         dfs(grid, vis, i, j + 1);
         dfs(grid, vis, i, j - 1);
         return;
    }
}
