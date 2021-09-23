class Solution {
  public int strStr(String haystack, String needle) {
    int i = 0;
    int j = needle.length();
    for (; j <= haystack.length(); i++, j++) {
      if (haystack.substring(i, j).equals(needle)) {
        return i;
      }
    }
    return -1;
  }
}
