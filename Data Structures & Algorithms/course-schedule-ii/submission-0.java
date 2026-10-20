class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses + 1];
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] i : prerequisites) {
            adj.get(i[0]).add(i[1]);
            indegree[i[1]]++;
        }

        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int v : adj.get(node)) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

         int[] ans = new int[numCourses];


        if(res.size() != numCourses)return new int[]{};

       
        int j = numCourses - 1;
        for(int i : res) {
            ans[j--] = i;
        }

        return ans;
    }
}
