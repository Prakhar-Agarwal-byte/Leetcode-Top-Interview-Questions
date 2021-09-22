class Solution {
  public int myAtoi(String s) {
    int i = 0;
    boolean isNeg = false;
    long num = 0;
    while (i < s.length() && s.charAt(i) == ' ') {
      i++;
    }
    if (i < s.length() && s.charAt(i) == '-') {
      isNeg = true;
      i++;
    } else if (i < s.length() && s.charAt(i) == '+') {
      i++;
    }
    while (i < s.length() && Character.isDigit(s.charAt(i))) {
      num = num * 10 + s.charAt(i) - '0';
      long temp = isNeg ? num * -1 : num;
      if (temp > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (temp < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
      i++;
    }
    if (isNeg) {
      num = num * -1;
    }
    return (int) num;
  }
}
