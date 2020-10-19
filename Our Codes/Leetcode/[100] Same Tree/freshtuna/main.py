class Solution:
    def make_list(self, p):
        if p == None: return [None]
        else: return [p.val] + self.make_list(p.left) + self.make_list(p.right)
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        return self.make_list(p) == self.make_list(q)
