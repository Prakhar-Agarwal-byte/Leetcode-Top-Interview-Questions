import java.util.*;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> set = new HashSet<>();
    for (String s : wordList) {
      set.add(s);
    }
    if (!set.contains(endWord))
      return 0;
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    set.remove(beginWord);
    int lvl = 1;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String curWord = q.remove();
        char[] chArr = curWord.toCharArray();
        for (int j = 0; j < chArr.length; j++) {
          char ch = chArr[j];
          for (char c = 'a'; c <= 'z'; c++) {
            chArr[j] = c;
            String newWord = String.valueOf(chArr);
            if (newWord.equals(endWord))
              return lvl+1;
            if (set.contains(newWord)) {
              q.add(newWord);
              set.remove(newWord);
            }
          }
          chArr[j] = ch;
        }
      }
      lvl++;
    }
    return 0;
  }
}
