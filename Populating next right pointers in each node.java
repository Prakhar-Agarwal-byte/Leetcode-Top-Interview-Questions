class Solution {
  public Node connect(Node root) {
    if (root == null) return null;
    Node pre = root;
    Node cur = null;
    while (pre.left != null) {
      cur = pre;
      while (cur != null) {
        cur.left.next = cur.right;
        if (cur.next != null) {
          cur.right.next = cur.next.left;    
        }
        cur = cur.next;
      }
      pre = pre.left;
    }
    return root;
  }
}
