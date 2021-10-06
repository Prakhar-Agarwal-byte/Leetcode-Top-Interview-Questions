import java.util.Arrays;

class Solution {
  public int longestIncreasingPath(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    int[][] dp = new int[n][m];
    for (int[] r : dp) {
      Arrays.fill(r, -1);
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        max = Math.max(max, util(i, j, n, m, matrix, dp));
      }
    }
    return max;
  }

  private int util(int i, int j, int n, int m, int[][] matrix, int[][] dp) {
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    int max = 0;
    for (int[] d : dir) {
      int ii = i + d[0];
      int jj = j + d[1];
      if (ii >= 0 && ii < n && jj >= 0 && jj < m && matrix[ii][jj] > matrix[i][j]) {
        max = Math.max(max, util(ii, jj, n, m, matrix, dp));
      }
    }
    return dp[i][j] = max + 1;
  }
}
