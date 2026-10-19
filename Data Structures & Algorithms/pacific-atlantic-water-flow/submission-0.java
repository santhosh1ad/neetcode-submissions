
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] vis = new int[n][m];
        int[][] vis2 = new int[n][m];

        // Pacific: top row and left column
        for (int i = 0; i < n; i++) {
            Pdfs(heights, vis, i, 0, heights[i][0]);
        }

        for (int j = 0; j < m; j++) {
            Pdfs(heights, vis, 0, j, heights[0][j]);
        }

        // Atlantic: bottom row and right column
        for (int i = 0; i < n; i++) {
            Adfs(heights, vis2, i, m - 1, heights[i][m - 1]);
        }

        for (int j = 0; j < m; j++) {
            Adfs(heights, vis2, n - 1, j, heights[n - 1][j]);
        }

        // Cells reachable from both oceans
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 1 && vis2[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public void Pdfs(int[][] h, int[][] vis,
                     int i, int j, int prev) {
        if (i < 0 || i >= h.length ||
            j < 0 || j >= h[0].length ||
            vis[i][j] == 1 || h[i][j] < prev) {
            return;
        }

        vis[i][j] = 1;

        Pdfs(h, vis, i + 1, j, h[i][j]);
        Pdfs(h, vis, i - 1, j, h[i][j]);
        Pdfs(h, vis, i, j - 1, h[i][j]);
        Pdfs(h, vis, i, j + 1, h[i][j]);
    }

    public void Adfs(int[][] h, int[][] vis,
                     int i, int j, int prev) {
        if (i < 0 || i >= h.length ||
            j < 0 || j >= h[0].length ||
            vis[i][j] == 1 || h[i][j] < prev) {
            return;
        }

        vis[i][j] = 1;

        Adfs(h, vis, i + 1, j, h[i][j]);
        Adfs(h, vis, i - 1, j, h[i][j]);
        Adfs(h, vis, i, j - 1, h[i][j]);
        Adfs(h, vis, i, j + 1, h[i][j]);
    }
}
