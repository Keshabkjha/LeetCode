class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        n = len(derived)
        _xor = derived[0]
        for i in range(1,len(derived)):
            _xor^=derived[i]
        return (_xor==0)