class Solution {
    private final int[][] DIRCS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> que = new ArrayDeque<>();
        int cost = 0;

        visitFreePath(grid, 0, 0, que);
        while (!que.isEmpty()) {
            int l = que.size();
            for (int k = 0; k < l; ++k) {
                int[] cell = que.poll();

                if (cell[0] == m - 1 && cell[1] == n - 1) {
                    return cost;
                }

                for (int d = 0; d < 4; ++d) {
                    visitFreePath(grid, cell[0] + DIRCS[d][0], cell[1] + DIRCS[d][1], que);
                }
            }
            ++cost;
        }

        return -1;
    }

    private void visitFreePath(int[][] grid, int i, int j, Queue<int[]> que) {
        int m = grid.length;
        int n = grid[0].length;
        while (-1 < i && i < m && -1 < j && j < n && grid[i][j] != 0) {
            int d = grid[i][j] - 1;
            grid[i][j] = 0;

            que.offer(new int[] {i, j});

            i += DIRCS[d][0];
            j += DIRCS[d][1];
        }
    }
}