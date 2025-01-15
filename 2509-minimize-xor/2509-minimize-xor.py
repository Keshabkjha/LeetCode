class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        bin2 = format(num2, '032b')
        count2 = bin2.count("1")

        bin1 = format(num1, '032b')
        count1 = bin1.count("1")

        res = ["0"]*32
        j = 0
        matches = count2
        while(matches and j<len(bin1)):
            if(bin1[j] == "1"):
                res[j] = "1"
                matches -=  1
            j+=1
            
        i = 0
        while(matches and i < 32):
            if res[len(res)- 1 - i] == "0":
                res[len(res)- 1 - i] = "1"
                matches -=1
            i+=1
        ret = "".join(res)

        return int(ret, 2)
        
        