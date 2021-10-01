import java.util.*;

class Solution {
  public String largestNumber(int[] nums) {
    String[] strA = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strA[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strA, new Comparator<String>() {
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    });
    if (strA[0].equals("0")) return "0";
    StringBuilder sb = new StringBuilder();
    for (String s : strA) {
      sb.append(s);
    }
    return sb.toString();
  }
}
