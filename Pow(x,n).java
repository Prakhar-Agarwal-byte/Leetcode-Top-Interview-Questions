class Solution {
  public double myPow(double x, long n) {
    boolean isNeg = n < 0 ? true : false;
    n = Math.abs(n);
    double ans = 1;
    while (n > 0) {
      if (n % 2 == 0) {
        x = x * x;
        n /= 2;
      } else {
        ans *= x;
        n--;
      }
    }
    if (isNeg) {
      return 1 / ans;
    }
    return ans;
  }
}
