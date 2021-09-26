class Solution {
  public void solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      if (board[i][0] == 'O') {
        util(i, 0, board);
      }
      if (board[i][board[0].length - 1] == 'O') {
        util(i, board[0].length - 1, board);
      }
    }
    for (int i = 0; i < board[0].length; i++) {
      if (board[0][i] == 'O') {
        util(0, i, board);
      }
      if (board[board.length - 1][i] == 'O') {
        util(board.length - 1, i, board);
      }
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
        if (board[i][j] == '.') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private void util(int i, int j, char[][] board) {
    int[] rM = { -1, 0, 1, 0 };
    int[] cM = { 0, 1, 0, -1 };
    board[i][j] = '.';
    for (int k = 0; k < rM.length; k++) {
      int ii = i + rM[k];
      int jj = j + cM[k];
      if (isValid(ii, jj, board)) {
        util(ii, jj, board);
      }
    }
  }

  private boolean isValid(int i, int j, char[][] board) {
    return i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O';
  }
}
