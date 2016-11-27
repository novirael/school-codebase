
class QueenBacktracking(object):
    board = None
    solutions = None
    deep = 0

    def __init__(self, n):
        self.board = [[0 for _ in range(n)] for _ in range(n)]

    def resolve(self):

        if self._try_to_put_queen(0):
            self._preview_board()

    def _try_to_put_queen(self, row):
        self.deep += 1

        max_size = len(self.board)
        print(row >= max_size)
        if row >= max_size:
            return True

        for column in range(max_size):
            if self._can_put_queen(row, column):

                self.board[row][column] = 1
                if self._try_to_put_queen(row + 1):
                    return True
                self.board[row][column] = 0

        return False

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
        for row in self.board:
            for column in row:
                print(str(column) + ' ', end="")
            print()


if __name__ == "__main__":
    backtracking = QueenBacktracking(4)
    backtracking.resolve()
