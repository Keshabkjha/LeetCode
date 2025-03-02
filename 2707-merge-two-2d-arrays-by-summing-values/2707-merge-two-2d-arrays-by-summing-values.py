class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        nums1.extend(nums2)
        res = []
        counter = {}
        for i in nums1:
            if i[0] in counter:
                counter[i[0]] += i[1]
            else:
                counter[i[0]] = i[1]

        for i in counter:
            res.append([i, counter[i]])
        
        return sorted(res)