class Solution {
    public int orangesRotting(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1)cnt++;
            }
        }

         if (cnt == 0)
            return 0;
        
        int[][] vis = new int[grid.length][grid[0].length];

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int min = 0;

        while(!q.isEmpty()) {
            int sz = q.size();

            for(int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                
                for(int[] j : dir) {
                    int x = cur[0] + j[0];
                    int y = cur[1] + j[1];
                    if(isValid(x, y, grid) && vis[x][y] == 0) {
                        vis[x][y] = 1;
                        q.add(new int[]{x, y});
                        cnt--;
                    }
                }
 
            }
            min++;
        }

        return cnt == 0 ? min - 1: -1;
    }
    public boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1;
    }
}