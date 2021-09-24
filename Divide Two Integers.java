class Solution {
  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1)
      return Integer.MAX_VALUE;
    boolean isNeg = false;
    if (dividend < 0 || divisor < 0) {
      isNeg = true;
    }
    if (dividend < 0 && divisor < 0) {
      isNeg = false;
    }
    if (dividend > 0)
      dividend = -dividend;
    if (divisor > 0)
      divisor = -divisor;
    int count = 0;
    while (dividend <= divisor) {
      dividend -= divisor;
      count++;
    }
    if (isNeg)
      return -count;
    return count;
  }
}
