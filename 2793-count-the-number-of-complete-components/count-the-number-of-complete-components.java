import java.util.*;

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (vis[i]) continue;

            int[] res = dfs(i, adj, vis);

            int vertices = res[0];
            int degreeSum = res[1];

            if (degreeSum == vertices * (vertices - 1)) {
                ans++;
            }
        }

        return ans;
    }

    private int[] dfs(int node,
                      List<Integer>[] adj,
                      boolean[] vis) {

        vis[node] = true;

        int vertices = 1;
        int degreeSum = adj[node].size();

        for (int nei : adj[node]) {

            if (!vis[nei]) {

                int[] res = dfs(nei, adj, vis);

                vertices += res[0];
                degreeSum += res[1];
            }
        }

        return new int[]{vertices, degreeSum};
    }
}