class Solution:
    def isPalindrome(self, s: str) -> bool:
        data = []
        reversed_data = []
        
        for character in list(s.lower()):
            if (character.isalpha() or 
                character.isdecimal()): data.append(character)
        
        reversed_data = list(reversed(data))
        for i in range(len(data)):
            if data[i] != reversed_data[i]: return False
        return True
