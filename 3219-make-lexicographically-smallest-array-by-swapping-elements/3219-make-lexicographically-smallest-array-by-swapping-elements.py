class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        n = len(nums)
        aux = sorted([[nums[i], i] for i in range(n)])
        aux2 = [[aux[i][0] for i in range(n)], [aux[i][1] for i in range(n)]]
        l = 0
        for i in range(1, n):
            if aux2[0][i] - aux2[0][i-1] > limit:
                aux2[1][l:i] = sorted(aux2[1][l:i])
                l = i
        aux2[1][l:n] = sorted(aux2[1][l:n])
        for i in range(n):
            nums[aux2[1][i]] = aux2[0][i]
        return nums