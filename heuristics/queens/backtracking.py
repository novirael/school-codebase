import time
import copy

class QueenBacktracking(object):
    board = None
    solutions = []
    deep = 0
    start_time = None

    def __init__(self, n):
        self.board = [[0 for _ in range(n)] for _ in range(n)]

    def resolve(self):
        self.start_time = time.time()
        self._try_to_put_queen(0)
        self._preview_board()

    def _try_to_put_queen(self, row):
        self.deep += 1

        max_size = len(self.board)
        print(row >= max_size)
        if row >= max_size:
            self.solutions.append({
                "board": copy.deepcopy(self.board),
                "max_deep": self.deep,
                "duration": time.time() - self.start_time
            })
            self.deep = 0
            self.start_time = time.time()
        else:
            for column in range(max_size):
                if self._can_put_queen(row, column):
                    self.board[row][column] = 1
                    self._try_to_put_queen(row + 1)
                    self.board[row][column] = 0

    def _can_put_queen(self, row, column):
        max_size = len(self.board)

        if any(self.board[row]):
            return False

        if any([self.board[_row][column] for _row in range(max_size)]):
            return False

        if any([self.board[i][i] for i in range(max_size)]):
            return False
        print("Can put on", row, column, self.board)
        return True

    def _preview_board(self):
        for solution in self.solutions:
            for row in solution['board']:
                for column in row:
                    print(str(column) + ' ', end="")
                print()
            print()


if __name__ == "__main__":
    backtracking = QueenBacktracking(4)
    backtracking.resolve()
