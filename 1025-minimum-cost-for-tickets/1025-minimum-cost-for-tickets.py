class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = len(days)
        dp = [-1 for _ in range(n)]
        dp[n-1] = min(costs)
        for i in range(n-2, -1, -1):
            op1 = dp[i+1] + costs[0]
            op2 = costs[1]
            op3 = costs[2]
            is_7_set = False
            for j in range(i+1, n):
                if days[j] >= days[i] + 7 and not is_7_set:
                    op2 += dp[j]
                    is_7_set = True
                if days[j] >= days[i] + 30:
                    op3 += dp[j]
                    break
            dp[i] = min(op1, op2, op3)
        return dp[0]