class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU ds = new DSU(n);
        int[] ans = new int[2];

        for(int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if(ds.findParent(u) != ds.findParent(v)) {
                ds.unionByRank(u, v);
            } else {
                return new int[]{u, v};
            }
        }

        return new int[]{};
    }
}

class DSU {
    int[] parent;
    int[] rank;
    int[] size;

    DSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
    }

    int findParent(int x) {
        if (x == parent[x]) return x;

        return parent[x] = findParent(parent[x]);
    }

    void unionBySize(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);

        if (px == py) return;

        if (size[px] < size[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
    }

    void unionByRank(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);

        if (px == py) return;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] == rank[py]) {
            parent[py] = px;
            rank[px]++;
        } else {
            parent[py] = px;
        }
    }
}
