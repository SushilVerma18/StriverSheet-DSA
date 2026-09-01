import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;
        int litterCount = 0;

        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        // Find starting position and assign IDs to litter
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    startR = r;
                    startC = c;
                }

                if (ch == 'L') {
                    litterId[r][c] = litterCount++;
                }
            }
        }

        // All litter collected
        int targetMask = (1 << litterCount) - 1;

        if (targetMask == 0) {
            return 0;
        }

        /*
         * State = (position, mask, energy)
         */

        int states = m * n * (1 << litterCount) * (energy + 1);

        boolean[] visited = new boolean[states];
        int[] queue = new int[states];

        int head = 0;
        int tail = 0;

        int startState = encode(
                startR,
                startC,
                0,
                energy,
                n,
                litterCount,
                energy
        );

        queue[tail++] = startState;
        visited[startState] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (head < tail) {

            int size = tail - head;

            while (size-- > 0) {

                int state = queue[head++];

                // Decode energy
                int currentEnergy = state % (energy + 1);
                state /= (energy + 1);

                // Decode mask
                int maskBits = (1 << litterCount) - 1;
                int mask = state & maskBits;
                state >>= litterCount;

                // Decode position
                int position = state;

                int r = position / n;
                int c = position % n;

                // Try 4 directions
                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    char cell = classroom[nr].charAt(nc);

                    // Obstacle
                    if (cell == 'X') {
                        continue;
                    }

                    // No energy left
                    if (currentEnergy == 0) {
                        continue;
                    }

                    // Moving costs 1 energy
                    int newEnergy = currentEnergy - 1;
                    int newMask = mask;

                    // Collect litter
                    if (cell == 'L') {
                        int id = litterId[nr][nc];
                        newMask |= (1 << id);
                    }

                    // Reset energy
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    // All litter collected
                    if (newMask == targetMask) {
                        return moves + 1;
                    }

                    int nextState = encode(
                            nr,
                            nc,
                            newMask,
                            newEnergy,
                            n,
                            litterCount,
                            energy
                    );

                    if (!visited[nextState]) {
                        visited[nextState] = true;
                        queue[tail++] = nextState;
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int encode(
            int r,
            int c,
            int mask,
            int energyLeft,
            int n,
            int litterCount,
            int maxEnergy
    ) {
        int position = r * n + c;

        return ((position << litterCount) | mask)
                * (maxEnergy + 1)
                + energyLeft;
    }
}