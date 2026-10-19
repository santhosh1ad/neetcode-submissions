class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // 1. Add all treasure cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        // 2. Perform BFS from all treasure cells
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check boundaries
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // Only visit empty rooms
                if (grid[nx][ny] != Integer.MAX_VALUE) {
                    continue;
                }

                
                grid[nx][ny] = grid[x][y] + 1;

                q.offer(new int[]{nx, ny});
            }
        }
    }
}