import time
import csv
import sys


class QueenBacktracking(object):
    board = None
    deep = 0
    start_time = None
    filewriter = None

    def __init__(self, n):
        self.board = [[0 for _ in range(n)] for _ in range(n)]

    def resolve(self):
        filename = 'queens-backtracking-%d.csv' % len(self.board)
        with open(filename, 'w') as file:
            self.filewriter = csv.writer(file)
            self.filewriter.writerow(['board', 'duration', 'max_deep'])

            self.start_time = time.time()
            self._try_to_put_queen(0)

    def _try_to_put_queen(self, row):
        self.deep += 1

        max_size = len(self.board)
        print(row >= max_size)
        if row >= max_size:
            self._preview_board()
            board_str = '\n'.join([
                ' '.join(map(str, _row))
                for _row in self.board
            ])
            self.filewriter.writerow([
                board_str,
                time.time() - self.start_time,
                self.deep,
            ])
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
        for row in self.board:
            for column in row:
                print(str(column) + ' ', end="")
            print()
        print()


if __name__ == "__main__":
    backtracking = QueenBacktracking(sys.argv[0])
    backtracking.resolve()
