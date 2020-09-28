class Solution:
    def __init__(self, *args, **kwargs):
        self.m = None
        self.n = None
        self.data = None
        self.query = ["t", "e", "e", "m", "o"]

        for key, value in kwargs.items():
            setattr(self, key, value)
        self.answer = [i for i in self.data]

    def call(self):
        for i in range(self.m):
            for j in range(self.n):
                self.trace(i, j)
        self.print()

    def trace(self, i, j):
        _out_of_range = False
        out = 0

        for array in self.trace_arrays(i, j):
            for index, pos in enumerate(array):
                x, y = pos
                if self.out_of_range(x, y): 
                    _out_of_range = True 
                    break
                if not self.correct(index, x, y): out += 1
            # check
            if not _out_of_range and out <= 2: self.bomb(array)
            _out_of_range, out = [False, 0]


    def trace_arrays(self, i, j):
        return [
            [[i, j], [i + 1, j], [i + 2, j], [i + 3, j], [i + 4, j]],
            [[i, j], [i - 1, j], [i - 2, j], [i - 3, j], [i - 4, j]],
            [[i, j], [i, j + 1], [i, j + 2], [i, j + 3], [i, j + 4]],
            [[i, j], [i, j - 1], [i, j - 2], [i, j - 3], [i, j - 4]],
            [[i, j], [i + 1, j + 1], [i + 2, j + 2], [i + 3, j + 3], [i + 4, j + 4]],
            [[i, j], [i - 1, j + 1], [i - 2, j + 2], [i - 3, j + 3], [i - 4, j + 4]],
            [[i, j], [i + 1, j - 1], [i + 2, j - 2], [i + 3, j - 3], [i + 4, j - 4]],
            [[i, j], [i - 1, j - 1], [i - 2, j - 2], [i - 3, j - 3], [i - 4, j - 4]]
        ]

    def print(self):
        for line in self.answer:
            print("".join(line))

    def out_of_range(self, x, y):
        return x < 0 or x >= self.m or y < 0 or y >= self.n
    
    def correct(self, index, i, j):
        return self.data[i][j].lower() == self.query[index]

    def bomb(self, array):
        for pos in array:
            x, y = pos
            self.answer[pos[0]][pos[1]] = "#"
    
if __name__ == "__main__":
    import sys
    m, n = list(map(int, sys.stdin.readline().split()))
    data = []
    for i in range(m):
        data.append(list(sys.stdin.readline())[:-1])
    solution = Solution(m=m, n=n, data=data)
    solution.call()
