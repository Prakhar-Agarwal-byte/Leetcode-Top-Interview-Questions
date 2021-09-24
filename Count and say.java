class Solution {
  public String countAndSay(int n) {
    if (n == 1)
      return "1";
    String s = countAndSay(n - 1);
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int j = 0;
    while (j < s.length()) {
      int count = 0;
      while (j < s.length() && s.charAt(i) == s.charAt(j)) {
        j++;
        count++;
      }
      sb.append(count).append(s.charAt(i) - '0');
      i = j;
    }
    return sb.toString();
  }
}
