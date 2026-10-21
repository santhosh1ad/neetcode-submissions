class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[]{k, 0});

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            Pair p = new Pair(times[i][1], times[i][2]);
            adj.get(times[i][0]).add(p);
        }

        int maxTime = 0;
        int[] vis = new int[n + 1];
        int count = 0;

        while (!pq.isEmpty()) {

            int[] nodes = pq.poll();

            int node = nodes[0];
            int time = nodes[1];

            if (vis[node] == 1) continue;

            vis[node] = 1;
            count++;

            maxTime = Math.max(maxTime, time);

            for (Pair nei : adj.get(node)) {
                if (vis[nei.node] == 0) {
                    pq.add(new int[]{
                        nei.node,
                        time + nei.time
                    });
                }
            }
        }

        return count == n ? maxTime : -1;
    }
}

class Pair {
    int node;
    int time;

    public Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public String toString() {
        return "node: " + node + " time: " + time;
    }
}