class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)adj.add(new ArrayList<>());

        for(int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        

        int ans =0;

        for(int i = 0; i < n; i++) {
            if(vis[i] != 1) {
                ans++;
                dfs(i, adj, vis);
            }
        }

        return ans;
    }
    public void dfs(int node, List<List<Integer>> adj, int[] vis) {
        if(vis[node] == 1)return;

        vis[node] = 1;

        for(int nei : adj.get(node)) dfs(nei, adj, vis);

        return;
    }
}
