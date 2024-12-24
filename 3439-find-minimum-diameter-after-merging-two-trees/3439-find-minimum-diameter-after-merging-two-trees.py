from collections import deque
from typing import List

class Solution:
    def minimumDiameterAfterMerge(self, edges1: List[List[int]], edges2: List[List[int]]) -> int:
        # Number of nodes in the two trees
        n, m = len(edges1) + 1, len(edges2) + 1
        
        # Compute diameters and radii of the two trees
        d1 = self.get_diameter(n, edges1)
        r1 = (d1 + 1) // 2

        d2 = self.get_diameter(m, edges2)
        r2 = (d2 + 1) // 2

        # Return the minimum possible diameter after merging
        return max(d1, d2, 1 + r1 + r2)

    def get_diameter(self, n: int, edges: List[List[int]]) -> int:
        if n == 1:
            return 0

        # Build the adjacency list for the graph
        graph = [[] for _ in range(n)]
        degree = [0] * n
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
            degree[u] += 1
            degree[v] += 1

        # Initialize leaves (nodes with degree 1)
        leaves = deque(node for node in range(n) if degree[node] == 1)
        remaining_nodes = n
        radius = 0

        # Trim the tree layer by layer until 1 or 2 nodes remain
        while remaining_nodes > 2:
            for _ in range(len(leaves)):
                leaf = leaves.popleft()
                remaining_nodes -= 1
                for neighbor in graph[leaf]:
                    degree[neighbor] -= 1
                    if degree[neighbor] == 1:
                        leaves.append(neighbor)
            radius += 1

        # Return the diameter
        return 2 * radius + (remaining_nodes == 2)