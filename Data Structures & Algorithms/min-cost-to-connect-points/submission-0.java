
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        boolean[] visited = new boolean[n];

        // {cost, pointIndex}
        pq.offer(new int[]{0, 0});

        int ans = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {
            int[] curr = pq.poll();

            int cost = curr[0];
            int u = curr[1];

            if (visited[u]) continue;

            visited[u] = true;
            ans += cost;
            count++;

            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int distance =
                        Math.abs(points[u][0] - points[v][0]) +
                        Math.abs(points[u][1] - points[v][1]);

                    pq.offer(new int[]{distance, v});
                }
            }
        }

        return ans;
    }
}
