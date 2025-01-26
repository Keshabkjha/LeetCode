class Solution:
    def maximumInvitations(self, favorite: List[int]) -> int:
        n = len(favorite)
        indegree = [0] * n
        for person in favorite:
            indegree[person] += 1

        # Step 1: Find all nodes not in cycles using a queue
        queue = deque([i for i in range(n) if indegree[i] == 0])
        longest_chain = [0] * n

        while queue:
            node = queue.popleft()
            next_node = favorite[node]
            longest_chain[next_node] = max(
                longest_chain[next_node], longest_chain[node] + 1
            )
            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                queue.append(next_node)

        # Step 2: Find the maximum cycle length
        visited = [False] * n
        max_cycle_length = 0

        def find_cycle_length(node):
            current = node
            length = 0
            while not visited[current]:
                visited[current] = True
                current = favorite[current]
                length += 1
            return length

        for i in range(n):
            if not visited[i] and indegree[i] > 0:  # Part of a cycle
                max_cycle_length = max(max_cycle_length, find_cycle_length(i))

        # Step 3: Handle 2-node cycles with chains
        two_node_cycle_contrib = 0
        for i in range(n):
            if favorite[favorite[i]] == i and i < favorite[i]:  # 2-node cycle
                a, b = i, favorite[i]
                two_node_cycle_contrib += longest_chain[a] + longest_chain[b] + 2

        # Step 4: Return the maximum of all configurations
        return max(max_cycle_length, two_node_cycle_contrib)