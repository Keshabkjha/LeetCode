class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        group = [0]*(n+1)
        note = {}
        max_group = 0
        for edge in edges:
            if (group[edge[0]] == 0) and (group[edge[1]] == 0):
                max_group += 1
                group[edge[0]] = max_group
                group[edge[1]] = max_group
                note[max_group] = [edge[0], edge[1]]
            elif (group[edge[0]] == 0) or (group[edge[1]] == 0):
                if group[edge[0]] > group[edge[1]]:
                    group[edge[1]] = group[edge[0]]
                    note[group[edge[0]]].append(edge[1])
                else:
                    group[edge[0]] = group[edge[1]]
                    note[group[edge[1]]].append(edge[0])
            elif group[edge[0]] != group[edge[1]]:
                # print(edge)
                target = group[edge[1]]
                for i in note[target]:
                    # print(f"cheking{i}: {group[i]}")
                    group[i] = group[edge[0]]
                note[group[edge[0]]] = note[group[edge[0]]] + note[target]
                # print(note)
            elif group[edge[0]] == group[edge[1]]:
                return edge
            # print(group)

        