import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.println(board[i][j]);
                    System.out.println(word.charAt(0));
                    if (board[i][j] == word.charAt(0) && solve(i, j, "", word, board.length, board[0].length, board)) ans.add(word);
                }
            }
        }
        return ans;
    }

    private boolean solve(int curRow, int curCol, String temp, String word, int maxRow, int maxCol, char[][] board) {
        if (temp.length() == word.length()) {
            return true;
        }

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            if (!isValid(curRow, curCol, maxRow, maxCol, board)) continue;
            char ch = board[curRow][curCol];
            board[curRow][curCol] = '$';
            temp += ch;
            solve(curRow + r[i], curCol + c[i], temp, word, maxRow, maxCol, board);
            board[curRow][curCol] = ch;
            temp = temp.substring(0, temp.length() - 1);
        }

        return false;
    }

    private boolean isValid(int curRow, int curCol, int maxRow, int maxCol, char[][] board) {
        return curRow >= 0 && curRow < maxRow && curCol >= 0 && curCol < maxCol && board[curRow][curCol] != '$';
    }
}
