class Solution:
    def reverseString(self, s: List[str]) -> None:
        s = self._reverseString(s)
        
    def _reverseString(self, s: List[str]) -> None:
        return self._reverseString(s[1:]) + [s[0]] if len(s) > 0 else []
    
s = Solution()
print(s.reverseString(["h","e","l","l","o"]))
