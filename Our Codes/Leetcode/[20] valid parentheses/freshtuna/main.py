class Solution:
    def isValid(self, s: str) -> bool:
        # variable
        left_parentheses = ['(', '{', '[']
        right_parentheses = {')': '(', '}': '{', ']': '['}
        stack = []
        
        # input
        s = list(s)

        # call
        for char in s:
            if char in left_parentheses:
                stack.append(char)
            else:
                if len(stack) == 0 or stack[-1] != right_parentheses[char]:
                    return False
                else: stack.pop()
                
        if len(stack) > 0:
            return False
        
        return True


print(Solution().isValid(s="{[]}"))
