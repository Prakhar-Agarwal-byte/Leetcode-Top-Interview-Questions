class Solution {
  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          util(i, j, grid);
          count++;
        }
      }
    }
    return count;
  }

  private void util(int i, int j, char[][] grid) {
    grid[i][j] = '.';
    int[] iMov = { -1, 0, 1, 0 };
    int[] jMov = { 0, 1, 0, -1 };
    for (int k = 0; k < iMov.length; k++) {
      int ii = i + iMov[k];
      int jj = j + jMov[k];
      if (isValid(ii, jj, grid)) {
        util(ii, jj, grid);
      }
    }
  }

  private boolean isValid(int i, int j, char[][] grid) {
    return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1';
  }
}
