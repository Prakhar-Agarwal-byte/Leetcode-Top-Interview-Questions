public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        backtrack(s, 0, "", list, wordDict);
        return list;
    }

    private void backtrack(String s, int start, String str, List<String> tempList, List<String> wordDict) {
        if (start == s.length()) {
            tempList.add(str.trim());
        } else {
            for (int i = 0; i < s.length() - start; i++) {
                if (wordDict.contains(s.substring(start, i + start + 1))) {
                    str += s.substring(start, i + start + 1) + " ";
                    backtrack(s, start + i + 1, str, tempList, wordDict);
                    str = str.substring(0, str.length() - (i + 2));
                }
            }
        }
    }
}
