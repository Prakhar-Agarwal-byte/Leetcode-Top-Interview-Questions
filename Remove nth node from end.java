class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode d = new ListNode(0);
    d.next = head;
    ListNode slow = d;
    ListNode fast = d;
    while (n-- >= 0) {
      fast = fast.next;
    }
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    return d.next;
  }
}
