import math

class Solution:
    def climbStairs(self, n: int) -> int:
        count, two_step_count = [1, 1]
        
        while(two_step_count * 2 <= n):
            real_n_count = n - two_step_count
            count += math.factorial(real_n_count) \
                // math.factorial(real_n_count - two_step_count) \
                // math.factorial(two_step_count)
            two_step_count += 1
        
        return count 
