class Solution:
    def removeDuplicates(self, nums) -> int:
        def _removeDuplicates(nums, last=nums[0]):
            for i in range(len(nums)):
                if nums[i] != last:
                    return [last] + _removeDuplicates(nums[i:], nums[i])
            return [last]
        return _removeDuplicates(nums)
    
if __name__ == "__main__":
    s = Solution()
    print(s.removeDuplicates([1, 1, 2]))