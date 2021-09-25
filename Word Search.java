class Solution {
  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (util(board, word, 1, i, j)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean util(char[][] board, String word, int index, int i, int j) {
    if (index == word.length()) {
      return true;
    }
    int[] row = { -1, 0, 1, 0 };
    int[] col = { 0, 1, 0, -1 };
    for (int k = 0; k < row.length; k++) {
      int ii = row[k] + i;
      int jj = col[k] + j;
      if (isValid(board, word, index, ii, jj)) {
        char temp = board[i][j];
        board[i][j] = '.';
        if (util(board, word, index + 1, ii, jj)) {
          return true;
        }
        board[i][j] = temp;
        ;
      }
    }
    return false;
  }

  private boolean isValid(char[][] board, String word, int index, int i, int j) {
    return i >= 0 && i < board.length && j >= 0 && j < board[0].length && index < word.length()
        && word.charAt(index) == board[i][j] && board[i][j] != '.';
  }
}
