class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        servers = 0
        m = len(grid)
        n = len(grid[0])

        rows = [0] * m
        cols = [0] * n

        row,col = 0,0

        for i in grid:
            col = 0
            for j in i:
                if j == 1:
                    # print(row,col)
                    rows[row] += 1
                    cols[col] += 1
                col += 1
            row += 1

        row,col = 0,0
        for i in grid:
            col = 0
            for j in i:
                if j == 1:
                    if rows[row] > 1 or cols[col] > 1:
                        servers += 1
                col += 1
            row += 1

        return servers