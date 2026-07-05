import java.util.*;

class Solution {

    static final int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int[] row : score)
            Arrays.fill(row, -1);

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                char ch = board.get(i).charAt(j);

                if (ch == 'X')
                    continue;

                if (i == n - 1 && j == n - 1)
                    continue;

                int best = -1;
                int cnt = 0;

                int[][] dir = {
                        {i + 1, j},
                        {i, j + 1},
                        {i + 1, j + 1}
                };

                for (int[] d : dir) {

                    int x = d[0];
                    int y = d[1];

                    if (x >= n || y >= n)
                        continue;

                    if (score[x][y] == -1)
                        continue;

                    if (score[x][y] > best) {
                        best = score[x][y];
                        cnt = ways[x][y];
                    } else if (score[x][y] == best) {
                        cnt = (cnt + ways[x][y]) % MOD;
                    }
                }

                if (best == -1)
                    continue;

                int val = 0;

                if (ch != 'S' && ch != 'E')
                    val = ch - '0';

                score[i][j] = best + val;
                ways[i][j] = cnt;
            }
        }

        if (ways[0][0] == 0)
            return new int[]{0, 0};

        return new int[]{score[0][0], ways[0][0]};
    }
}