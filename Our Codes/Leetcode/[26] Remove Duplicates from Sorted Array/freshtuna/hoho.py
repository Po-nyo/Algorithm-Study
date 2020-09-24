def removeDuplicates(nums) -> int:
    return reduce(
        lambda answer, operand : answer + [operand] if answer[-1] != operand else answer, nums, [nums[0]])
