class Trie {

  Node head;

  public Trie() {
    head = new Node('/', false);
  }

  public void insert(String word) {
    Node cur = head;
    for (char ch : word.toCharArray()) {
      if (cur.arr[ch - 'a'] == null) {
        cur.arr[ch - 'a'] = new Node(ch, false);
      }
      cur = cur.arr[ch - 'a'];
    }
    cur.isEndOfWord = true;
  }

  public boolean search(String word) {
    Node cur = head;
    for (char ch : word.toCharArray()) {
      if (cur.arr[ch - 'a'] == null) {
        return false;
      }
      cur = cur.arr[ch - 'a'];
    }
    if (cur.isEndOfWord) {
      return true;
    }
    return false;
  }

  public boolean startsWith(String prefix) {
    Node cur = head;
    for (char ch : prefix.toCharArray()) {
      if (cur.arr[ch - 'a'] == null) {
        return false;
      }
      cur = cur.arr[ch - 'a'];
    }
    return true;
  }
}

class Node {
  char val;
  boolean isEndOfWord;
  Node[] arr = new Node[26];

  Node(char val, boolean isEndOfWord) {
    this.val = val;
    this.isEndOfWord = isEndOfWord;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
