public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode d = new ListNode();
    ListNode cur = d;
    int carry = 0;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      int dig = sum % 10;
      carry = sum / 10;
      ListNode node = new ListNode(dig);
      cur.next = node;
      l1 = l1.next;
      l2 = l2.next;
      cur = cur.next;
    }
    while (l1 != null) {
      int sum = l1.val + carry;
      int dig = sum % 10;
      carry = sum / 10;
      ListNode node = new ListNode(dig);
      cur.next = node;
      l1 = l1.next;
      cur = cur.next;
    }
    while (l2 != null) {
      int sum = l2.val + carry;
      int dig = sum % 10;
      carry = sum / 10;
      ListNode node = new ListNode(dig);
      cur.next = node;
      l2 = l2.next;
      cur = cur.next;
    }
    if (carry == 0) {
      return d.next;
    }
    ListNode node = new ListNode(carry);
    cur.next = node;
    return d.next;
  }
}
