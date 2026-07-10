import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // original index -> position in sorted order
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[arr[i][1]] = i;
        }

        // reach[i] = farthest sorted position reachable in one edge
        int[] reach = new int[n];
        int r = 0;

        for (int i = 0; i < n; i++) {
            while (r + 1 < n &&
                   arr[r + 1][0] - arr[i][0] <= maxDiff) {
                r++;
            }
            reach[i] = r;
        }

        int LOG = 18; // since n <= 1e5
        int[][] up = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            up[0][i] = reach[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int u = pos[queries[i][0]];
            int v = pos[queries[i][1]];

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            // Cannot reach v
            if (up[LOG - 1][u] < v) {
                ans[i] = -1;
                continue;
            }

            int steps = 0;
            int cur = u;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < v) {
                    steps += (1 << k);
                    cur = up[k][cur];
                }
            }

            ans[i] = steps + 1;
        }

        return ans;
    }
}