import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> generateParenthesis(int n) {
    ArrayList<String> list = new ArrayList<>();
    backtrack(n, 0, 0, "", list);
    return list;
  }

  private void backtrack(int n, int open, int close, String temp, ArrayList<String> list) {
    if (temp.length() == 2 * n) {
      list.add(temp);
      return;
    }
    if (open < n)
      backtrack(n, open + 1, close, temp + "(", list);
    if (close < open)
      backtrack(n, open, close + 1, temp + ")", list);
  }
}
