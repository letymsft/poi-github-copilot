#migrate the previos sudoku java to a pubic python implementation

def is_valid_sudoku(board):
    for i in range(9):
        row = [0]*9
        col = [0]*9
        block = [0]*9
        for j in range(9):
            if board[i][j] != '.':
                if row[int(board[i][j]) - 1]:
                    return False
                row[int(board[i][j]) - 1] = 1
            if board[j][i] != '.':
                if col[int(board[j][i]) - 1]:
                    return False
                col[int(board[j][i]) - 1] = 1
            RowIndex = 3 * (i // 3)
            ColIndex = 3 * (i % 3)
            if board[RowIndex + j // 3][ColIndex + j % 3] != '.':
                if block[int(board[RowIndex + j // 3][ColIndex + j % 3]) - 1]:
                    return False
                block[int(board[RowIndex + j // 3][ColIndex + j % 3]) - 1] = 1
    return True