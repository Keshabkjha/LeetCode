class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        n=len(prices)
        stack=[]
        output=[]
        for i in range(n-1, -1, -1):
            while stack and prices[stack[-1]]>prices[i]:
                stack.pop()
            output.append(prices[i] if not stack else prices[i]-prices[stack[-1]])
            stack.append(i)
        output.reverse()
        return output
        