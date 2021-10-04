import java.util.*;

class Solution {
  public String fractionToDecimal(long n, long d) {

    StringBuilder sb = new StringBuilder();
    HashMap<Long, Integer> map = new HashMap<>();
    boolean isNeg = false;
    if ((n < 0 && d > 0) || (n > 0 && d < 0)) {
      isNeg = true;
    }
    if (isNeg)
      sb.append('-');
    n = Math.abs(n);
    d = Math.abs(d);
    long q = n / d;
    long r = n % d;
    sb.append(q);
    if (r == 0) {
      return sb.toString();
    } else {
      sb.append('.');
    }
    while (r != 0 && !map.containsKey(r)) {
      map.put(r, sb.length());
      r *= 10;
      q = r / d;
      r = r % d;
      sb.append(q);
    }
    if (map.containsKey(r)) {
      sb.append(')');
      sb.insert((int) map.get(r), '(');
    }
    return sb.toString();
  }
}
