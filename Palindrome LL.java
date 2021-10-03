class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null)
      return true;
    ListNode middle = findMiddle(head);
    ListNode revHead = findReverse(middle);
    ListNode cur = head;
    while (cur != null && revHead != null) {
      if (cur.val != revHead.val) {
        return false;
      }
      cur = cur.next;
      revHead = revHead.next;
    }
    return true;
  }

  private ListNode findReverse(ListNode middle) {
    if (middle == null || middle.next == null) {
      return middle;
    }
    ListNode p = findReverse(middle.next);
    middle.next.next = middle;
    middle.next = null;
    return p;
  }

  private ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
