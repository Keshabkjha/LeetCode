class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        res = float('inf')
        frist_row = sum(grid[0])
        sec_row = 0

        for i in range(len(grid[0])):
            frist_row -= grid[0][i]
            res = min(res, max(frist_row, sec_row))
            sec_row += grid[1][i]

        return res