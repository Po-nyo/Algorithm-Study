class Solution:
    def addBinary(self, a: str, b: str) -> str:
        a, b, up, answer = [list(a)[::-1], list(b)[::-1], 0, []]
        
        if len(a) > len(b): b += (len(a) - len(b)) * ['0']
        else: a += (len(b) - len(a)) * ['0']

        for i in range(len(a)):
            calculated = int(a[i]) + int(b[i]) + up
            
            if calculated >= 2: 
                calculated -= 2
                up = 1
            else: up = 0
            
            answer = [str(calculated)] + answer

        if up == 1: return "".join(['1'] + answer)
        else: return "".join(answer)

if __name__ == "__main__":
    s = Solution()
    print(s.addBinary("0", "0"))
