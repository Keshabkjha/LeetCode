class Solution:
    def xorAllNums(self, nums1: list[int], nums2: list[int]) -> int:
        ans = 0
        n1, n2 = len(nums1), len(nums2)
        sub1, sub2 = 0, 0
        for num in nums1:
            sub1 ^= num
        for num in nums2:
            sub2 ^= num
        if n1 % 2 != 0:
            ans ^= sub2
        if n2 % 2 != 0:
            ans ^= sub1
        return ans