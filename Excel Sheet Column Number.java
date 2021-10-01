class Solution {
  public int titleToNumber(String str) {
    int res = 0;
    for (int i = 0; i < str.length(); i++) {
      res = res * 26 + (str.charAt(i) - 'A') + 1;
    }
    return res;
  }
}
