class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        c = 0
        n = len(words)
        for i in range(n):
            for j in range (i+1,n):
                word_i = words[i]
                word_j = words[j]
                if len(word_i) > len(word_j):
                    continue
                if word_j.startswith(word_i) and word_j.endswith(word_i):
                     c += 1
        return c