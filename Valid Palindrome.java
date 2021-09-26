class Solution {
  public boolean isPalindrome(String s) {
    s = s.toLowerCase();
    int left = 0;
    int right = s.length() - 1;
    while (left <= right) {
      if (isAlphaNumeric(s.charAt(left)) && isAlphaNumeric(s.charAt(right))) {
        if (s.charAt(left) != s.charAt(right)) {
          return false;
        }
        left++;
        right--;
      } else if (!isAlphaNumeric(s.charAt(left))) {
        left++;
      } else if (!isAlphaNumeric(s.charAt(right))) {
        right--;
      }
    }
    return true;
  }

  private boolean isAlphaNumeric(char ch) {
    return Character.isAlphabetic(ch) || Character.isDigit(ch);
  }
}
