import collections

class Solution:
    def make_list(self, p):
        deq = collections.deque([p])
        result = []

        while len(deq) > 0:
            node = deq.pop()
            if node is not None:
                result.append(node.val)
                deq.appendleft(node.left)
                deq.appendleft(node.right)
            else:
                result.append(None)
        return result

    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        return self.make_list(p) == self.make_list(q)
