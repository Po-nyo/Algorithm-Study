def isPalindrome(self, s: str) -> bool:
    new_s=[i for i in s.lower() if i.isalnum()]
    reverse=new_s[::-1]
    return reverse==new_s
