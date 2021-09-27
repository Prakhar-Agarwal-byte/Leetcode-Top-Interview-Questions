class Solution {
  public Node copyRandomList(Node head) {
    Node cur = head;
    while (cur != null) {
      Node next = cur.next;
      Node node = new Node(cur.val);
      cur.next = node;
      node.next = next;
      cur = cur.next.next;
    }
    cur = head;
    while (cur != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }
    cur = head;
    Node d = new Node(0);
    Node curD = d;
    while (cur != null) {
      Node rNode = cur.next;
      Node nNode = rNode.next;
      curD.next = rNode;
      cur.next = nNode;
      curD = curD.next;
      cur = nNode;
    }
    return d.next;
  }
}
