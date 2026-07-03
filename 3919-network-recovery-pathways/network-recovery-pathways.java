import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        int m = edges.length;

        // adjacency list: u -> list of [v, cost]
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int[] indeg = new int[n];
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            indeg[e[1]]++;
        }

        // topological order (graph is a DAG)
        int[] topo = new int[n];
        int idx = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) queue.add(i);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo[idx++] = u;
            for (int[] e : adj[u]) {
                if (--indeg[e[0]] == 0) queue.add(e[0]);
            }
        }

        // distinct sorted edge costs -> candidate answers
        int[] costs = new int[m];
        for (int i = 0; i < m; i++) costs[i] = edges[i][2];
        Arrays.sort(costs);
        int uLen = 0;
        int[] uniq = new int[m];
        for (int c : costs) {
            if (uLen == 0 || uniq[uLen - 1] != c) uniq[uLen++] = c;
        }

        int lo = 0, hi = uLen - 1, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (feasible(uniq[mid], adj, online, k, topo, n)) {
                ans = uniq[mid];
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    // Can we reach n-1 from 0 using only edges with cost >= t,
    // only passing through online intermediate nodes, with total cost <= k?
    private boolean feasible(int t, List<int[]>[] adj, boolean[] online, long k, int[] topo, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE / 2);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] >= Long.MAX_VALUE / 2) continue;
            for (int[] e : adj[u]) {
                int v = e[0], cost = e[1];
                if (cost < t) continue;
                // if v is an intermediate node (not the target) and offline, can't pass through
                if (v != n - 1 && !online[v]) continue;
                long nd = dist[u] + cost;
                if (nd < dist[v]) dist[v] = nd;
            }
        }

        return dist[n - 1] <= k;
    }
}