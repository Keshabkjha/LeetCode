class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        n = len(s)
        s_list = list(s)
        shift_list = [0] * (n+1)
        for start, end, direction in shifts:
            if direction == 0:
                shift_list[start] -= 1
                shift_list[end+1] += 1
            else:
                shift_list[start] += 1
                shift_list[end+1] -= 1
        
        count = 0
        for i in range(n):
            count += shift_list[i]
            count %= 26
            if ord(s_list[i]) + count > ord('z'):
                count -= 26
            
            s_list[i] = chr(ord(s_list[i])+count)

        return "".join(s_list)

        