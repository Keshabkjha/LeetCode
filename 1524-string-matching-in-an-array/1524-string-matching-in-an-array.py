class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        temp = ' '.join(words)    # join all words into a single string
        fin = []            
        for i in words:
            if temp.count(i) > 1: # check if word is a substring of others
                fin.append(i)
        return fin