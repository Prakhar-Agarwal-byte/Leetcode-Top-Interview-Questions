import java.util.Arrays;
import java.util.List;

class Solution {
  int[][] dp;

  public boolean wordBreak(String s, List<String> wordDict) {
    dp = new int[s.length()][s.length()];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }
    return util(s, wordDict, 0, s.length() - 1);
  }

  private boolean util(String s, List<String> wordDict, int i, int j) {
    if (i > j)
      return false;
    if (dp[i][j] == 0) {
      return false;
    }
    if (dp[i][j] == 1) {
      return true;
    }
    if (wordDict.contains(s.substring(i, j + 1)))
      return true;
    boolean flag = false;
    for (int k = i; k < j; k++) {
      if (util(s, wordDict, i, k) && util(s, wordDict, k + 1, j)) {
        flag = true;
      }
    }
    if (flag) {
      dp[i][j] = 1;
    } else {
      dp[i][j] = 0;
    }
    return flag;
  }
}
