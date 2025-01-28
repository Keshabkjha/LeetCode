class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        max_fish = 0
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        def dfs(r: int, c: int) -> int:
            if r < 0 or c < 0 or r >= m or c >= n or grid[r][c] <= 0:
                return 0

            fish_caught = grid[r][c]
            grid[r][c] = 0 
            for dr, dc in directions:
                fish_caught += dfs(r + dr, c + dc)

            return fish_caught

        for i in range(m):
            for j in range(n):
                if grid[i][j] > 0:
                    max_fish = max(max_fish, dfs(i, j))

        return max_fish