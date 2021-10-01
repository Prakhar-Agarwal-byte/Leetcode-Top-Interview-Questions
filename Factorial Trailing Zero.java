class Solution {
  public int trailingZeroes(int n) {
    int res = 0;
    int div = 5;
    while (n / div > 0) {
      res += n / div;
      div *= 5;
    }
    return res;
  }
}
