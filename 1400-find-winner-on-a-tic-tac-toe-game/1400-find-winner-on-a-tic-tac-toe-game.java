class Solution {
    int[][] grid;

    public String tictactoe(int[][] moves) {
        grid = new int[3][3];
        char x = 'X';
        for (int[] m : moves) {
            grid[m[0]][m[1]] = x;
            if (x == 'X') {
                x = 'O';
            } else {
                x = 'X';
            }
        }
        if (isWin('X')) {
            return "A";
        }
        if (isWin('O')) {
            return "B";
        }
        for (int[] a : grid) {
            for (int i = 0; i < 3; i++) {
                if (a[i] == 0) {
                    return "Pending";
                }
            }
        }
        return "Draw";
    }

    private boolean isWin(char x) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == x && grid[i][1] == x && grid[i][2] == x) {
                return true;
            }
            if (grid[0][i] == x && grid[1][i] == x && grid[2][i] == x) {
                return true;
            }
        }

        if (grid[0][0] == x && grid[1][1] == x && grid[2][2] == x) {
            return true;
        }
        return grid[2][0] == x && grid[1][1] == x && grid[0][2] == x;
    }
}