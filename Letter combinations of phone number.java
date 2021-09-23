import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
  public List<String> letterCombinations(String digits) {
    ArrayList<String> list = new ArrayList<>();
    if (digits.length() == 0)
      return list;
    HashMap<Integer, String> map = new HashMap<>();
    map.put(2, "abc");
    map.put(3, "def");
    map.put(4, "ghi");
    map.put(5, "jkl");
    map.put(6, "mno");
    map.put(7, "pqrs");
    map.put(8, "tuv");
    map.put(9, "wxyz");
    backtrack(digits, "", 0, map, list);
    return list;
  }

  private void backtrack(String digits, String temp, int index, HashMap<Integer, String> map, ArrayList<String> list) {
    if (temp.length() == digits.length()) {
      list.add(temp);
      return;
    }
    for (int i = index; i < digits.length(); i++) {
      for (char ch : map.get(digits.charAt(i) - '0').toCharArray()) {
        backtrack(digits, temp + ch, i + 1, map, list);
      }
    }
  }
}
