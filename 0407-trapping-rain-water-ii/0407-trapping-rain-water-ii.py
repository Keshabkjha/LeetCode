class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        # neighbouring indices of (i, j)
        def nbrs(i, j):
            dirs = [(-1, 0), (0, -1), (1, 0), (0, 1)]
            res = []
            for di, dj in dirs:
                nbri = di + i
                nbrj = dj + j
                if 0<=nbri<m and 0<=nbrj<n:
                    res.append((nbri, nbrj))
            return res
        
        m = len(heightMap)
        n = len(heightMap[0])
        visited = [[False] * n for _ in range(m)]
        pq = []

        # add boundaries to priority queue
        for i in range(n):
            heapq.heappush(pq, (heightMap[0][i], 0, i))
            visited[0][i] = True
        for i in range(1, m):
            heapq.heappush(pq, (heightMap[i][n-1], i, n - 1))
            visited[i][n-1] = True
        for i in range(n - 1):
            heapq.heappush(pq ,(heightMap[m-1][i], m - 1, i))
            visited[m-1][i] = True
        for i in range(1, m - 1):
            heapq.heappush(pq, (heightMap[i][0], i, 0))
            visited[i][0] = True
        
        # perform bfs and compute answer
        ans = 0
        while len(pq) > 0:
            h, i, j = heapq.heappop(pq)
            for ni, nj in nbrs(i, j):
                if visited[ni][nj] is False:
                    if h > heightMap[ni][nj]:
                        ans += h - heightMap[ni][nj]
                        heapq.heappush(pq, (h, ni, nj))
                    else:
                        heapq.heappush(pq, (heightMap[ni][nj], ni, nj))
                    visited[ni][nj] = True
        return ans