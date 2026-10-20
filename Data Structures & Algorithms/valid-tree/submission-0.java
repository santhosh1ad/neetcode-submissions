class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] vis = new int[n];
        int[] par = new int[n];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if (!dfs(n, adj, vis, par, 0, -1)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) return false;
        }

        return true;
    }

    public boolean dfs(int n, List<List<Integer>> adj,
                       int[] vis, int[] par, int node, int prev) {
        if (vis[node] == 1) {
            return false;
        }

        vis[node] = 1;
        par[node] = prev;

        for (int nei : adj.get(node)) {
            if (nei == prev) continue;

            if (!dfs(n, adj, vis, par, nei, node)) {
                return false;
            }
        }

        return true;
    }
}