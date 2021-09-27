import java.util.*;

class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> list = new ArrayList<>();
    util(0, new ArrayList<String>(), s, list);
    return list;
  }

  private void util(int start, List<String> temp, String s, List<List<String>> list) {
    if (start == s.length()) {
      list.add(new ArrayList<>(temp));
      return;
    }
    for (int i = start; i < s.length(); i++) {
      if (isPalindrome(s.substring(start, i + 1))) {
        temp.add(s.substring(start, i + 1));
        util(i + 1, temp, s, list);
        temp.remove(temp.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
